package university.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private FacultyName facultyName;
    private List<Group> groups = new ArrayList<>();

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Faculty(FacultyName facultyName, int numberOfGroups) {
        this.facultyName = facultyName;
        if (numberOfGroups >= 0) {
            for (int i = 1; i <= numberOfGroups; i++) {
                groups.add(new Group(this.facultyName, i));
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
}
