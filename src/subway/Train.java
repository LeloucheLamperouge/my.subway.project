package subway;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static subway.Carriage.TypeOfCarriage.HEAD;

/**
 * Created by Lelouch on 04.04.2017.
 */
@DatabaseTable(tableName = "trains")
public class Train {
    public static final int NUM_OF_CARRIAGES = 5;

    @DatabaseField(id = true)
    int trainId;

    LinkedList<Carriage> carriageList;

    public Train(int trainId) {
        this.trainId = trainId;
        this.carriageList = new LinkedList<>();
    }
    public void addCarriage(Carriage carriage){
        carriageList.add(carriage);
    }//TODO : create logic of carriage adding
    public boolean trainIsReady(){
        return carriageList.size() == NUM_OF_CARRIAGES;
    }
    public boolean headCarriageExpect(){
        return carriageList.isEmpty() || carriageList.size() == 4;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public List<Carriage> getCarriageList() {
        return carriageList;
    }

    public void setCarriageList(LinkedList<Carriage> carriageList) {
        this.carriageList = carriageList;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", carriageList=" + carriageList +
                '}';
    }
}
