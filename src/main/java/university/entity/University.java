package university.entity;

import university.exceptions.FacultyNotFoundException;
import university.exceptions.IllegalScoreException;
import university.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class University {
    private String universityName;
    private List<Faculty> faculties;

    public University(String universityName, FacultyName... faculties) {
        this.universityName = universityName;
        this.faculties = new ArrayList<>();
        Arrays.stream(faculties).forEach(this::addFaculty);
    }

    public String getUniversityName() {
        return universityName;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public University addFaculty(FacultyName facultyName) {
        faculties.add(new Faculty(facultyName, this.universityName));
        return this;
    }

    public University addFacultyWithGroups(FacultyName facultyName, int numberOfGroups) {
        faculties.add(new Faculty(this.universityName, facultyName, numberOfGroups));
        return this;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        faculties.forEach(faculty -> students.addAll(faculty.getAllStudents()));
        return students;
    }

    public Student getStudentByName(String name) {
        for (Student student : getAllStudents()) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new StudentNotFoundException(String.format("There isn't student '%s' in university '%s'", name, universityName));
    }

    public double getAverageScoreBySubject(Subject subject) {
        List<Integer> scoresBySubject = new ArrayList<>();
        getAllStudents().forEach(student -> {
            if (student.getScores().containsKey(subject)) {
                scoresBySubject.addAll(student.getScores().get(subject));
            }
        });
        return scoresBySubject.stream().mapToInt(i -> i).average()
                .orElseThrow(() -> new IllegalScoreException(String.format("There are no scores by subject %s in %s university",
                        subject, universityName)));
    }

    public void checkUniversityFaculties(){
        if(faculties.isEmpty()) {
            throw new FacultyNotFoundException(String.format("University %s hasn't faculties", universityName));
        }
    }

    @Override
    public String toString() {
        return universityName + faculties;
    }
}
