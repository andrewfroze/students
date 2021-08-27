package university;

import static university.entity.FacultyName.*;
import university.entity.University;
import university.exceptions.IllegalScoreException;
import university.exceptions.StudentNotFoundException;
import university.utils.DataSetter;
import university.utils.StatisticUtil;

public class App {
    public static String studentName = "Student_13";

    public static void main(String[] args) throws StudentNotFoundException, IllegalScoreException {
        University bsuUniversity = DataSetter.createUniversityWithRandomStudentInFaculties("BSU", 500, PHYSICAL, BIOLOGICAL, CHEMICAL, ECONOMICAL);
        StatisticUtil.showAverageScoreForStudent(studentName, bsuUniversity);
        StatisticUtil.showAverageScoreByRandomSubjectInRandomGroup(bsuUniversity);
        StatisticUtil.showAverageScoreByRandomSubjectInUniversity(bsuUniversity);

    }
}
