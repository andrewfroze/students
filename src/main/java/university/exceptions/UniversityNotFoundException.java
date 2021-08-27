package university.exceptions;

public class UniversityNotFoundException extends RuntimeException{
    public UniversityNotFoundException(String str){
        super(str);
    }
}
