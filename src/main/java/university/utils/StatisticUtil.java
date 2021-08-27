package university.utils;

import university.entity.Group;
import university.entity.Subject;
import university.entity.University;

import java.util.ArrayList;
import java.util.Arrays;

public class StatisticUtil {

    public static void showAverageScoreForStudent(String studentName, University university) {
        System.out.printf("Average score for %s is: %.2f%n", studentName,
                university.getStudentByName(studentName).getTotalAverageScore());
    }

    public static void showAverageScoreByRandomSubjectInRandomGroup(University university) {
        Group randomGroup = RandomUtil.getRandomValueFromList(RandomUtil.getRandomValueFromList(university.getFaculties()).getGroups());
        Subject randomSubject = RandomUtil.getRandomValueFromList(new ArrayList<>(randomGroup.getSubjectsForGroup()));
        System.out.printf("Average score by subject %s in %s group on '%s' faculty in '%s' university is: %.2f%n",
                                          randomSubject, randomGroup.getGroupNumber(), randomGroup.getFacultyName(),
                randomGroup.getUniversityName(), randomGroup.getAverageScoreBySubject(randomSubject));
    }

    public static void showAverageScoreByRandomSubjectInUniversity(University university) {
        Subject randomSubject = RandomUtil.getRandomValueFromList(Arrays.asList(Subject.values()));
        System.out.printf("Average score by subject %s in '%s' university is: %.2f%n",
                randomSubject, university.getUniversityName(), university.getAverageScoreBySubject(randomSubject));
    }
}
