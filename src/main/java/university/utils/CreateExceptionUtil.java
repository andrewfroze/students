package university.utils;

import university.entity.FacultyName;
import university.entity.Subject;
import university.entity.University;

public class CreateExceptionUtil {

    public static void causeIllegalScoreException(University university) {
        try {
            RandomUtil.getRandomValueFromList(university.getAllStudents()).addMarkForSubject(Subject.PHYSICS, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void causeSubjectsNotFoundException() {
        try {
            RandomUtil.getRandomValueFromList(
                    DataSetter.createUniversityWithoutSubjects(
                            "UniversityWithoutSubjects", 20,
                            FacultyName.PHYSICAL, FacultyName.BIOLOGICAL).getAllStudents()).checkStudentSubjects();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void causeStudentsNotFoundException() {
        try {
            RandomUtil.getRandomValueFromList(
                    RandomUtil.getRandomValueFromList(
                            DataSetter.createUniversityWithoutStudents().getFaculties())
                            .getGroups()).checkStudentsInGroup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void causeGroupsNotFoundException() {
        try {
            RandomUtil.getRandomValueFromList(
                    DataSetter.createUniversityWithoutGroups("UniversityWithoutGroups",
                            FacultyName.PHYSICAL, FacultyName.CHEMICAL).getFaculties()).checkFacultyGroups();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void causeFacultyNotFoundException() {
        try {
            DataSetter.createEmptyUniversity("EmptyUniversity").checkUniversityFaculties();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
