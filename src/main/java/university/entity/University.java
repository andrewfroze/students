package university.entity;

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
        faculties.add(new Faculty(facultyName));
        return this;
    }

    public University addFacultyWithGroups(FacultyName facultyName, int numberOfGroups) {
        faculties.add(new Faculty(facultyName, numberOfGroups));
        return this;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        faculties.forEach(faculty -> students.addAll(faculty.getAllStudents()));
        return students;
    }

    @Override
    public String toString() {
        return universityName + faculties;
    }
}
