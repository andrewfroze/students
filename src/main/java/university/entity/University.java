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
        Arrays.stream(faculties).forEach(facultyName -> this.faculties.add(new Faculty(facultyName)));
    }

    public void addFaculty(FacultyName facultyName) {
        faculties.add(new Faculty(facultyName));
    }
}
