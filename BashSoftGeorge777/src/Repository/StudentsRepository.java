package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;
import StaticData.SessionData;
import exceptions.DataAlreadyInitializedException;
import exceptions.DataNotInitializedException;
import models.Course;
import models.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class StudentsRepository {
    public boolean isDataInitialized = false;
    private RepositoryFilter repositoryFilter;
    private RepositorySorter repositorySorter;

    private Map<String, Course> courses;
    private Map<String, Student> students;

    public StudentsRepository(RepositoryFilter repositoryFilter, RepositorySorter repositorySorter) {
        this.repositoryFilter = repositoryFilter;
        this.repositorySorter = repositorySorter;
    }

    public void loadData(String fileName) throws IOException {
        if (isDataInitialized) {
            throw new DataAlreadyInitializedException();
//            throw new RuntimeException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
//            System.out.println(ExceptionMessages.DATA_ALREADY_INITIALIZED);
//            return;
        }
        this.students = new LinkedHashMap<>();
        this.courses = new LinkedHashMap<>();
        this.readData(fileName);
    }

    public void unloadData() {
        if (!isDataInitialized) {
            throw new DataNotInitializedException();
//            throw new RuntimeException(ExceptionMessages.DATA_NOT_INITIALIZED);
//            System.out.println(ExceptionMessages.DATA_NOT_INITIALIZED);
//            return;
        }
        this.students = null;
        this.courses = null;
        this.isDataInitialized = false;
    }


    private void readData(String fileName) throws IOException {
        String regex = "([A-Z][a-zA-Z#\\+]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Za-z]+\\d{2}_\\d{2,4})\\s([\\s0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher m;
        String fullpath = SessionData.currentPath + "\\" + fileName;
        List<String> allLines = Files.readAllLines(Paths.get(fullpath));


        for (String currentLine : allLines) {
            m = pattern.matcher(currentLine);

            if (m.find() && !currentLine.isEmpty()) {
                String courseName = m.group(1);
                String studentName = m.group(2);
                String scoresString = m.group(3);

                try {
                    int[] scores = Arrays.stream(scoresString.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                    if (Arrays.stream(scores).anyMatch(x -> x > 100 || x < 0)) {
                        OutputWriter.writeException(ExceptionMessages.INVALID_SCORE);
                        continue;
                    }
                    if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
                        OutputWriter.writeException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
                        continue;
                    }

                    if (!this.students.containsKey(studentName)) {
                        this.students.put(studentName, new Student(studentName));
                    }
                    if (!this.courses.containsKey(courseName)) {
                        this.courses.put(courseName, new Course(courseName));
                    }

                    Student student = this.students.get(studentName);
                    Course course = this.courses.get(courseName);
                    student.enrollInCourse(course);
                    student.setMarkOnCourse(courseName, scores);
                    course.enrollStudent(student);
                } catch (NumberFormatException nfe) {
                    OutputWriter.writeException(nfe.getMessage());
                }
            }
        }

        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read.");
    }

    private void addInfo(String[] splittedLine) {
        String course = splittedLine[0];
        String student = splittedLine[1];
        int grade = Integer.parseInt(splittedLine[2]);

        if (!this.courses.containsKey(course)) {
            this.courses.put(course, new Course(course));
        }
        if (!this.courses.get(course).getStudentsByName().containsKey(student)) {
            this.courses.get(course).getStudentsByName().put(student, new Student(student));
        }
        this.courses.get(course).getStudentsByName().get(student).setMarkOnCourse(course, grade);
    }

    private boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.writeException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }
        if (!this.courses.containsKey(courseName)) {
            OutputWriter.writeException(ExceptionMessages.NON_EXISTING_COURSE);
            return false;
        }
        return true;
    }

    private boolean isQueryForStudentPossible(String course, String student) {
        if (!isQueryForCoursePossible(course)) {
            return false;
        }
        if (!this.courses.get(course).getStudentsByName().containsKey(student)) {
            OutputWriter.writeException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }
        return true;
    }

    public void getStudentMarkInCourse(String course, String student) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }
        Double mark = this.courses.get(course).getStudentsByName().get(student).getMarksByCourse().get(course);
        OutputWriter.printStudent(student, mark);
    }

    public void getStudentsByCourse(String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }
        Map<String, Student> studentsByName = this.courses.get(course).getStudentsByName();
        for (Map.Entry<String, Student> currentStudent : studentsByName.entrySet()) {
            this.getStudentMarkInCourse(course, currentStudent.getKey());
        }
    }

    public void filterAndTake(String courseName, String filter) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        this.filterAndTake(courseName, filter, studentsToTake);
    }

    public void orderAndTake(String courseName, String orderType) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        this.orderAndTake(courseName, orderType, studentsToTake);
    }

    public void orderAndTake(String courseName, String orderType, int studentsToTake) {
        if (!this.isQueryForCoursePossible(courseName)) {
            return;
        }

        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry :
                this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourse().get(courseName));
        }

        this.repositorySorter.printSortedStudents(orderType, studentsToTake, marks);
    }

    public void filterAndTake(String courseName, String filter, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }

        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry :
                this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue()
                    .getMarksByCourse().get(courseName));
        }

        this.repositoryFilter.printFilteredStudents(filter, studentsToTake, marks);
    }

}
