package Assignement1;

public class InvalidMenuException extends Exception{
    public InvalidMenuException(){
        super("Invalid Access");
    }

    public InvalidMenuException(String ID){
        super(ID + " is an invalid menu number.");
    }
}
