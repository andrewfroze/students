package university.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Faculty {
    private FacultyName facultyName;
    private Map<Integer, List<Student>> groupStudents;

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
        this.groupStudents = new HashMap<>();
    }

    public void addStudentToGroup(Integer groupNumber, Student student) {
        if(groupStudents.containsKey(groupNumber)) {
            groupStudents.get(groupNumber).add(student);
        } else {
            groupStudents.put(groupNumber, Collections.singletonList(student));
        }
    }
}
