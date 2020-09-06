package lab10;

public class Program {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Tiger tiger = new Tiger();
        Turtle turtle = new Turtle();

        Animal[] animal = new Animal[3];
        animal[0] = dog;
        animal[1] = tiger;
        animal[2] = turtle;

        Person person = new Person(){
            private int hp = 100;
            @Override
            public void control(Barkable b) {
                if(b instanceof Tiger){
                    hp -= 80;
                    System.out.println("호랑이를 제압하였습니다.");
                }
                else if(b instanceof Dog){
                    hp -= 10;
                    System.out.println("개를 제압하였습니다.");
                }
            }

            @Override
            public void showInfo() {
                System.out.printf("사람 HP : %d\n", hp);
            }
        };

        showResult(animal, person);
    }

    private static void showResult(Animal[] animals, Person p){
        for(int i = 0; i < 3; i++){
            if(animals[i] instanceof Barkable){
                Barkable animal = (Barkable)animals[i];
                System.out.println(Integer.toString(i+1) + "번째 동물 : " + animals[i].getName());
                System.out.println(Integer.toString(i+1) + "번째 동물 울음소리 : " + animal.bark());
                p.control(animal);
                p.showInfo();
            }
        }
    }
}
