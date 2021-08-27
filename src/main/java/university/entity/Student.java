package university.entity;

import university.exceptions.IllegalScoreException;
import university.exceptions.SubjectNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String universityName;
    private FacultyName facultyName;
    private int group;
    private Map<Subject, List<Integer>> scores;

    public Student(String name, String universityName, FacultyName facultyName, int group) {
        this.name = name;
        this.universityName = universityName;
        this.facultyName = facultyName;
        this.group = group;
        this.scores = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public int getGroup() {
        return group;
    }

    public Map<Subject, List<Integer>> getScores() {
        return scores;
    }

    public double getAverageScoreBySubject(Subject subject) {
        if (scores.containsKey(subject)) {
            return scores.get(subject).stream().mapToInt(i -> i).average()
                    .orElseThrow(() -> new SubjectNotFoundException(String.format("Student %s hasn't marks by subject %s", name, subject)));
        } else {
            throw new SubjectNotFoundException(String.format("Student %s hasn't subject %s", name, subject));
        }
    }

    public void addScoreForSubject(Subject subject, int score) {
        if (score >= 0 && score <= 10) {
            if (scores.containsKey(subject)) {
                scores.get(subject).add(score);
            } else {
                throw new SubjectNotFoundException(String.format("Student %s hasn't subject %s", name, subject));
            }
        } else {
            throw new IllegalScoreException("Score should belong to interval [0; 10]");
        }
    }

    private List<Integer> getAllMarks() {
        List<Integer> marks = new ArrayList<>();
        scores.keySet().forEach(subject -> marks.addAll(scores.get(subject)));
        return marks;
    }

    public double getTotalAverageScore() {
        return getAllMarks().stream().mapToInt(i->i).average()
                .orElseThrow(() -> new IllegalScoreException(String.format("Student %s hasn't marks", name)));
    }

    @Override
    public String toString() {
        return  name;
    }
}
