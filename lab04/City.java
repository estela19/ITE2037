import java.util.Random;

public class City {
    private String name;
    private int location_x, location_y;
    Random rnd = new Random();

    public City(String name, int x, int y){
        this.name = name;
        this.location_x = x;
        this.location_y = y;
    }

    public City(String name){
        this.name = name;
        this.location_x = rnd.nextInt(361);
        this.location_y = rnd.nextInt(361);
    }

    public String getName() {return name;}
    public int getLocation_x() {return location_x;}
    public int getLocation_y() {return location_y;}

    public boolean equals(City other){
        if(this.name == other.getName() && this.location_x == other.getLocation_x() && this.location_y == other.getLocation_y())
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return name + ", " + location_x + ", " + location_y;
    }

    public static double GetDistance(City obj1, City obj2){
       double tmp_x = Math.pow(Math.abs(obj1.getLocation_x() - obj2.getLocation_x()), 2);
       double tmp_y = Math.pow(Math.abs(obj1.getLocation_y() - obj2.getLocation_y()), 2);
       return Math.sqrt(tmp_x + tmp_y);
    }
}
