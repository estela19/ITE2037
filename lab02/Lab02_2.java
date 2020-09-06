import java.util.Scanner;

public class Lab02_2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputs = input.split(" ");
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < inputs.length; i++)
        {
            input = inputs[i].toUpperCase();
            int score = 0;
            score = GradeToScore(input);
            sum += score;
            cnt += 1;

            PrintScore(makeOrdinalNumber(cnt), score);
        }

        float avg = (float)sum/cnt;
        System.out.printf("This class's average = %.2f", avg);
    }

    public static int GradeToScore(String grade)
    {
        switch(grade)
        {
            case "A":
                return 100;

            case "B":
                return 90;

            case "C":
                return 80;

            case "D":
                return 70;
        }
        return 0;
    }

    public static String makeOrdinalNumber(int num)
    {
        if((num % 100)/10 == 1)
            return num + "th";

        switch(num % 10)
        {
            case 1:
                return num + "st";

            case 2:
                return num + "nd";

            case 3:
                return num + "rd";
        }

        return num + "th";
    }

    public static void PrintScore(String no, int score)
    {
        System.out.println(no + " student's score is " + score);
    }
}
