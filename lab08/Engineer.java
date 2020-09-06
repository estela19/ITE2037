package lab08;

public class Engineer extends Employee {
    private double rate;

    public Engineer(String name, int employeeNum){
        super(name, employeeNum);
        super.setDepartment("Engineering");
        this.rate = 4.0;
    }

    public boolean equals(Object obj){
        if(obj instanceof Engineer){
            return super.equals(obj);
        }
        return false;
    }

    public String toString(){
        return super.toString()
                +"\nDept : " + getDepartment() + "\n";
    }

    public double getPaid() {
        return getWorkHrs() * rate;
    }
}
