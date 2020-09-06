package lab10;

public class Tiger extends Animal implements Barkable {

    public Tiger(){
        super("호랑이");
    }

    @Override
    public String bark() {
        return "어흥";
    }
}
