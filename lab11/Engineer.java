package lab11;

public class Engineer extends Employee{
    public static int initial_engineer_number = 2000;
    public static String initial_engineer_dept = "Computational Management";
    public static int initial_engineer_salary = 3300;

    public Engineer(String name){
        setName(name);
        setDepartment(initial_engineer_dept);
        setSalary(initial_engineer_salary);
        initial_engineer_number += 1;
        setEmployeeNum(initial_engineer_number);
    }

    public String toString(){
        return super.toString();
    }
}
