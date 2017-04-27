package subway;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Lelouch on 04.04.2017.
 */
@DatabaseTable(tableName = "drivers")
public class Driver {
    @DatabaseField(id = true)
    int driverId;
    @DatabaseField()
    int driverExp;
    @DatabaseField()
    String driverName;

    List<Train> drivers;

    public Driver(int driverId, String driverName) {
        this.driverId = driverId;
        this.driverExp = driverExp;
        this.driverName = driverName;
        this.drivers = new LinkedList<>();
    }
    public void addDriver(Train train){
        drivers.add(train);
    }
    public void driverExpUpDown(){
        driverExp += (int)(Math.random()*10)-5;
    }
    public void driverExpUp(){
        driverExp += (int)(Math.random()*10);
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getDriverExp() {
        return driverExp;
    }

    public void setDriverExp(int driverExp) {
        this.driverExp = driverExp;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public List<Train> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Train> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverExp=" + driverExp +
                ", driverName='" + driverName + '\'' +
                '}';
    }


}
