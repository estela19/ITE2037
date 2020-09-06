public class Employee {

    private String name;
    private int age;
    private String position;
    private int salary;
    private int vacationDays;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
        position = "Employee";
        salary = 5000;
        vacationDays = 20;
    }

    public Employee(String name, int age, String position, int salary){
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        vacationDays = 20;
    }

    public Employee(String name, int age, String position, int salary, int vacationDays){
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.vacationDays = vacationDays;
    }

    public String getName(){return this.name;}
    public int getAge(){return this.age;}
    public String getPosition(){return this.position;}
    public int getSalary(){return this.salary;}
    public int getVacationDays(){return this.vacationDays;}

    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setPosition(String position){this.position = position;}
    public void setSalary(int salary){this.salary = salary;}
    public void setVacationDays(int vacationDays){this.vacationDays = vacationDays;}

    public Boolean equals(Employee rhs){
        if(this.name == rhs.name && this.age == rhs.age && this.position == rhs.position){
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Name : " + name +
                ", Age : " + age +
                ", Position : " + position +
                ", Salary : " + salary +
                ", VacationDays : " + vacationDays +'\n';
    }

    public boolean vacation(int days){
        if(this.vacationDays < days) {
            System.out.println("남은 휴가 일수가 부족합니다.\n");
            return false;
        }
        else{
            this.vacationDays -= days;
            System.out.printf("휴가를 사용하였습니다. 남은 휴가 일 수 : %d\n", this.vacationDays);
            return true;
        }
    }
}
