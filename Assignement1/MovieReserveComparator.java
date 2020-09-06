package Assignement1;

import java.util.Comparator;

public class MovieReserveComparator implements Comparator<Movie> {
    public int compare(Movie arg0, Movie arg1){
        return arg0.getTicketnum() > arg1.getTicketnum() ? -1 : arg0.getTicketnum() < arg1.getTicketnum() ? 1 : 0;
    }
}
