package models;

import exceptions.DuplicateEntryInStructureException;
import exceptions.InvalidStringException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Course {
    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private Map<String, Student> studentsByName;

    public Course(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getUserName())) {
//            throw new IllegalArgumentException(String.format(ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE, student.getUserName(), this.getName()));
//            OutputWriter.writeException(String.format(ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE, student.getUserName(), this.getName()));
//            return;
            throw new DuplicateEntryInStructureException(student.getUserName(), this.getName());
        }
        this.studentsByName.put(student.getUserName(), student);
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(studentsByName);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new InvalidStringException();
        }
        this.name = name;
    }
}
