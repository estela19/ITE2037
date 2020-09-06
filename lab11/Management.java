package lab11;

import java.util.ArrayList;

public class Management {
    public static <T extends Employee> T moveDepartment(T t, String department){
        t.setDepartment(department);
        return t;
    }

    public static <T extends Employee> T raiseSalary(T t, double rate){
        t.setSalary(t.getSalary() * rate);
        return t;
    }

    public static <T extends Employee> int findIndexByEmpNum(ArrayList<T> tList, int employeeNum){
        for(int i = 0; i < tList.size(); i++){
            if(tList.get(i).getEmployeeNum() == employeeNum){
                return i;
            }
        }
        return -1;
    }

    public static <T extends Employee> ArrayList<T> raiseAllSalary(ArrayList<T> tList, double rate){
        for(T i: tList){
            i.setSalary(i.getSalary()*rate);
        }
        return tList;
    }
}
