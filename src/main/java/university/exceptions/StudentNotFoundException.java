package university.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String str){
        super(str);
    }
}
