package university.entity;

import university.exceptions.IllegalScoreException;
import university.exceptions.SubjectNotFoundException;

import java.util.*;

public class Group {
    private int groupNumber;
    private FacultyName facultyName;
    private String universityName;
    private List<Student> students = new ArrayList<>();
    private Set<Subject> subjectsForGroup = new HashSet<>();

    public Group(String universityName, FacultyName facultyName, int groupNumber) {
        this.groupNumber = groupNumber;
        this.facultyName = facultyName;
        this.universityName = universityName;
    }

    public void addStudent(String name) {
        students.add(new Student(name, this.universityName, this.facultyName, this.groupNumber));
    }

    public String getUniversityName() {
        return universityName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public Set<Subject> getSubjectsForGroup() {
        return subjectsForGroup;
    }

    public void addSubjectsForGroup(Subject... subjects){
        subjectsForGroup.addAll(Arrays.asList(subjects));
        for(Student student: students) {
            Arrays.stream(subjects).forEach(subject -> {
                if (!student.getScores().containsKey(subject)) {
                    student.getScores().put(subject, new ArrayList<>());
                }
            });
        }
    }

    public double getAverageScoreBySubject(Subject subject) {
        if (subjectsForGroup.contains(subject)) {
            List<Integer> allMarks = new ArrayList<>();
            students.forEach(student -> allMarks.addAll(student.getScores().get(subject)));
            return allMarks.stream().mapToInt(i -> i).average().orElseThrow(() ->
                    new IllegalScoreException(String.format("There are no marks by subject %s in %s group on '%s' faculty in '%s' university",
                            subject, groupNumber, facultyName, universityName)));
        } else {
            throw new SubjectNotFoundException(String.format("There isn't subject %s in %s group on '%s' faculty in '%s' university",
                    subject, groupNumber, facultyName, universityName));
        }
    }

    @Override
    public String toString() {
        return groupNumber + "\n" + students + "\n";
    }
}
