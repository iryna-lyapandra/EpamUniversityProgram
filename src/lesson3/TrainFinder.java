package lesson3;

import java.time.LocalTime;
import java.util.ArrayList;


public class TrainFinder {
    public ArrayList<Train> findTrainsByStation (ArrayList<Train> trains, ArrayList<Station> allStations, String departingStation, String arrivingStation){
        ArrayList <Train> result = new ArrayList<>();
        ArrayList <Station> suitableStations = new ArrayList<>();
        ArrayList <Station> departing = Station.getStationsByCity(allStations, departingStation);
        ArrayList <Station> arriving = Station.getStationsByCity(allStations, arrivingStation);
        for (Station s : departing){
            suitableStations.add(s);
        }
        for (Station a : arriving){
            suitableStations.add(a);
        }

        ArrayList <Station> trainStations = new ArrayList<Station>();
        for (Train t : trains){
            trainStations.clear();
            trainStations.addAll(t.getStations());
            trainStations.retainAll(suitableStations);
            if (trainStations.size()>0){
                result.add(t);
            }
        }
        return result;
    }

    public  ArrayList<Train> findTrainsByDepartingTimeAndStation (ArrayList<Train> trains, ArrayList<Station> allStations,  String departingStation, String arrivingStation, LocalTime earliestSuitableTime){
        ArrayList <Train> result = findTrainsByStation(trains, allStations, departingStation, arrivingStation);
        int indexOfDepartingStation=-1;
        for (Train t : result){
            for (Station s : t.getStations()){
                if (s.getName().equals(departingStation)){
                    indexOfDepartingStation = t.getStations().indexOf(s);
                }
            }
            if (indexOfDepartingStation == -1){
                return null;
            }
            if (t.getStations().get(indexOfDepartingStation).getDepartureTime().isBefore(earliestSuitableTime)){
                result.remove(result.indexOf(t));
            }
        }
        return result;

    }
}
