package Assignement1;

public class InvalidLoginException extends Exception{
    public InvalidLoginException(){
        super("Login failed.");
    }
}
