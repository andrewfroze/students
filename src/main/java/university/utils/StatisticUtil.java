package university.utils;

import university.entity.Group;
import university.entity.Subject;
import university.entity.University;

import java.util.ArrayList;
import java.util.List;

public class StatisticUtil {

    public static void showAverageScoreForStudent(String studentName, University university) {
        System.out.printf("Average score for %s is: %.2f%n", studentName,
                university.getStudentByName(studentName).getTotalAverageScore());
    }

    public static void showAverageScoreBySubjectInGroup(University university) {
        Group randomGroup = RandomUtil.getRandomValueFromList(RandomUtil.getRandomValueFromList(university.getFaculties()).getGroups());
        Subject randomSubject = RandomUtil.getRandomValueFromList(new ArrayList<>(randomGroup.getSubjectsForGroup()));
        System.out.printf("Average score by subject %s in %s group on '%s' faculty in '%s' university",
                                          randomSubject, randomGroup.getGroupNumber(), randomGroup.getFacultyName(),
                randomGroup.getUniversityName());
    }
}
