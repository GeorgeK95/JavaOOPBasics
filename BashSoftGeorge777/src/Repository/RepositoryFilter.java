package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.HashMap;
import java.util.function.Predicate;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RepositoryFilter {
    public void printFilteredStudents(String filterType, int studentsCount, HashMap<String, Double> studentsWithMarks) {
        Predicate<Double> filter = createFilter(filterType);

        if (filter == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FILTER);
//            OutputWriter.writeException(ExceptionMessages.INVALID_FILTER);
//            return;
        }

        int studentsPrinted = 0;
        for (String student : studentsWithMarks.keySet()) {
            if (studentsPrinted >= studentsCount) {
                break;
            }

            Double mark = studentsWithMarks.get(student);
            if (filter.test(mark)) {
                OutputWriter.printStudent(student, mark);
                studentsPrinted++;
            }
        }
    }

    private Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return x -> x >= 5;
            case "average":
                return x -> x >= 3.5 && x <= 5;
            case "poor":
                return x -> x < 3.5;
            default:
                return null;
        }
    }

}
