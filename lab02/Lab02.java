import java.util.Scanner;

public class Lab02
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] input_arr = input.split(",");
        String[] name = input_arr[0].split(" ");
        int name_size = name.length;
        String initial_name = "";
        for(int i = 1; i < name_size; i++)
        {
            initial_name += name[i].charAt(0);
            initial_name += ".";
        }
        initial_name += name[0].charAt(0);
        initial_name = initial_name.toUpperCase();
        initial_name += name[0].substring(1);
        String result = initial_name + " submitted Homework.pdf";
        String len_result = "Name Length(Korean):" + name_size;

        System.out.println(len_result);
        System.out.println(result);
    }
}
