package by.bsuir.airline.report;

import by.bsuir.airline.entity.Plane;
import by.bsuir.airline.exception.ReportException;


import java.io.*;
import java.util.List;

/**
 * Created by Maria Teseiko on 24.11.2015.
 */

public class PlaneReport {

    public static void print(String message, List<Plane> planes, String file) throws ReportException {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true))) {
            printWriter.println(message);
            for (Plane plane: planes) {
                printWriter.println(plane.getClass().getSimpleName() + "[" + plane + "]");
            }
        } catch (IOException e) {
            throw new ReportException("Error occurred while writing to " + file + " file");
        }

    }

    public static void print(String message, int parameter, String file) throws ReportException {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true))) {
            printWriter.println(message + ": " + parameter);
        } catch (IOException e) {
            throw new ReportException("Error occurred while writing to " + file + " file");
        }
    }

}
