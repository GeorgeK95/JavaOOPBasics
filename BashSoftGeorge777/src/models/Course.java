package models;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Course {
   public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
   public static final int MAX_SCORE_ON_EXAM_TASK = 100;
    String name;
    Map<String, Student> studentsByName;

    public Course(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }

   public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getUserName())) {
            OutputWriter.writeException(String.format(ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE, student.getUserName(), this.getName()));
            return;
        }
        this.studentsByName.put(student.getUserName(), student);
    }

    public Map<String, Student> getStudentsByName() {
        return studentsByName;
    }

    public void setStudentsByName(Map<String, Student> studentsByName) {
        this.studentsByName = studentsByName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
