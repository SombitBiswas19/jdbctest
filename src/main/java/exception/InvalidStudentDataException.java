package exception;

public class InvalidStudentDataException extends RuntimeException{
	public InvalidStudentDataException(String msg){
		super(msg);
	}
}
