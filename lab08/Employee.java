package lab08;

public abstract class Employee {
    private String name;
    private int employeeNum;
    private String department;
    private int workHrs;
    private double salary;

    public Employee(String name, int employeeNum){
        this.name = name;
        this.employeeNum = employeeNum;
        this.workHrs = 0;
        this.salary = 0;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getWorkHrs() {
        return workHrs;
    }

    public boolean equals(Object obj){
        if(obj == null) return false;
        else if(getClass() != obj.getClass()) return false;
        else{
            Employee employee = (Employee)obj;
            return (this.name == employee.name && this.employeeNum == employee.employeeNum);
        }
    }

    public String toString(){
        return "Name : " + name
                +"\nEmp# : " + employeeNum;
    }

    public void doWork(int hrs){
        this.workHrs += hrs;
        this.salary = getPaid();
    }

    public abstract double getPaid();

    public boolean equalPay(Employee emp){
         if(this.salary == emp.salary) return true;
         else return false;
    }
}
