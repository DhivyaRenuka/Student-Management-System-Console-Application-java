package com.Divya;

import java.io.*;
import java.util.*;

/*
                                                    Student management system

Aim:
    the student management system , we can enroll student and staff and get all admin details and update mark sheet

    classes :

    staff :
       -> Enroll as staff and get staff id
       -> add student performance or report card
    student :
        -> Enroll in course
        -> pay fees
        -> get mark sheet / report card in file
    college :
        -> have list of student created
        ->  have list of staff
    Admin :
        -> add/edit/delete staff
        -> get all object list of student and teacher in seperate files and store their details
        -> see fee details
 */
public class Main {

    public static List<Student> s=new ArrayList<Student>();
    public static List<Staff> st =new ArrayList<Staff>();
    static College clg=new College();

    public static void  printStatement() {
        try {
            Scanner in=new Scanner(System.in);
            System.out.println("*************************  Welcome to College  *****************************" +
                    "\nEnter from any one of the following choice"+
                    "\n1. Admin \n2. Staff \n3. Student \n4. press 0 to quit");
            String ch=in.nextLine();
            do {

                if(ch.equals("Admin"))
                {
                    performAdminTask();
                }
                else if(ch.equals("Staff") )
                {
                    PerformStaffTask();
                }

                else if(ch.equals("Student"))
                {
                    performStudentTask();
                }
                else
                {
                    System.out.println("The choice is not in the list");
                }
            }while (ch.equals("0"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static void performStudentTask() {
        try
        {
            Scanner in=new Scanner(System.in);
            int ch;

            do {
                System.out.println("Enter from any one of the following choice"+
                        "\n 1. Enroll \n 2.Pay Fees \n 3.Generate Report Card \n 4. press 0 to quit ");
                ch=in.nextInt();
                switch (ch) {
                    case 1: {
                        s.add(new Student());
                        clg.setStudents(s);
                        break;
                    }
                    case 2: {
                        boolean found = false;
                        int payment = 0;
                        Scanner ss = new Scanner(System.in);
                        System.out.println("Enter the Student Id to pay fees");
                        Long studentId2 = ss.nextLong();
                        Iterator<Student> li = s.listIterator();
                        while (li.hasNext()) {
                            Student e = li.next();
                            Long num = e.getStudentID();
                            if (num.equals(studentId2)) {
                                found = true;
                                System.out.println("Cost of each course" + 50000.0);
                                System.out.println("Enter the amount to pay :");
                                payment = in.nextInt();
                                int tuition_bal1 = e.getTuition_bal();
                                tuition_bal1 -= payment;
                                System.out.println("Amount paid :Rs " + payment);
                                e.setTuition_bal(tuition_bal1);
                                e.viewBalance();
                                System.out.println("Thank you ,Have a nice day !");
                            }
                        }
                        // update the amount in the college record
                        clg.updateTotalMoneyEarned(payment);

                        if (!found) {
                            System.out.println("Student record not found ");
                        }
                        System.out.println("----------------------------------------------------");

                        break;
                    }
                    case 3: {
                        System.out.println("Generate Report Card");
                        Scanner ss = new Scanner(System.in);
                        System.out.println("Enter the Student Id to Generate Report Card ");
                        Long studentId2 = ss.nextLong();
                        System.out.println("Enter the roll number and the file name as student ID");
                        String filename =String.valueOf(studentId2)+".txt";
                        try(DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename))))
                        {
                            Iterator<Student> li = s.listIterator();
                            while(li.hasNext())
                            {
                                Student e = li.next();
                                if(studentId2.equals(e.getStudentID()) )
                                {
                                    out.writeBytes(String.valueOf(e));
                                }

                            }

                            out.flush();
                        }catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        break;
                    }
                    default:
                        break;
                }
            }while(ch !=0);
            printStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void PerformStaffTask() {
        try {
            Scanner si=new Scanner(System.in);
            int ch;
            do {
                System.out.println("Welcome as staff" +
                        "\n 1. Enroll \n 2. update student report \n 3. press 0 to quit");

                ch = si.nextInt();
                switch (ch) {
                    case 1: {
                        st.add(new Staff());
                        Long salary = Staff.getSalary();
                        clg.setStaff(st);
                        clg.updateTotalMoneySpent(Math.toIntExact(salary));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter student ID :");
                        String report=null;
                        Long stuID = si.nextLong();
                        Scanner scc=new Scanner(System.in);
                        boolean found = false;
                        Iterator<Student> li = s.listIterator();
                        while (li.hasNext()) {
                            Student e = li.next();
                            Long num = e.getStudentID();
                            if (num != stuID) {
                                found = true;
                                int grade_yr = (int) (num / 10000);
                                System.out.println("Enter in text with semester number and cgpa");
                                for (int i = 0; i < grade_yr * 2; i++) {
                                    System.out.println("Enter the CGPA of semester in words " + (i + 1));
                                    report += scc.nextLine() + "\n";
                                }
                                    e.setReport_card(report);

                                    String Filename = "report.txt";
                                    try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(Filename)))) {
                                        out.writeBytes(String.valueOf(e));
                                        out.flush();
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }

                            }
                        }
                        System.out.println("Report card generated at"+ new Date());
                        break;

                    }
                    case 3:
                        break;
                }
            }while(ch !=0);
            printStatement();

        }catch (Exception e)
        {
            e.getMessage();
        }

    }

