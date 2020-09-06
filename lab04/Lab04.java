public class Lab04 {
    public static void main(String[] args) {
        City Seoul = new City("Seoul", 23, 45);
        System.out.println(Seoul.toString());
        City Paris = new City("Paris", 123, 41);
        System.out.println(Paris.toString());
        City Racoon = new City("Racoon City");
        System.out.println(Racoon.toString());
        City Mega = new City("Mega City");
        System.out.println(Mega.toString());

        System.out.println("Seoul-Paris : " + City.GetDistance(Seoul, Paris));
        System.out.println("Seoul-Racoon : " + City.GetDistance(Seoul, Racoon));
        System.out.println("Paris-Mega : " + City.GetDistance(Paris, Mega));
    }
}
