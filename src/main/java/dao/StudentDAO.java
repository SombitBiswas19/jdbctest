package dao;
import model.Student;

public interface StudentDAO {
	public void Add_Student_In_Database(Student student);
	public void Show_All_Students();
	public void Update_Student_email_by_mobile_number(long mobilenumber);
	public void Delete_a_Student_From_Database(int id);
}
