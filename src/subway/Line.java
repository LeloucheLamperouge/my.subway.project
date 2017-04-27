package subway;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lelouch on 04.04.2017.
 */
@DatabaseTable(tableName = "lines")
public class Line {
    @DatabaseField(id = true)
    int lineId;
    @DatabaseField()
    String lineName;

    List<Station> stations;
    List<Train> trains;

    public Line(int lineId, String lineName) {
        this.lineId = lineId;
        this.lineName = lineName;
        this.stations = new ArrayList<>();
        this.trains = new ArrayList<>();
    }
    public void addStation(Station station){
        stations.add(station);
    }
    public void addTrain(Train train){
        trains.add(train);
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineId=" + lineId +
                ", lineName='" + lineName + '\'' +
                ", stations=" + stations +
                ", trains=" + trains +
                '}';
    }
}
