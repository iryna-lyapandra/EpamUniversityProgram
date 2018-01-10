package lesson3;

import java.util.List;


public class Train {
    private int id;
    private String name;
    private List<Station> stations;
    private int vacantSeats;


    public Train(int id, String name, List<Station> stations,  int vacantSeats) {
        this.id = id;
        this.name = name;
        this.stations = stations;
        this.vacantSeats = vacantSeats;
    }

    public Train() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getVacantSeatss() {
        return vacantSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (id != train.id) return false;
        if (vacantSeats != train.vacantSeats) return false;
        if (name != null ? !name.equals(train.name) : train.name != null) return false;
        return stations != null ? stations.equals(train.stations) : train.stations == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (stations != null ? stations.hashCode() : 0);
        result = 31 * result + vacantSeats;
        return result;
    }
}
