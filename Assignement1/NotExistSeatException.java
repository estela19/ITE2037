package Assignement1;

public class NotExistSeatException extends Exception {
    public NotExistSeatException(){
        super("not exist");
    }
    public NotExistSeatException(String ID){
        super(ID + " does not exist");
    }
}
