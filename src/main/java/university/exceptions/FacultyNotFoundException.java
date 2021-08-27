package university.exceptions;

public class FacultyNotFoundException extends RuntimeException{
    public FacultyNotFoundException(String str){
        super(str);
    }
}
