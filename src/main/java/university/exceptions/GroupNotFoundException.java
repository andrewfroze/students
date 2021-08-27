package university.exceptions;

public class GroupNotFoundException extends RuntimeException{
    public GroupNotFoundException(String str){
        super(str);
    }
}
