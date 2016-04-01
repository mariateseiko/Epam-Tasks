package by.bsuir.task2.main;

import by.bsuir.task2.entity.runnable.Car;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ArrayList<Car> cars = new ArrayList<>();
            Random random = new Random();
            for (int i = 1; i <= 8; i++) {
                Car car = new Car(i, random.nextInt(2000));
                cars.add(car);
                new Thread(car).start();
            }
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        }
    }
}
