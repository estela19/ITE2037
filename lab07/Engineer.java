package lab07;

public class Engineer extends Employee{
    private String workZone;
    private String project;

    public Engineer(String name, int employeeNum, String workZone, String project){
        super(name, employeeNum, "Engineering");
        this.workZone = workZone;
        this.project = project;
    }

    public boolean equals(Object obj){
        if(obj == null) return false;
        else if(getClass() != obj.getClass()) return false;
        else{
            Engineer employee = (Engineer)obj;
            return getName().equals(employee.getName())
                    && (getEmployeeNum() == employee.getEmployeeNum()
                    && workZone == employee.workZone);
        }
    }

    public String toString(){
        return super.toString() + "\nlocation : " + getDepartment() +", office : " + workZone;
    }
}
