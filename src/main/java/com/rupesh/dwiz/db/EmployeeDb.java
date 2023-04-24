package com.rupesh.dwiz.db;

import com.rupesh.dwiz.api.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeDb {

    public static ConcurrentHashMap<Integer , Employee> employeeTable = new ConcurrentHashMap <>();

    static {
        employeeTable.put( 1, new Employee(1,"Rupesh", "Raghavan") );
        employeeTable.put( 2, new Employee(2,"Roopa", "Rupesh") );
        employeeTable.put( 3, new Employee(3,"Rhea", "Rupesh") );
        employeeTable.put( 4, new Employee(4,"Reva", "Rupesh") );
    }

    public static List <Employee> getEmployeeList() {
        return new ArrayList <Employee>(employeeTable.values());
    }

    public static Integer countEmployees(){
        return employeeTable.size();
    }

    public static Employee getEmployee(int empId) {
        return employeeTable.get( empId );
    }

    public static void updateEmployee(Integer id , Employee employee) {
        employeeTable.put( id,employee );
    }

    public static void removeEmployee(Integer empId){
        employeeTable.remove( empId );
    }

    public static void createEmployee(Integer empId , String firstName , String lastName) {
        employeeTable.put( empId , new Employee(empId , firstName , lastName) );
    }


}
