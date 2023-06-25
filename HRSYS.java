// HRSYS.java
// Team members:
// 1. Durka Perumal [B22EC0010]
// 2. Amyzal Muhammad Zikrullah Bin Yahya [A21EC8004]
// 3. Wan Nurnabihah Mahfuzah Wan Mustapa [B22EC0010]
import java.util.*;

import org.w3c.dom.NameList;

public class HRSYS {
    // ArrayList variables to store all new created Company and 
    // Employee (Staff/ContractStaff) instances
    public static ArrayList<Company> companies = new ArrayList<Company>();
    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) {

        // Test case to quickly add company, department, and staff
        //Company com = new Company("Farmfresh");
        //companies.add(com);
        //companies.get(0).addDepartment("Admin");

        //Employee staff = new ContractStaff("AZMI", "A123", "CEO", 6);
        //staff.setDepartment(companies.get(0).getDepartments().get(0));
        //employees.add(staff);
        // End test case

        Scanner keyin = new Scanner(System.in);

        boolean exit = false;
        int operation = 0;

        while (!exit) {
            System.out.println();
            System.out.println("1. Add Company");
            System.out.println("2. Add Department");
            System.out.println("3. Add Staff");
            System.out.println("4. List Staff");
            System.out.println("5. Exit");

            while (operation < 1 || operation > 5) {
                System.out.print("Choose operation (1-5): ");
                operation = Integer.parseInt(keyin.nextLine());
            }

            if (operation == 1)
                addCompany(keyin);

            else if (operation == 2)
                addDepartment(keyin);

            else if (operation == 3)
                addStaff(keyin);

            else if (operation == 4)
                listStaff(keyin);

            else if (operation == 5)
                exit = true;

            operation = 0;
        }
    }

    public static void addCompany(Scanner keyin) {
        pressEnter(keyin);
    }

    public static void addDepartment(Scanner keyin) {
        pressEnter(keyin);
    }

    public static void addStaff(Scanner keyin) {
        pressEnter(keyin);
    }

    public static void listStaff(Scanner keyin) {
        pressEnter(keyin);
    }

    public static void pressEnter(Scanner keyin) {
        System.out.print("\nPress enter to continue... ");
        keyin.nextLine();
    }
}

abstract class Employee{
    protected String name, icNo;

    public Employee(){}

    public Employee(String name, String icNo){
        this.name = name;
        this.icNo = icNo;
    }

    public void keyinInfo(Scanner input){}

    public String getName(){
        return name;
    }

    public String getICNo(){
        return icNo;
    }

    public abstract void setDepartment(Department dept);

    public abstract Department getDepartment();

    public abstract String getPost();

    public abstract int getContractMonth();
}

class Company{
    private String name;
    private ArrayList<Department> departments;

    public Company(String name){}

    public String getName(){
        return name;
    }

    public void addDepartment(String dept){}

    public ArrayList<Department> getDepartments(){}
}

class Department{

}

class Staff{

}

class ContractStaff{
    
}