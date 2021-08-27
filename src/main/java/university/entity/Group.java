package university.entity;

import java.util.*;

public class Group {
    private int groupNumber;
    private FacultyName facultyName;
    private List<Student> students = new ArrayList<>();
    private Set<Subject> subjectsForGroup = new HashSet<>();

    public Group(FacultyName facultyName, int groupNumber) {
        this.groupNumber = groupNumber;
        this.facultyName = facultyName;
    }

    public void addStudent(String name) {
        students.add(new Student(name, this.facultyName, this.groupNumber));
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

    @Override
    public String toString() {
        return groupNumber + "\n" + students + "\n";
    }
}
