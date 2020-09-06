package Assignement3;

public class User extends Member {
    public void printTicket(){
        for(int i = 0; i < getTicket().size(); i++){
            Ticket now = getTicket().elementAt(i);
            System.out.println(now.toString());
        }
    }

    public User(String ID, String PW, int admin){
        super(ID, PW, admin);
    }
}
