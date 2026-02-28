package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import exception.InvalidStudentDataException;

import model.Student;

public class MySQLStudentDAO implements StudentDAO{
	public static Scanner sc=new Scanner(System.in);
	public boolean validate_mobile_number(long mobile_number) {
		int count=0;
		while(mobile_number>0) {
			mobile_number/=10;
			count++;
		}
		if(count==10)
			return true;
		
		return false;
	}
	@Override
	public void Add_Student_In_Database(Student student) {
		try {
			if(student.getName()==null) {
				throw new InvalidStudentDataException("Student name is not valid");
			}
			if(student.getAge()<0 && student.getAge()>100) {
				throw new InvalidStudentDataException("Student age is not valid");
			}
			if(!student.getEmail().contains("@")) {
				throw new InvalidStudentDataException("Student email is not valid");
			}
			if(!validate_mobile_number(student.getMobile_number())) {
				throw new InvalidStudentDataException("Mobile number should be of length 10");
			}
		}
		catch(InvalidStudentDataException e) {
			System.out.println("Provide the valid data about student.");
		}
		
		Connection connection=CreateConnectionOfDatabase.create_connection();
		String sql="Insert into students(Student_name, Student_email, Student_age, Student_mobile_number) values(?,?,?,?)";
		PreparedStatement preparedstatement=null;
		try {
			preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, student.getName());
			preparedstatement.setString(2, student.getEmail());
			preparedstatement.setInt(3, student.getAge());
			preparedstatement.setLong(4, student.getMobile_number());
		} catch (SQLException e) {
			System.out.println("Problem is in Creating Platform");
		}
		
		try {
			int result=preparedstatement.executeUpdate();
			if(result>=1) {
				System.out.println("Student added successfully.");
				return;
			}
		} catch (SQLException e) {
			System.out.println("Problem is in executing query.. "+e.getStackTrace());
		}

	}

	@Override
	public void Show_All_Students() {
		Connection connection=CreateConnectionOfDatabase.create_connection();
		String sql="Select * from students";
		PreparedStatement preparedstatement=null;
		try {
			preparedstatement=connection.prepareStatement(sql);
			
		} catch (SQLException e) {
			System.out.println("Problem is in Creating Platform");
		}
		
		try {
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.isBeforeFirst()) {
				while(resultset.next()) {
					System.out.println("Student name: "+resultset.getString("Student_name"));
					System.out.println("Student email: "+resultset.getString("Student_email"));
					System.out.println("Student age: "+resultset.getInt("Student_age"));
					System.out.println("Student mobile number: "+resultset.getLong("Student_mobile_number"));
					System.out.println("------------------------------------------");
				}
			}
			else {
				System.out.println("No student exists in the database.");
				return;
			}
		} catch (SQLException e) {
			System.out.println("Problem is in executing query.. ");
		}
		
	}

	@SuppressWarnings("resource")
	@Override
	public void Update_Student_email_by_mobile_number(long mobilenumber) {
		try {
			if(!validate_mobile_number(mobilenumber)) {
				throw new InvalidStudentDataException("Mobile number should be of length 10");
			}
		}
		catch(InvalidStudentDataException e) {
			System.out.println("Provide the valid data about student.");
			return;
		}
		
		Connection connection=CreateConnectionOfDatabase.create_connection();
		System.out.println("Enter the email id which you want to update: ");
		String email=sc.next();
		String sql="Update students set Student_email=? where Student_mobile_number=?";
		PreparedStatement preparedstatement=null;
		try {
			preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1,email);
			preparedstatement.setLong(2, mobilenumber);
		} catch (SQLException e) {
			System.out.println("Problem is in Creating Platform");
		}
		
		try {
			int result=preparedstatement.executeUpdate();
			if(result>=1) {
				System.out.println("Student updated successfully.");
				return;
			}
			else {
				System.out.println("No student found with mobile number");
				return;
			}
		} catch (SQLException e) {
			System.out.println("Problem is in executing query.. ");
		}
	}

	@Override
	public void Delete_a_Student_From_Database(int id) {
		
		Connection connection=CreateConnectionOfDatabase.create_connection();
		String sql="Delete from students where Student_id=?";
		PreparedStatement preparedstatement=null;
		try {
			preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
		} catch (SQLException e) {
			System.out.println("Problem is in Creating Platform");
		}
		
		try {
			int result=preparedstatement.executeUpdate();
			if(result>=1) {
				System.out.println("Student deleted successfully.");
			}
			else {
				System.out.println("No Student found with id: "+id);
			}
		} catch (SQLException e) {
			System.out.println("Problem is in executing query.. "+e.getStackTrace());
		}
	}

}
