Title: Student Management System using JDBC with Runtime Polymorphism and Custom Exception
Design and implement a console-based Student Management System using Java and JDBC.
Your Application must demonstrate:
Runtime Polymorphism
Code reusability and readability
Input validation
Custom Exception Handling

Functional Requirements:
The system should provide the following operations:
1) Add a new Student
2) View all students
3) Update student email by using mobile number.
4) Delete a student details by using id.
All database operations must be performed using JDBC.

Technical Requirements:
Create a student class with appropriate fields(id, name, email, age, mobile).
Create StudentDAO interface declaring all crud operations.
Create at least one implementation classes of StudentDAO (eg. MySQLStudentDAO)
Demonstrate runtime polymorphism by using interface reference to access implementation class objects.
Using PreparedStatement for all database operations.
Validation requirement (Mandatory).

While inserting a student:
Name must not be empty or numberic
Email must contain @
Age must be a positive number.
Mobile number must contain exactly 10 digits.
If validation fails, you must throw a custom checked exception named:
InvalidStudentDataException
Handle this exception properly in the main class and display a meaningful message.

Project Structure Requirement
Organize your project into proper packages (model, dao, exception, main) to improve readability and reusability.

com -> Main or App
model -> Student class
dao -> StudentDAO interface,MySQLStudentDAO class
exception -> customexception

Expected Outcome:
The Program should display a menu-driven console interface and perform operations based on user choice.
The implementation must clearly show runtime polymorphism and custom exception usage.
