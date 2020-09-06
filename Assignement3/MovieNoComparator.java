package Assignement3;

import java.util.Comparator;

public class MovieNoComparator implements Comparator<Movie> {
    public int compare(Movie arg0, Movie arg1){
        return arg0.getNO() < arg1.getNO() ? -1 : arg0.getNO() > arg1.getNO() ? 1 : 0;
    }
}
