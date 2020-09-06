package Assignement1;

import java.util.Vector;

public class Member {
    private int admin;
    private String ID;
    private String PW;
    private Vector<Ticket> ticket = new Vector<Ticket>();

    public String getID() { return ID; }

    public String getPW(){
        return PW;
    }

    public int IsManager() { return admin; }

    public Vector<Ticket> getTicket() { return ticket; }

    public void addTicket(Ticket ticket){
        this.ticket.addElement(ticket);
    }

    public Member(String ID, String PW, int admin){
        this.ID = ID;
        this.PW = PW;
        this.admin = admin;
    }
}
