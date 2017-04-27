package subway;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lelouch on 04.04.2017.
 */
@DatabaseTable(tableName = "stations")
public class Station {
    @DatabaseField(id = true)
    int stationId;
    @DatabaseField()
    String stationName;

    List<Passenger> passengers;
    Passenger passengerFromEscalator;



    public Station(int stationId) {
        this.stationId = stationId;
        this.stationName = getStationName();
        this.passengers = new ArrayList<>();
    }
    public void addPasenger(Passenger passenger){
        passengers.add(passenger);

    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Passenger getPassengerFromEscalator() {
        return passengerFromEscalator;
    }

    public void setPassengerFromEscalator(Passenger passengerFromEscalator) {
        this.passengerFromEscalator = passengerFromEscalator;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", stationName='" + stationName + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
