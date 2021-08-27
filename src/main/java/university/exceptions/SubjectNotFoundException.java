package university.exceptions;

public class SubjectNotFoundException extends RuntimeException{
    public SubjectNotFoundException(String str){
        super(str);
    }
}
