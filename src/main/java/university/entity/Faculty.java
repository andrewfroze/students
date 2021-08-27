package university.entity;

import university.exceptions.GroupNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private FacultyName facultyName;
    private String universityName;
    private List<Group> groups = new ArrayList<>();

    public Faculty(FacultyName facultyName, String universityName) {
        this.facultyName = facultyName;
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Faculty(String universityName, FacultyName facultyName, int numberOfGroups) {
        this.facultyName = facultyName;
        this.universityName = universityName;
        if (numberOfGroups >= 0) {
            for (int i = 1; i <= numberOfGroups; i++) {
                groups.add(new Group(this.universityName, this.facultyName, i));
            }
        } else {
            throw new NumberFormatException("Number of groups should be positive");
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        groups.forEach(group -> students.addAll(group.getStudents()));
        return students;
    }

    public void checkFacultyGroups() {
        if (groups.isEmpty()) {
            throw new GroupNotFoundException(String.format("There are not groups on %s faculty in %s university",
                    facultyName, universityName));
        }
    }

    @Override
    public String toString() {
        return facultyName + "\n" + groups + "\n";
    }
}
