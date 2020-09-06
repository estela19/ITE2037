package Assignement3;

public class InvalidLoginException extends Exception{
    public InvalidLoginException(){
        super("Login failed.");
    }
}
