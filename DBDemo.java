import java.sql.*;
import java.util.Scanner;

public class DBDemo
{
   public static void main(String[] args)
   {
   
      Scanner kbd = new Scanner(System.in);
      try
      {
         System.out.println("Do you want to insert, delete, update, retrieve?: ");
         String answer = kbd.nextLine();
         answer = answer.toLowerCase();
         String insert = "insert";
         String delete = "delete";
         String upDate = "update";
         String retrieve = "retrieve";
         
      
         String url = "jdbc:mysql://cs.neiu.edu:3306/SM24CS3151_jmtinich?serverTimezone=UTC&";
         url += "user=SM24CS3151_jmtinich&password=jmtinich695298";
         
         Connection conn = DriverManager.getConnection(url);
         
         if(answer.equals(insert))
         {
            System.out.println("What table do you want to insert into? (Course, Enrollment, Instructor, Student): ");
            String table = kbd.nextLine();
            table = table.toLowerCase();
            String course = "course";
            String enrollment = "enrollment";
            String instructor = "instructor";
            String student = "student";
            
            if(table.equals(student))
            {
               System.out.println("Enter student id: ");
               int sId = kbd.nextInt();
               kbd.nextLine();
               System.out.println("Enter last name: ");
               String sLastName = kbd.nextLine();
               System.out.println("Enter first name: ");
               String sFirstName = kbd.nextLine();
               System.out.println("Enter email: ");
               String sEmail = kbd.nextLine();
               System.out.println("Enter major: ");
               String major = kbd.nextLine();
               System.out.println("Enter academic year: ");
               String academicYear = kbd.nextLine();
             
               Statement stmt = conn.createStatement();
            
               String update = "INSERT INTO Student VALUES(" + sId + ",'" + sLastName + "','" + sFirstName + "','" + sEmail + "','" + major + "','" + academicYear + "')";
            
               stmt.executeUpdate(update);
            }
            if(table.equals(instructor))
            {
               System.out.println("Enter instructor id: ");
               int iId = kbd.nextInt();
               kbd.nextLine();
               System.out.println("Enter last name: ");
               String iLastName = kbd.nextLine();
               System.out.println("Enter first name: ");
               String iFirstName = kbd.nextLine();
               System.out.println("Enter phone: ");
               String iPhone = kbd.nextLine();
               System.out.println("Enter email: ");
               String iEmail = kbd.nextLine();
               System.out.println("Enter department: ");
               String iDepartment = kbd.nextLine();
               
               Statement stmt = conn.createStatement();
            
               String update = "INSERT INTO Instructor VALUES(" + iId + ",'" + iLastName + "','" + iFirstName + "','" + iPhone + "','" + iEmail + "','" + iDepartment + "')";
            
               stmt.executeUpdate(update);
            }
            if(table.equals(enrollment))
            {
               System.out.println("Enter enrollment id: ");
               int eId = kbd.nextInt();
               kbd.nextLine();
               System.out.println("Enter student id: ");
               int sEnrollmentId = kbd.nextInt();
               kbd.nextLine();
               System.out.println("Enter course id: ");
               int eCourseId = kbd.nextInt();
               kbd.nextLine();
               System.out.println("Enter date of enrollment: ");
               String dateOfEnrollment = kbd.nextLine();
               
               Statement stmt = conn.createStatement();
               
               String update = "INSERT INTO Enrollment VALUES(" + eId + ",'" + sEnrollmentId + "','" + eCourseId + "','" + dateOfEnrollment + "')";
               
               stmt.executeUpdate(update);
            }
            if(table.equals(course))
            {
               System.out.println("Enter course id: ");
               int courseId = kbd.nextInt();
               kbd.nextLine();
               System.out.println("Enter course name: ");
               String courseName = kbd.nextLine();
               System.out.println("Enter schedule: ");
               String schedule = kbd.nextLine();
               System.out.println("Enter department: ");
               String department = kbd.nextLine();
               System.out.println("Enter credits: ");
               int credits = kbd.nextInt();
               kbd.nextLine();
               System.out.println("Enter instructor id: ");
               int cInstructorId = kbd.nextInt();
               kbd.nextLine();
               
               Statement stmt = conn.createStatement();

               String update = "INSERT INTO Course VALUES(" + courseId + ",'" + courseName + "','" + schedule + "','" + department + "','" + credits + "','" + cInstructorId + "')";
               
            }

         }
         
         if(answer.equals(delete))
         {
            System.out.println("What table do you want to delete from? (Course, Enrollment, Instructor, Student): ");
            String table = kbd.nextLine();
            table = table.toLowerCase();
            String course = "course";
            String enrollment = "enrollment";
            String instructor = "instructor";
            String student = "student";
            
            if(table.equals(student))
            {
               System.out.println("What column do you want to target? (student_id, last_name, first_name, email, major, academic_year): ");
               String column = kbd.nextLine();
               column = column.toLowerCase();
               System.out.println("What value in the column do you want to delete?: ");
               String value = kbd.nextLine();
             
               Statement stmt = conn.createStatement();
            
               String update = "DELETE FROM Student WHERE " + column + " = '" + value + "'";
            
               stmt.executeUpdate(update);
            }
            
            if(table.equals(instructor))
            {
               System.out.println("What column do you want to target? (instructor_id, last_name, first_name, phone, email, department): ");
               String column = kbd.nextLine();
               column = column.toLowerCase();
               System.out.println("What value in the column do you want to delete?: ");
               String value = kbd.nextLine();
             
               Statement stmt = conn.createStatement();
            
               String update = "DELETE FROM Instructor WHERE " + column + " = '" + value + "'";
            
               stmt.executeUpdate(update);
            }
            
            if(table.equals(enrollment))
            {
               System.out.println("What column do you want to target? (enrollment_id, student_id, course_id, phone, date_of_enrollment): ");
               String column = kbd.nextLine();
               column = column.toLowerCase();
               System.out.println("What value in the column do you want to delete?: ");
               String value = kbd.nextLine();
             
               Statement stmt = conn.createStatement();
            
               String update = "DELETE FROM Enrollment WHERE " + column + " = '" + value + "'";
            
               stmt.executeUpdate(update); 
            }
            
            if(table.equals(course))
            {
               System.out.println("What column do you want to target? (course_id, course_name, schedule, department, credits, instructor_id): ");
               String column = kbd.nextLine();
               column = column.toLowerCase();
               System.out.println("What value in the column do you want to delete?: ");
               String value = kbd.nextLine();
             
               Statement stmt = conn.createStatement();
            
               String update = "DELETE FROM Course WHERE " + column + " = '" + value + "'";
            
               stmt.executeUpdate(update); 
            }

         }
         
         if(answer.equals(upDate))
         {
            System.out.println("What table do you want to update? (Course, Enrollment, Instructor, Student): ");
            String table = kbd.nextLine();
            table = table.toLowerCase();
            String course = "course";
            String enrollment = "enrollment";
            String instructor = "instructor";
            String student = "student";
            
            if(table.equals(student))
            {
               System.out.println("What column do you want to update? (student_id, last_name, first_name, email, major, academic_year): ");
               String sColumn = kbd.nextLine();
               sColumn = sColumn.toLowerCase();
               System.out.println("Do you want to just set a value or set a value between values?: (type set or between)");
               String v1 = kbd.nextLine();
               v1 = v1.toLowerCase();
               String set1 = "set";
               String between1 = "between";
               
               if(v1.equals(set1))
               {            
                  System.out.println("Do you want to multiply, divide, add, or subtract? :  (type +, /, -, *)");
                  String arthmetic = kbd.nextLine();
                  System.out.println("What is the number that you want to set?: ");
                  int num = kbd.nextInt();
                  kbd.nextLine();
             
                  Statement stmt = conn.createStatement();
            
                  String update = "UPDATE Student SET " + sColumn + " = " + sColumn + arthmetic + num;
            
                  stmt.executeUpdate(update);

               }
               
               if(v1.equals(between1))
               {
                  System.out.println("Do you want to multiply, divide, add, or subtract? :  (type +, /, -, *)");
                  String arthmetic = kbd.nextLine();
                  System.out.println("What is the number that you want to set?: ");
                  int num = kbd.nextInt();
                  kbd.nextLine();
                  System.out.println("What column do you want to check the values between? (student_id, last_name, first_name, email, major, academic_year): ");
                  String sColumn2 = kbd.nextLine();
                  System.out.println("What is the first number you want to set it between");
                  int b1 = kbd.nextInt();
                  kbd.nextLine();
                  System.out.println("What is the second number you want to set it between");
                  int b2 = kbd.nextInt();
                  kbd.nextLine();
                  
                  Statement stmt = conn.createStatement();
            
                  String update = "UPDATE Student SET " + sColumn + " = " + sColumn + arthmetic + num + " WHERE " + sColumn2 + " BETWEEN " + b1 + " AND " + b2;
            
                  stmt.executeUpdate(update);

               }
            }
            
            if(table.equals(instructor))
            {
               System.out.println("What column do you want to update? (instructor_id, last_name, first_name, phone, email, department): ");
               String iColumn = kbd.nextLine();
               iColumn = iColumn.toLowerCase();
               System.out.println("Do you want to just set a value or set a value between values?: (type set or between)");
               String v2 = kbd.nextLine();
               v2 = v2.toLowerCase();
               String set2 = "set";
               String between2 = "between";
               
               if(v2.equals(set2))
               {            
                  System.out.println("Do you want to multiply, divide, add, or subtract? :  (type +, /, -, *)");
                  String arthmetic = kbd.nextLine();
                  System.out.println("What is the number that you want to set?: ");
                  int num = kbd.nextInt();
                  kbd.nextLine();
             
                  Statement stmt = conn.createStatement();
            
                  String update = "UPDATE Instructor SET " + iColumn + " = " + iColumn + arthmetic + num;
            
                  stmt.executeUpdate(update);

               }
               
               if(v2.equals(between2))
               {
                  System.out.println("Do you want to multiply, divide, add, or subtract? :  (type +, /, -, *)");
                  String arthmetic = kbd.nextLine();
                  System.out.println("What is the number that you want to set?: ");
                  int num = kbd.nextInt();
                  kbd.nextLine();
                  System.out.println("What column do you want to check the values between? (instructor_id, last_name, first_name, phone, email, department): ");
                  String iColumn2 = kbd.nextLine();
                  System.out.println("What is the first number you want to set it between");
                  int b1 = kbd.nextInt();
                  kbd.nextLine();
                  System.out.println("What is the second number you want to set it between");
                  int b2 = kbd.nextInt();
                  kbd.nextLine();
                  
                  Statement stmt = conn.createStatement();
            
                  String update = "UPDATE Instructor SET " + iColumn + " = " + iColumn + arthmetic + num + " WHERE " + iColumn2 + " BETWEEN " + b1 + " AND " + b2;
            
                  stmt.executeUpdate(update);
               }
            }
            if(table.equals(enrollment))
            {
               System.out.println("What column do you want to update? (enrollment_id, student_id, course_id, phone, date_of_enrollment): ");
               String eColumn = kbd.nextLine();
               eColumn = eColumn.toLowerCase();
               System.out.println("Do you want to just set a value or set a value between values?: (type set or between)");
               String v3 = kbd.nextLine();
               v3 = v3.toLowerCase();
               String set3 = "set";
               String between3 = "between";
               
               if(v3.equals(set3))
               {            
                  System.out.println("Do you want to multiply, divide, add, or subtract? :  (type +, /, -, *)");
                  String arthmetic = kbd.nextLine();
                  System.out.println("What is the number that you want to set?: ");
                  int num = kbd.nextInt();
                  kbd.nextLine();
             
                  Statement stmt = conn.createStatement();
            
                  String update = "UPDATE Enrollment SET " + eColumn + " = " + eColumn + arthmetic + num;
            
                  stmt.executeUpdate(update);

               }
               
               if(v3.equals(between3))
               {
                  System.out.println("Do you want to multiply, divide, add, or subtract? :  (type +, /, -, *)");
                  String arthmetic = kbd.nextLine();
                  System.out.println("What is the number that you want to set?: ");
                  int num = kbd.nextInt();
                  kbd.nextLine();
                  System.out.println("What column do you want to check the values between? (enrollment_id, student_id, course_id, phone, date_of_enrollment): ");
                  String eColumn2 = kbd.nextLine();
                  System.out.println("What is the first number you want to set it between");
                  int b1 = kbd.nextInt();
                  kbd.nextLine();
                  System.out.println("What is the second number you want to set it between");
                  int b2 = kbd.nextInt();
                  kbd.nextLine();
                  
                  Statement stmt = conn.createStatement();
            
                  String update = "UPDATE Enrollment SET " + eColumn + " = " + eColumn + arthmetic + num + " WHERE " + eColumn2 + " BETWEEN " + b1 + " AND " + b2;
            
                  stmt.executeUpdate(update);

               }
  
            }
            
            if(table.equals(course))
            {
               System.out.println("What column do you want to update? (course_id, course_name, schedule, department, credits, instructor_id): ");
               String cColumn = kbd.nextLine();
               cColumn = cColumn.toLowerCase();
               System.out.println("Do you want to just set a value or set a value between values?: (type set or between)");
               String v4 = kbd.nextLine();
               v4 = v4.toLowerCase();
               String set4 = "set";
               String between4 = "between";
               
               if(v4.equals(set4))
               {            
                  System.out.println("Do you want to multiply, divide, add, or subtract? :  (type +, /, -, *)");
                  String arthmetic = kbd.nextLine();
                  System.out.println("What is the number that you want to set?: ");
                  int num = kbd.nextInt();
                  kbd.nextLine();
             
                  Statement stmt = conn.createStatement();
            
                  String update = "UPDATE Enrollment SET " + cColumn + " = " + cColumn + arthmetic + num;
            
                  stmt.executeUpdate(update);

               }
               
               if(v4.equals(between4))
               {
                  System.out.println("Do you want to multiply, divide, add, or subtract? :  (type +, /, -, *)");
                  String arthmetic = kbd.nextLine();
                  System.out.println("What is the number that you want to set?: ");
                  int num = kbd.nextInt();
                  kbd.nextLine();
                  System.out.println("What column do you want to check the values between? (course_id, course_name, schedule, department, credits, instructor_id): ");
                  String cColumn2 = kbd.nextLine();
                  System.out.println("What is the first number you want to set it between");
                  int b1 = kbd.nextInt();
                  kbd.nextLine();
                  System.out.println("What is the second number you want to set it between");
                  int b2 = kbd.nextInt();
                  kbd.nextLine();
                  
                  Statement stmt = conn.createStatement();
            
                  String update = "UPDATE Enrollment SET " + cColumn + " = " + cColumn + arthmetic + num + " WHERE " + cColumn2 + " BETWEEN " + b1 + " AND " + b2;
            
                  stmt.executeUpdate(update);

               }
            }
           
         }
      
         if(answer.equals(retrieve))
         {
            System.out.println("What table do you want to retrieve from? (Course, Enrollment, Instructor, Student): ");
            String table4 = kbd.nextLine();
            table4 = table4.toLowerCase();
            String course4 = "course";
            String enrollment4 = "enrollment";
            String instructor4 = "instructor";
            String student4 = "student";

            if(table4.equals(student4))
            {
                  Statement stmt = conn.createStatement();
                  String query = "SELECT * FROM Student";
                  ResultSet rs = stmt.executeQuery(query);
                  
                  while(rs.next())
                  {
                     int id = rs.getInt("student_id");
                     String lastName = rs.getString("last_name");
                     String firstName = rs.getString("first_name");
                     String email = rs.getString("email");
                     String major = rs.getString("major");
                     String academicY = rs.getString("academic_year");
                     
                     System.out.println("ID: " + id + "\tLast Name: " + lastName + "\tFirst Name: " + firstName + "\tEmail: " + email + "\tMajor: " + major + "\tAcademic Year: " + academicY);
                  }
            }
            
            if(table4.equals(instructor4))
            {
                  Statement stmt = conn.createStatement();
                  String query = "SELECT * FROM Instructor";
                  ResultSet rs = stmt.executeQuery(query);
                  
                  while(rs.next())
                  {
                     int id = rs.getInt("instructor_id");
                     String lastName = rs.getString("last_name");
                     String firstName = rs.getString("first_name");
                     String phone = rs.getString("phone");
                     String email = rs.getString("email");
                     String department = rs.getString("department");
                     
                     System.out.println("ID: " + id + "\tLast Name: " + lastName + "\tFirst Name: " + firstName + "\tPhone: " + phone + "\tEmail: " + email + "\tDepartment: " + department);
                  }
            }
            
            if(table4.equals(enrollment4))
            {
                  Statement stmt = conn.createStatement();
                  String query = "SELECT * FROM Enrollment";
                  ResultSet rs = stmt.executeQuery(query);
                  
                  while(rs.next())
                  {
                     int id = rs.getInt("enrollment_id");
                     int studentId = rs.getInt("student_id");
                     int courseId = rs.getInt("course_id");
                     String dateEnrollment = rs.getString("date_of_enrollment");
     
                     
                     System.out.println("Enrollment Id: " + id + "\tStudent Id: " + studentId + "\tCourse Id: " + courseId + "\tDate of Enrollment: " + dateEnrollment);
                  }


            }
            
            if(table4.equals(course4))
            {
                  Statement stmt = conn.createStatement();
                  String query = "SELECT * FROM Course";
                  ResultSet rs = stmt.executeQuery(query);
                  
                  while(rs.next())
                  {
                     int id = rs.getInt("course_id");
                     String courseName = rs.getString("course_name");
                     String schedule = rs.getString("schedule");
                     String department = rs.getString("department");
                     int credits = rs.getInt("credits");
                     int iId = rs.getInt("instructor_id");
                     
                     System.out.println("Course Id: " + id + "\tCourse Name: " + courseName + "\tSchedule: " + schedule + "\tDepartment: " + department + "\tCredits: " + credits + "\tInstructor id : " + iId);
                  }


            }
              
         }

        }  
      
      catch(SQLException ex)
      {
         ex.printStackTrace();
      }
   
   }
}



