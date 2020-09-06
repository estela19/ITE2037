import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args){
        Employee james = new Employee("James Wright", 42, "Manager", 20000);
        System.out.printf(james.toString());
        Employee Amy = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);
        System.out.printf(Amy.toString());
        Employee Peter = new Employee("Peter Coolidge", 32, "Assistant Manager", 12000, 7);
        System.out.printf(Peter.toString());
        Employee John = new Employee("John Doe", 22, "Engineer", 10000, 10);
        System.out.printf(John.toString());

        if(John.equals(Amy)){System.out.printf("Amy입니다.\n");}
        else{System.out.printf("Amy가 아닙니다.\n");}

        james.vacation(10);
        Peter.vacation(10);

        System.out.printf(james.toString());
        System.out.printf(Amy.toString());
        System.out.printf(Peter.toString());
        System.out.printf(John.toString());
    }
}
