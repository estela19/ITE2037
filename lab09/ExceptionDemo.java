package lab09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    Scanner scan = new Scanner(System.in);
    Employee developer = new Employee("jack");
/*
    while(true){
        System.out.printf("%d일차 근무 시간을 입력하세요 : ", developer.getWorkDay());
        int hours = Integer.parseInt(scan.nextLine());

        try {
            if (hours < 0) throw new NegativeException();
            else if (hours == 0) throw new Exception("Program Exit");
            else if (hours > 24) throw new TooMuchStuffException(hours);
            else {
                developer.addWorkDay();
                developer.addWorkHours(hours);
                System.out.println("이름 : " + developer.getName());
                System.out.println("누적 근무 시간 : " + developer.getWorkHours());
                System.out.println("No Exception has been occurred");
            }
        }
        catch(NegativeException e){
            System.out.println(e.getMessage());
        }
        catch(TooMuchStuffException e){
            System.out.println(Integer.toString(hours) + "," + e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        finally{
            System.out.println("End of try-catch statement");
        }
    }

 */
}
