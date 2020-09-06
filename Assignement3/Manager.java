package Assignement3;

public class Manager extends Member{
    public Manager(String ID, String PW, int admin){
        super(ID, PW, admin);
    }

    public void printTicket(){
        System.out.printf("관리자가 발행한 티켓 수: %d\n", getTicket().size());
        System.out.printf("매출액: %d\n", getTicket().size() * 10000);
        System.out.println("---------------------------------------");
        for(int i = 0; i < getTicket().size(); i++){
            Ticket now = getTicket().elementAt(i);
            System.out.println(now.toString());
        }
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("Press enter to go back to User program");
    }
}
