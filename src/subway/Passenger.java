package subway;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Lelouch on 04.04.2017.
 */
@DatabaseTable(tableName = "passengers")
public class Passenger {
    @DatabaseField(id = true)
    long passengerId;

    public Passenger(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                '}';
    }
}
