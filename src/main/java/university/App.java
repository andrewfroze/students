package university;

import static university.entity.FacultyName.*;
import university.entity.University;
import university.utils.DataSetter;

public class App {

    public static void main(String[] args) {
        University bsuUniversity = DataSetter.createUniversityWithRandomStudentInFaculties("BSU", 500, PHYSICAL, BIOLOGICAL, CHEMICAL, ECONOMIC);
        System.out.println(bsuUniversity);
    }
}
