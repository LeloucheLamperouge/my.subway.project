package subway;

import java.util.LinkedList;


/**
 * Created by Lelouch on 08.04.2017.
 */
public class Escalator implements Runnable {


    LinkedList<Passenger> escalatorPassenger;

    Station station;
    int escalatorId;




    @Override
    public  void run() {

        while (true) {
            synchronized (escalatorPassenger) {
                if (escalatorPassenger.isEmpty()) {
                    try {
                        escalatorPassenger.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    station.setPassengerFromEscalator(escalatorPassenger.pollFirst());
                    System.out.println("Passenger " + escalatorPassenger.hashCode()
                            + " entered from escalator " + escalatorId);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public int getEscalatorId() {
        return escalatorId;
    }

    public void setEscalatorId(int escalatorId) {
        this.escalatorId = escalatorId;
    }

    public Escalator(LinkedList<Passenger> escalatorPassenger, Station station, int escalatorId) {
        this.escalatorPassenger = escalatorPassenger;
        this.station = station;
        this.escalatorId = escalatorId;

    }

    public LinkedList<Passenger> getEscalatorPassenger() {
        return escalatorPassenger;
    }

    public void setEscalatorPassenger(LinkedList<Passenger> escalatorPassenger) {
        this.escalatorPassenger = escalatorPassenger;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Escalator{" +
                "escalatorPassenger=" + escalatorPassenger +
                ", stationPassenger=" + station +
                '}';
    }


}
