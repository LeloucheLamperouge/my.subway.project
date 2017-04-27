package subway;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import java.util.concurrent.PriorityBlockingQueue;


/**
 * Created by Lelouch on 04.04.2017.
 */
public class SubwayMain {

    private static final Logger loggger = LogManager.getLogger(SubwayMain.class.getName());


    public static void main(String[] args) throws InterruptedException {


        LinkedList<Carriage> depot = new LinkedList<>();
        for (int i = 0; i < 150; i++) {
            Carriage carriage = new Carriage(i, 30, (i % 3 == 0) ?
                    Carriage.TypeOfCarriage.HEAD : Carriage.TypeOfCarriage.PASSENGER);
            depot.add(carriage);
        }
        // System.out.println(depot);


        LinkedList<Train> trains = new LinkedList<>();
        Train train = new Train(0);
        LinkedList<Carriage> notReadyTrain = new LinkedList<>();

        while (!depot.isEmpty()) {
            Carriage carrInTrain = depot.removeFirst();
            if ((carrInTrain.isHead() && train.headCarriageExpect())
                    || (!carrInTrain.isHead() && !train.headCarriageExpect())) {
                train.getCarriageList().add(carrInTrain);
            } else {
                depot.addLast(carrInTrain);
            }
            if (train.trainIsReady()) {
                trains.addLast(train);
                for (int i = 0; i < trains.size(); i++) {
                    train = new Train(i);
                }
            }
            if (!train.trainIsReady()) {
                carrInTrain = depot.removeFirst();
                notReadyTrain.addLast(carrInTrain);
            }
        }
        System.out.println(trains);
        System.out.println(notReadyTrain);

        Driver driver = new Driver(1, "Ezio");
        Driver driver1 = new Driver(2, "Shay");
        Driver driver2 = new Driver(3, "Altair");

        Comparator<Driver> driverComparator = new Comparator<Driver>() {
            @Override
            public int compare(Driver o1, Driver o2) {
                if (o1.getDriverExp() < o2.getDriverExp()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };


        PriorityBlockingQueue<Driver> driverQueue = new PriorityBlockingQueue<Driver>(3, driverComparator);
        driverQueue.put(driver);
        driverQueue.put(driver1);
        driverQueue.put(driver2);


        for (Train t : trains
                ) {
            Driver drivers = driverQueue.take();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    drivers.driverExpUp();
                    driverQueue.add(drivers);
                    //loggger.info("It's info message :" + drivers.getDriverName());
                    //System.out.println(drivers);
                }
            }).start();
        }


        LinkedList<Passenger> lobby = new LinkedList<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Passenger passenger = new Passenger(1);
                    lobby.addFirst(passenger);
                    System.out.println("Passenger " + passenger.hashCode() + " entered to lobby");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }

        }).start();


        Station station = new Station(1);
        Escalator escalator = new Escalator(lobby, station, 1);
        Escalator escalator1 = new Escalator(lobby, station, 2);
        Escalator escalator2 = new Escalator(lobby, station, 3);
        new Thread(escalator).start();
        new Thread(escalator1).start();
        new Thread(escalator2).start();


        Line redLine = new Line(1, "RedLine");
        Line greenLine = new Line(1, "GreenLine");
        Line blueLine = new Line(3, "BlueLine");



    }

}


