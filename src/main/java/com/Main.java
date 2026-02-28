package com;
import java.util.Scanner;

import dao.*;
import model.Student;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("----Student Management System----");
		
		StudentDAO data_access=new MySQLStudentDAO();
		while(true) {
			System.out.println("Press 1 to insert student");
			System.out.println("Press 2 to view all students");
			System.out.println("Press 3 to update student email by using mobile number");
			System.out.println("Press 4 to delete student using id");
			System.out.println("Press 5 to Exit from the system");
			
			System.out.println("Choose any option: ");
			int val=sc.nextInt();
			
			switch(val) {
			case 1: 
				System.out.println("Inserting student......");
				System.out.println("Enter the name of the student: ");
				String name=sc.next();
				System.out.println("Enter the email of the student: ");
				String email=sc.next();
				System.out.println("Enter the age of the student: ");
				int age=sc.nextInt();
				System.out.println("Enter the mobile number of the student: ");
				long mobile_number=sc.nextLong();
				data_access.Add_Student_In_Database(new Student(name,email,age,mobile_number));
				break;
			case 2:
				System.out.println("Displaying all students......");
				data_access.Show_All_Students();
				break;
			case 3:
				System.out.println("Updating student email based on mobile number......");
				System.out.println("Enter the mobile number of the student: ");
				long mobile_no=sc.nextLong();
				data_access.Update_Student_email_by_mobile_number(mobile_no);
				break;
			case 4:
				System.out.println("Deleting student based on id......");
				System.out.println("Enter the id of the student");
				int id=sc.nextInt();
				data_access.Delete_a_Student_From_Database(id);
				break;
			case 5:
				System.exit(0);
				break;
			}
			
		}

	}

}
