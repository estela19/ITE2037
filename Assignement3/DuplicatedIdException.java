package Assignement3;

public class DuplicatedIdException extends Exception {
    public DuplicatedIdException(){
        super("Id ERROR");
    }

    public DuplicatedIdException(String ID){
        super(ID + " already exists.");
    }
}
