package lab10;

public class Dog extends Animal implements Barkable {

    public Dog(){
        super("개");
    }

    @Override
    public String bark() {
        return "멍멍";
    }
}
