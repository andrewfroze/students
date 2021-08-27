package university.entity;

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
        for (Student student: getAllStudents()) {
            if(student.getName().equals(name)) {
                return student;
            }
        }
        throw new StudentNotFoundException(String.format("There isn't student '%s' in university '%s'", name, universityName));
    }

    @Override
    public String toString() {
        return universityName + faculties;
    }
}
