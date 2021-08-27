package university.utils;

import university.entity.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DataSetter {
    private static final int numberOfGroupsForEachFaculty = 5;

    public static University createUniversityWithRandomStudentInFaculties(String universityName, int studentsNumber, FacultyName... faculties) {
        University university = new University(universityName);
        for (FacultyName facultyName : faculties) {
            university.addFacultyWithGroups(facultyName, numberOfGroupsForEachFaculty);
        }
        fillUniversityWithStudents(university, studentsNumber);
        setRandomSubjects(university);
        setScoresForAllStudents(university);
        return university;
    }

    public static void fillUniversityWithStudents(University university, int studentsNumber) {
        for (int i = 1; i <= studentsNumber; i++) {
            RandomUtil.getRandomValueFromList(
                    RandomUtil.getRandomValueFromList(
                            university.getFaculties()).getGroups()).addStudent("Student_" + i);
        }
    }

    public static void setRandomSubjects(University university) {
        for (Faculty faculty: university.getFaculties()) {
            for (Group group: faculty.getGroups()) {
                Set<Subject> randomSubjects = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    randomSubjects.add(RandomUtil.getRandomValueFromList(Arrays.asList(Subject.values())));
                }
                Subject[] subjects = new Subject[randomSubjects.size()];
                randomSubjects.toArray(subjects);
                group.addSubjectsForGroup(subjects);
            }
        }
    }

    public static void setScoresForAllStudents(University university) {
        for (Student student: university.getAllStudents()) {
            for (Subject subject: student.getScores().keySet()) {
                for (int i = 0; i < 10; i++) {
                    student.getScores().get(subject).add(RandomUtil.getRandomMark());
                }
            }
        }
    }
}
