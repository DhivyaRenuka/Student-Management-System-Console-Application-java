package com.Divya;

import java.util.Scanner;

public class Staff {
    private String name;
    private Long StaffID;
    private static Long Salary;
    private static int ID=1000;
    private String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStaffID() {
        ID++;
        this.StaffID = Long.valueOf(ID);
    }
    public Long getStaffID() {
        return StaffID;
    }

    public static Long getSalary() {
        return Salary;
    }

    public void setSalary(Long salary) {
        Salary = salary;
    }

    public Staff() {
        Scanner ss=new Scanner(System.in);
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the name");
        this.name =ss.nextLine();
        setStaffID();
        System.out.println("Enter the department");
        this.dept=ss.nextLine();
        System.out.println("Enter the salary fixed");
        this.Salary=s.nextLong();


    }

    @Override
    public String toString() {
        return
                "\nname :" + name  +
                "\n StaffID :" + StaffID +
                "\n Salary :" + Salary+"\n" ;
    }
}
