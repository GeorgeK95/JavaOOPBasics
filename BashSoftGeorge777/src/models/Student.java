package models;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Student {
    String userName;
    Map<String, Course> enrolledCourses;
    Map<String, Double> marksByCourse;

    public Student(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourse = new LinkedHashMap<>();
    }

    public void setMarkOnCourse(String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            OutputWriter.writeException(ExceptionMessages.NOT_ENROLLED_IN_COURSE);
            return;
        }

        if (Course.NUMBER_OF_TASKS_ON_EXAM < scores.length) {
            OutputWriter.writeException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
            return;
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
            OutputWriter.writeException(String.format(ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE, this.userName, course.getName()));
            return;
        }
        this.enrolledCourses.put(course.getName(), course);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(Map<String, Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Map<String, Double> getMarksByCourse() {
        return marksByCourse;
    }

    public void setMarksByCourse(Map<String, Double> marksByCourse) {
        this.marksByCourse = marksByCourse;
    }
}
