package models;

import StaticData.ExceptionMessages;
import exceptions.DuplicateEntryInStructureException;
import exceptions.InvalidStringException;
import exceptions.KeyNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Student {
    private String userName;
    private Map<String, Course> enrolledCourses;
    private Map<String, Double> marksByCourse;

    public Student(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourse = new LinkedHashMap<>();
    }

    public void setMarkOnCourse(String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            throw new KeyNotFoundException();
//            OutputWriter.writeException(ExceptionMessages.NOT_ENROLLED_IN_COURSE);
//            return;
        }

        if (Course.NUMBER_OF_TASKS_ON_EXAM < scores.length) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
//            OutputWriter.writeException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
//            return;
        }

        double mark = calculateMark(scores);
        this.marksByCourse.put(courseName, mark);
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        return percentageOfSolvedExam * 4 + 2;
    }

    public void enrollInCourse(Course course) {
        if (this.enrolledCourses.containsKey(course.getName())) {
//            OutputWriter.writeException(String.format(ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE, this.userName, course.getName()));
//            return;
            throw new DuplicateEntryInStructureException(this.userName, course.getName());
        }
        this.enrolledCourses.put(course.getName(), course);
    }

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        if (userName == null || userName.equals("")) {
            throw new InvalidStringException();
        }
        this.userName = userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(enrolledCourses);
    }

    public void setEnrolledCourses(Map<String, Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Map<String, Double> getMarksByCourse() {
        return Collections.unmodifiableMap(marksByCourse);
    }

    public void setMarksByCourse(Map<String, Double> marksByCourse) {
        this.marksByCourse = marksByCourse;
    }
}