    private static void performAdminTask() throws IOException  {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Admin userID :");
        String AdminID= in.nextLine();
        if(AdminID.equals("Admin@123"))
        {
            System.out.println("Enter the Activity you wish to perform"+
                    "\n1. Add student and staff record"
            +"\n2. Edit Student Record \n3. Delete Student Record \n4. Generate File for list of students " +
                    "\n5. Generate File For List Of Staff \n6. Accountant details");
            int ch= in.nextInt();
            switch (ch)
            {
                case 1:
                {
                    addStudentAndTeacher();
                    break;
                }
                case 2:
                {
                    editStudent();
                    break;
                }
                case 3:
                {
                    deleteStudent();
                    break;
                }
                case 4:
                {
                    generateStudentList();
                    break;
                }
                case 5:
                {
                    generateStaffList();
                    break;
                }
                case 6:
                {
                    accountDetails();
                    break;
                }
            }
        }
        printStatement();
        throw new IOException("IO Exception Occurred");
    }

    private static void accountDetails() {
        System.out.println("Amount earned Rs:"+ clg.getTotalMoneyEarned());
        System.out.println("Amount spent Rs:"+clg.getTotalMoneySpent());
    }

    private static void generateStaffList() {
        String filename="StaffList.txt";
        try(ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(filename))))
        {

            out.writeBytes(String.valueOf(clg.getStaff()));
        //    out.writeObject(clg.getStaff());
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateStudentList() {
        String filename="StudentList.txt";
        try(ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(filename))))
        {
            out.writeBytes(String.valueOf(clg.getStudents()));
          //  out.writeObject(College.getStudents());
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void deleteStudent() {
        boolean found = false;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the Student Id to Delete");
        Long studentId = in.nextLong();
        System.out.println("----------------------------------------------------");
        Iterator<Student> i = s.iterator();
        while (i.hasNext()) {
            Student e = i.next();
            if (e.getStudentID() == studentId) {
                i.remove();
                found = true;
            }
        }
        clg.setStudents(s);

        if (!found) {
            System.out.println("Student record not found ");
        } else {
            System.out.println("Record is deleted successfully");
        }
        System.out.println("----------------------------------------------------");
    }

    private static void addStudentAndTeacher() {
        clg.setStaff(st);
        clg.setStudents(s);
        System.out.println("Staffs and students are added in the college list");
        }

    private static void editStudent() {
        boolean found=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Student Id to Update");
        int stu_id=sc.nextInt();
        System.out.println("----------------------------------------------------");
        ListIterator<Student> li= s.listIterator();
        while(li.hasNext())
        {
            Student e=li.next();
            if( e.getStudentID()== stu_id)
            {
                System.out.println("Enter new name");
                e.setF_name(sc.nextLine());
                System.out.println("Enter new course from course list");
                e.setCourse(sc.nextLine());
                System.out.println("Enter the grade year");
                e.setGrade_year(sc.nextLong());
                s.add(e);

                found=true;
            }
            clg.setStudents(s);
        }

        if(! found)
        {
            System.out.println("Student record not found " );
        }
        else
        {
            System.out.println("Record is updated successfully");
        }
        System.out.println("----------------------------------------------------");
    }

    public static void main(String[] args) {

                    printStatement();


    }
}
