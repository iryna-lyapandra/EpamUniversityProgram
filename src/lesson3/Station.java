package lesson3;

import java.time.LocalTime;
import java.util.ArrayList;

public class Station {
    private String name;
    private LocalTime arrivalTime;
    private LocalTime departureTime;


    public Station(String name, LocalTime arrivalTime, LocalTime departureTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public static ArrayList<Station> getStationsByCity(ArrayList<Station> allStations, String city){
        ArrayList<Station> result = new ArrayList<>();
        for (Station s : allStations){
            if (s.getName().equals(city)){
                result.add(s);
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (name != null ? !name.equals(station.name) : station.name != null) return false;
        if (arrivalTime != null ? !arrivalTime.equals(station.arrivalTime) : station.arrivalTime != null) return false;
        return departureTime != null ? departureTime.equals(station.departureTime) : station.departureTime == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        return result;
    }
}
