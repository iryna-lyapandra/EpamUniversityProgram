package lesson3;

import java.time.LocalTime;
import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {
        //initialize all needed stations by once
        ArrayList<Station> allStations = initializeStations();
        ArrayList<Train> trainDatabase = initializeTrainArrayList(allStations);
        TrainFinder finder = new TrainFinder();
        //first task. Finding trains by stations
        ArrayList<Train> resultFindByStation = finder.findTrainsByStation(trainDatabase, allStations, "ternopil",  "kyiv");
        if (resultFindByStation.size()>0){
            System.out.println("\nThe trains found between stations ternopil and kyiv:" );
        }
        else {
            System.out.println("\nSorry, no trains found between stations ternopil and kyiv:");
        }
        printTrains(resultFindByStation);

        //second task. Finding trains by stations and after certain time
        ArrayList<Train> resultFindByTimeAndStation = finder.findTrainsByDepartingTimeAndStation(trainDatabase, allStations, "kharkiv",  "odessa", LocalTime.parse("09:00"));
        if (resultFindByTimeAndStation!= null || resultFindByTimeAndStation.size()>0){
            System.out.println("\nThe trains found after " + LocalTime.parse("09:00") + " between stations :" );
        }
        else {
            System.out.println("\nSorry, no trains found after " + LocalTime.parse("09:00") + " between stations :");
        }
        printTrains(resultFindByTimeAndStation);

        //third task. Finding trains by vacant seats and location

    }

    // a universal method that prints off name of each train of the passed ArrayList
    public static void printTrains(ArrayList<Train> trainsToPrint) {
        for (Train t : trainsToPrint) {
            System.out.println(t.getName());
        }
    }

    public static ArrayList<Station> initializeStations() {
        ArrayList<Station> stationArrayList = new ArrayList<Station>();
        Station lviv = new Station("lviv", LocalTime.parse("09:00"), LocalTime.parse("09:32"));
        Station ternopil = new Station("ternopil", LocalTime.parse("11:52"), LocalTime.parse("12:00"));
        Station vinnytsya = new Station("vinnytsya", LocalTime.parse("14:32"), LocalTime.parse("14:38"));
        Station kyiv = new Station("kyiv", LocalTime.parse("18:36"), LocalTime.parse("18:50"));
        stationArrayList.add(lviv);
        stationArrayList.add(ternopil);
        stationArrayList.add(vinnytsya);
        stationArrayList.add(kyiv);

        Station kharkiv = new Station("kharkiv", LocalTime.parse("09:00"), LocalTime.parse("09:32"));
        Station donetsk = new Station("donetsk", LocalTime.parse("11:52"), LocalTime.parse("12:00"));
        Station melitopol = new Station("melitopol", LocalTime.parse("14:32"), LocalTime.parse("14:38"));
        Station odessa = new Station("odessa", LocalTime.parse("18:36"), LocalTime.parse("18:50"));
        stationArrayList.add(kharkiv);
        stationArrayList.add(donetsk);
        stationArrayList.add(melitopol);
        stationArrayList.add(odessa);

        System.out.println("All stations have been initialized");
        return stationArrayList;
    }

    public static ArrayList<Train> initializeTrainArrayList(ArrayList<Station> allStations) {
        ArrayList<Train> initializedTrains = new ArrayList<Train>();

        ArrayList<Station> stationsGroup1 = new ArrayList<Station>(allStations.subList(0, 4));
        ArrayList<Station> stationsGroup2 = new ArrayList<Station>(allStations.subList(4, 8));

        Train lvivKyiv = new Train(111, "Lviv-Kyiv", stationsGroup1, 100);
        initializedTrains.add(lvivKyiv);

        Train kharkivOdessa = new Train(222, "Kharkiv-Odessa", stationsGroup2, 85);
        initializedTrains.add(kharkivOdessa);

        System.out.println("All trains have been initialized");
        return initializedTrains;
    }
}

