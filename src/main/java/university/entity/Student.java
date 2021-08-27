package university.entity;

import university.exceptions.SubjectNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private FacultyName facultyName;
    private int group;
    private Map<Subject, List<Integer>> scores;

    public Student(String name, FacultyName facultyName, int group) {
        this.name = name;
        this.facultyName = facultyName;
        this.group = group;
        this.scores = new HashMap<>();
    }

    public double getAverageMarkBySubject(Subject subject) throws SubjectNotFoundException {
        if (scores.containsKey(subject)) {
            return scores.get(subject).stream().mapToInt(i -> i).average()
                    .orElseThrow(() -> new SubjectNotFoundException(String.format("Student %s hasn't marks by subject %s", name, subject)));
        } else  {
            throw new SubjectNotFoundException(String.format("Student %s hasn't subject %s", name, subject));
        }
    }
}
