package subway;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;



/**
 * Created by Lelouch on 04.04.2017.
 */
@DatabaseTable(tableName = "carriages")
public class Carriage {

    @DatabaseField(id = true)
    int carriageId;
    @DatabaseField()
    int numberOfSeats;

    TypeOfCarriage typeOfCarriage;

    public enum TypeOfCarriage  {
       HEAD("locomotive"), PASSENGER("passenger");
        private final String description;

        TypeOfCarriage(String description) {
            this.description = description;
        }

    }


    public Carriage(int carriageId) {
        this.carriageId = carriageId;
    }

    public Carriage(int carriageId,int numberOfSeats, TypeOfCarriage typeOfCarriage) {
        this.carriageId = carriageId;
        this.typeOfCarriage = typeOfCarriage;
        this.numberOfSeats = numberOfSeats;
    }

    public int getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(int carriageId) {
        this.carriageId = carriageId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public TypeOfCarriage getTypeOfCarriage() {
        return typeOfCarriage;
    }

    public void setTypeOfCarriage(TypeOfCarriage typeOfCarriage) {
        this.typeOfCarriage = typeOfCarriage;
    }
    public boolean isHead(){
        if (typeOfCarriage == TypeOfCarriage.HEAD){
            return true;
        }
      return false;
    }

    @Override
    public String toString() {
        return String.format
                ("Carriage{carriageId=%d, nuber of seats=%d, typeOfCarriage=%s}",
                        carriageId, numberOfSeats,typeOfCarriage.description);
    }
}
