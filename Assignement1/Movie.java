package Assignement1;

public class Movie {
    private int NO;
    private String name;
    private int starttime;
    private int endtime;
    private int ticketnum;
    private boolean seats[] = new boolean[37];

    public Movie(int NO, String name, int starttime){
        this.NO = NO;
        this.name = name;
        this.starttime = starttime;
        this.endtime = starttime + 3;
        this.ticketnum = 0;
    }

    public int getNO() { return NO; }

    public String getName() { return name; }

    public int getStarttime() {
        return starttime;
    }

    public int getEndtime() {
        return endtime;
    }

    public int getTicketnum() {
        return ticketnum;
    }

    public boolean getSeat(int coord) {
        return seats[coord];
    }

    public void plusTicketnum() { ticketnum += 1;}

    public void setSeat(String coord, boolean reserve){
        seats[SeatToNum(coord)] = reserve;
    }

    public void PrintSeat(){
        System.out.println("  1 2 3 4 5 6");
        for(int i = 0; i < 6; i++){
            System.out.printf("%c ", 65 + i);
            for(int j = 1; j < 7; j++){
                if(!(ConvertIntSeat(i, j))) {
                    System.out.print("O ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public int SeatToNum(String seat){
        try {
            char ch[] = seat.toCharArray();
            /*
            if(ch.length() != 1){
                throw new NotExistSeatException();
            }
             */
            int alpha = (int) ch[0] - 'A';
            int num = (int) ch[1] - '0';
            if(ch[0] > 'F' || num > 6 || num < 1){
                throw new NotExistSeatException();
            }
            return alpha*6 + num;
        }
        catch(NotExistSeatException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    private boolean ConvertIntSeat(int x, int y){
        return seats[x*6 + y];
    }

    public String toString(){
        return "제목 : " + name
                +"/ 상영시간 : " + starttime
                +":00 - " + endtime + ":00";
    }

}
