package Assignement3;

public class Ticket {
    private Movie movie;
    private String seat;
    private int num;

    public Ticket(Movie movie, int x, int y, int num){
        this(movie, "", num);

        this.seat += ('A' + x);
        this.seat += (y + 1);
    }

    public Ticket(Movie movie, String seat, int num){
        this.movie = movie;
        this.seat = seat;
        this.num = num;
    }

    public Movie getMovie(){
        return movie;
    }

    public String getSeat(){
        return seat;
    }

    public int getNum() { return num; }

    public String toString(){
        return "Ticket number : " + num
                +" 제목 : " + movie.getName()
                +" / 상영시간 : " + movie.getStarttime() + ":00 - "
                + movie.getEndtime() + ":00"
                +" / Seat : " + seat;
    }
}
