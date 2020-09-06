package Assignement3;

public class DuplicatedReservationException extends Exception {
    public DuplicatedReservationException(){
        super("already reserved");
    }

    public DuplicatedReservationException(String ID){
        super(ID + " is already reserved.");
    }
}
