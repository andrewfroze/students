package university.exceptions;

public class IllegalScoreException extends RuntimeException {
    public IllegalScoreException(String str){
        super(str);
    }
}