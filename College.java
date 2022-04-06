package com.Divya;
import java.util.*;
public class College implements Student1,Staff1{
    private static List<Staff> staff;
    private static List<Student> students;
    private static int  totalMoneyEarned;
    private static int totalMoneySpent;

    public static List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static void setStudents(List<Student> students) {
        College.students = students;
    }

    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public int getEarnedMoney() {
        return totalMoneyEarned;
    }

    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneyEarned-=moneySpent;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    @Override
    public void setStaffID() {

    }

    @Override
    public void setStudentID() {

    }

    @Override
    public void viewBalance() {

    }
}
