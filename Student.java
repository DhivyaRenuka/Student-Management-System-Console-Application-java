package com.Divya;

import java.util.Scanner;

public class Student implements Student1 {
    private String f_name;
    private String l_name;
    private Long grade_year;
    public static Long studentID;
    private String course=null;
    private static int tuition_bal;
    private int cost_of_course=50000;
    private static int ID=1000;
    private int payment;
    private String report_card;

    public String getReport_card() {
        return report_card;
    }

    public void setReport_card(String report_card) {
        this.report_card = report_card;
    }

    // generate an Id
    public void setStudentID() {
        // grade+id
        ID++;
        this.studentID= (grade_year*10000)+ID;
    }

    public Student() {
        Scanner sc = new Scanner(System.in);
        Scanner inn = new Scanner(System.in);
        System.out.println("Enter the student first name");
        this.f_name = sc.nextLine();

        System.out.println("Enter the student last name");
        this.l_name = sc.nextLine();

        System.out.println("Enter the student the year of studying \n 1- fresher  2- 2nd year  3- pre-fianl year  4- fianl year");
        this.grade_year = sc.nextLong();

        System.out.println("Enter the course you enrolled ");

        System.out.println("Enter course enroll ");
        System.out.println("List of course are:" +
                "\n   Electric and Electronic =EEE100    " +
                "    Electronic and Communication 104=ECE104   " +
                "   information technology 205=IT205    " +
                "   Mechanical 102=MECH102   " +
                "   computer science 109=CS109");
        this.course = inn.nextLine();
        Boolean found=false;
        do {
        if (course.equals("EEE100")) {
            course = "Electric and Electronic 100";
            found=true;
        } else if (course.equals("ECE104")) {
            course = " Electronic and Communication 104";
            found=true;
        } else if (course.equals("IT205")) {
            course = "information technology 205";
            found=true;
        } else if (course.equals("MECH102")) {
            course = "Mechanical 102";
            found=true;
        } else if (course.equals("CS109")) {
            course = "computer science 109";
            found=true;
        } else {
            System.out.println("Your choice is not in the course list enter the course in the list");
            this.course=inn.nextLine();
        }
    }while(found == false);
        this.cost_of_course=50000;
        this.tuition_bal = cost_of_course;
        setStudentID();
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public Long getGrade_year() {
        return grade_year;
    }

    public void setGrade_year(Long grade_year) {
        this.grade_year = grade_year;
    }

    public static Long getStudentID() {
        return studentID;
    }

    public static void setStudentID(Long studentID) {
        Student.studentID = studentID;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public static int getTuition_bal() {
        return tuition_bal;
    }

    public static void setTuition_bal(int tuition_bal) {
        Student.tuition_bal = tuition_bal;
    }

    public int getCost_of_course() {
        return cost_of_course;
    }

    public void setCost_of_course(int cost_of_course) {
        this.cost_of_course = cost_of_course;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Student.ID = ID;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
    public void viewBalance()
    {
        System.out.println("Your balance is : Rs "+tuition_bal);
    }

    @Override
    public String toString() {
        return
                "\n first name " + f_name  +
                "\n last name " + l_name  +
                "\n grade year " + grade_year +
                "\n course  " + course + "\n Student ID :"+studentID+
                        "\n payment :" +tuition_bal+
                "\n Marksheet Report \n" +report_card+" \n";
    }
}
