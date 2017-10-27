package Repository;

import IO.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RepositorySorter {
    public void printSortedStudents(String compareType, int studentsCount, HashMap<String, Double> studentsWithMarks) {

        Comparator<? super Map.Entry<String, Double>> comparator = (Comparator<Map.Entry<String, Double>>) (o1, o2) -> o1.getValue().compareTo(o2.getValue());

        List<String> sortedStudents = studentsWithMarks.entrySet().stream().sorted(comparator).limit(studentsCount).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (compareType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }
        for (String currentStudent : sortedStudents) {
            OutputWriter.printStudent(currentStudent, studentsWithMarks.get(currentStudent));
        }
    }


}
