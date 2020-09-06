package lab08;

public class Manager extends Employee {
    private double overtimeRate;
    private double rate;
    private int regularHrs;

    public Manager(String name, int employeeNum){
        super(name, employeeNum);
        this.rate = 5.0;
        this.overtimeRate = 8.0;
        this.regularHrs = 40;
        this.setDepartment("Management");
    }

    public boolean equals(Object obj){
        if(obj instanceof Manager){
            return super.equals(obj);
        }
        return false;
    }

    public String toString(){
        return super.toString()
                +"\nDept : " + getDepartment() + "\n";
    }

    public double getPaid(){
        int overtimeHrs = getWorkHrs() - regularHrs;
        if(getWorkHrs() < 40) return getWorkHrs()*rate;
        else{
            return regularHrs*rate + overtimeHrs * overtimeRate;
        }
    }
}
