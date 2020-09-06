package Assignement1;

public class DuplicatedIdException extends Exception {
    public DuplicatedIdException(){
        super("Id ERROR");
    }

    public DuplicatedIdException(String ID){
        super(ID + " already exists.");
    }
}
