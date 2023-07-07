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
        System.out.println("\nADD NEW COMPANY");
        System.out.print("Company Name: ");
        String name = keyin.nextLine();

        companies.add(new Company(name));
        pressEnter(keyin);
    }

    public static void addDepartment(Scanner keyin) {
        System.out.println("\nADD NEW DEPARTMENT");
        System.out.print("Department Name: ");
        String departmentName = keyin.nextLine();

        System.out.println("");
        for(int i=0; i<companies.size(); i++){
            System.out.println(i+1 + " - " + companies.get(i).getName());
        }
        
        System.out.print("Choose company to add department: ");
        int compChoice = Integer.parseInt(keyin.nextLine());

        companies.get(compChoice-1).addDepartment(departmentName);

        pressEnter(keyin);
    }

    public static void addStaff(Scanner keyin) {
        System.out.println("\nADD NEW STAFF");
        System.out.print("Contract staff? (y/n): ");
        String choice = keyin.nextLine();

        if(choice == "N" || choice == "n"){
            Employee regularStaff = new Staff();
            regularStaff.keyinInfo(keyin);
            employees.add(regularStaff);
        }else{
            Employee contractStaff = new ContractStaff();
            contractStaff.keyinInfo(keyin);
            employees.add(contractStaff);
        }

        System.out.println("");
        for(int i=0; i<companies.size(); i++){
            System.out.println(i+1 + " - " + companies.get(i).getDepartments());
        }

        System.out.print("Choose company's department to add staff: ");
        int deptChoice = Integer.parseInt(keyin.nextLine());

        pressEnter(keyin);
    }

    public static void listStaff(Scanner keyin) {
        System.out.println("STAFF LIST RECORD \n");
        System.out.println("No.   Name          IC No.      Post          Company-Department");
        System.out.println("----------------------------------------------------------------");

        for(int i=0; i<employees.size(); i++){
            System.out.printf("%d     %s          %s         %s            %s", 
            i+1, 
            employees.get(i).getName(), 
            employees.get(i).getICNo(),
            employees.get(i).getPost(),
            employees.get(i).getDepartment());
        }

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

    public void keyinInfo(Scanner keyin){
        // System.out.println("\nADD NEW STAFF");
        // System.out.print("Contract staff? (y/n): ");
        // String choice = keyin.nextLine();

        // if(choice == "N" || choice == "n"){
        //     Employee regularStaff = new Staff();
        //     regularStaff.keyinInfo(keyin);
        // }else{
        //     Employee contractStaff = new ContractStaff();
        //     contractStaff.keyinInfo(keyin);
        // }
    }

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

class Staff extends Employee{
    private String post;
    private Department department;

    public Staff(){}

    public Staff(String name, String icNo, String post){
        super(name, icNo);
        this.post = post;
    }

    public void keyinInfo(Scanner keyin){
        System.out.print("Name: ");
        name = keyin.nextLine();

        System.out.print("IC No.: ");
        icNo = keyin.nextLine();

        System.out.print("Post: ");
        post = keyin.nextLine();
    }

    public void setDepartment(Department dept){
        department = dept;
    }

    public Department getDepartment(){
        return department;
    }

    public String getPost(){
        return post;
    }

    public int getContractMonth(){
        return -1;
    }
}

class ContractStaff extends Staff{
    private int contractMonth;
    
    public ContractStaff(){}

    public ContractStaff(String name, String icNo, String post, int contractMonth){
        super(name, icNo, post);
        this.contractMonth = contractMonth;
    }

    public void keyinInfo(Scanner keyin) {
        super.keyinInfo(keyin);
        System.out.print("Month(s) of Contract: ");
        contractMonth = Integer.parseInt(keyin.nextLine());
    }
}

class Company{
    private String name;
    private ArrayList<Department> departments;

    public Company(String name){
        this.name = name;
        departments = new ArrayList<Department>();
    }

    public String getName(){
        return name;
    }

    public void addDepartment(String dept){
        departments.add(new Department(dept, new Company(name)));
    }

    public ArrayList<Department> getDepartments(){
        return departments;
    }
}

class Department{
    private String name;
    private Company company;
    private ArrayList<Employee> staffs;

    public Department(String name, Company company){
        this.name = name;
        this.company = company;
        staffs = new ArrayList<Employee>();
    }

    public String getName(){
        return name;
    }

    public Company getCompany(){
        return company;
    }
}