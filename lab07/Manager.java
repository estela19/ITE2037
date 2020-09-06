package lab07;

public class Manager extends Employee {
    private int officeNum;
    private String team;

    public Manager(String name, int employeeNum, int officeNum, String team){
        super(name, employeeNum, "Management");
        this.officeNum = officeNum;
        this.team = team;
    }

    public String toStiring(){
        return super.toString() + "\nlocation : " + super.getDepartment() + ", office : " + this.officeNum;
    }

    public boolean equals(Object obj){
        if(obj == null) return false;
        else if(getClass() != obj.getClass()) return false;
        else{
            Manager employee = (Manager)obj;
            return getName().equals(employee.getName()) && (getEmployeeNum() == employee.getEmployeeNum() && officeNum == employee.officeNum);
        }
    }


}
