/**
 * @author Nicholas Vialpando
 * 2/26/2024
 * cs 234 - lab 5
 */

import java.util.Scanner;
public class cs234_lab5 {
    //initialize static arrays for student information and academic information
    static String[][] studentInfo = new String[100][3];
    static String[][] academicRecord = new String[100][3];
    
    /**
     * this method initiates the addition of a new student.
     * it avoids duplicate entries.
     * the entered information is stored in the 'studentInfo' and 'academicRecords' arrays at the first available empty slot.
     * the method needs to check for duplicate student ID's.
     * it also checks if the arrays are full or not.
     * 
     * the 'findStudentIndex' and 'findEmptySlot' methods are called internally for checking existing student IDs and finding available slots.
     * if student ID does not exist and there is an empty slot, then the method gets the information for a student.
     * after getting all the information for the new student, the method calls the addStudent method to add the information to the arrays.
     * it prints a success message after successfully adding the student.
     */
    public static void option1() {
        //initialize new scanner to take student information
        Scanner in = new Scanner(System.in);
        //initialize variables for student information
        String studentId;
        String name;
        String dob;
        String course;
        String gpa;
        
        System.out.println("*****Add New Student*****");
        //prompt user to enter information for each category
        System.out.print("Enter student ID: ");
        studentId = in.next();
            //check if student exists already by id, if less then zero then student does not exist
            if(findStudentIndex(studentId) < 0) {
                if(findEmptySlot() > -1) {
                    System.out.print("Enter student name: ");
                    name = in.next();
                    System.out.print("Enter date of birth: ");
                    dob = in.next();
                    System.out.print("Enter course: ");
                    course = in.next();
                    System.out.print("Enter GPA: ");
                    gpa = in.next();
                    addStudent(findEmptySlot(), studentId, name, dob, course, gpa);
                    System.out.println("Success, student has been added!");
                }
                else {
                    System.out.println("Error: Student database is full");
                }                
            }
            else {
                System.out.println("Error:  Student with ID " + studentId + " already exists.");
            }
            System.out.println(""); //added blank line for readability
    }
    
    
    public static void addStudent(int index, String studentID, String studentName, String dateOfBirth, String course, String gpa) {
        //declare temporary array to hold student and academic info
        String [] newStudent = new String[3];
        String [] newRecord = new String[3];
        
        //store parameter in new student and new record arrays
        newStudent[0] = studentID;
        newStudent[1] = studentName;
        newStudent[2] = dateOfBirth;
        newRecord[0] = studentID;
        newRecord[1] = course;
        newRecord[2] = gpa;
        
        //insert temp arrays into database
        for(int i = 0; i < newStudent.length; i++) {
            studentInfo[index][i] = newStudent[i];
            academicRecord[index][i] = newRecord[i];
        }
    }
    
    public static int findEmptySlot() {;
        int index;
        //iterate through array to check for null value
        for (int i = 0; i < studentInfo.length; i++) {
            if(studentInfo[i][0] == (null)) {
                return i;
            }
        }
        return -1; //-1 means no empty slot in array
    }
    
    public static void option2() {
        Scanner in = new Scanner(System.in);
        System.out.println("*****Display Student Information*****");
        //prompt user to enter student id
        System.out.print("Enter student ID: ");
        String studentId = in.next();
        
        //check student id
        if(findStudentIndex(studentId) < 0) {
            System.out.println("Student with ID " + studentId + " not found");
        }
        else {
            displayStudentInformation(findStudentIndex(studentId));
        }
        System.out.println(""); //added blank line for readability
    }
    
    public static void displayStudentInformation(int index) {
        //use index to print out the array at that student id
        System.out.println("Student ID: " + studentInfo[index][0]);
        System.out.println("Name: " + studentInfo[index][1]);
        System.out.println("Date Of Birth: " + studentInfo[index][2]);
        System.out.println("Course: " + academicRecord[index][1]);
        System.out.println("GPA: " + academicRecord[index][2]);  
    }
    
    public static void updateStudentInformation() {
        Scanner in = new Scanner(System.in);
        System.out.println("*****Update Student Information*****");
        
        System.out.print("Enter student ID: ");
        String studentId = in.next();
        
        //use same process as option 2
        if(findStudentIndex(studentId) < 0) {
            System.out.println("Student with ID " + studentId + " not found");
        }
        else {
            //use same process from option 1
            System.out.print("Enter new student name: ");
            String name = in.next();
            System.out.print("Enter new date of birth: ");
            String dob = in.next();
            System.out.print("Enter new course: ");
            String course = in.next();
            System.out.print("Enter new GPA: ");
            String gpa = in.next();
            addStudent(findStudentIndex(studentId), studentId, name, dob, course, gpa);
            System.out.println("Student information updated successfully!");
            //display the updated information and record
            displayStudentInformation(findStudentIndex(studentId));
        }
        System.out.println(""); //added blank line for readability
    }
    
    public static void option4() {
        Scanner in = new Scanner(System.in);
        System.out.println("*****Delete Student*****");
        
        System.out.print("Enter student ID: ");
        String studentId = in.next();
        //check student id
        if(findStudentIndex(studentId) < 0) {
            System.out.println("Student with ID " + studentId + " not found");
        }
        else {
           deleteStudent(findStudentIndex(studentId)); 
        }
        System.out.println(""); //added blank line for readability
    }
    
    public static void deleteStudent(int index) {
            for(int i = 0; i < 3; i++) {
                studentInfo[index][i] = null;
                academicRecord[index][i] = null;
            }
            //display that the student has been deleted
            System.out.println("Student deleted successfully!");
        }
    
    /**
     * this method iterates through an array to locate the index of a student whose id matches the specified student id.
     * it returns the index if found; otherwise it returns -1.
     */
    public static int findStudentIndex(String studentID) {        
        //start a for loop to look for student id number which is in 1st column
        for (int i = 0; i < studentInfo.length; i++) {
            //search for student id and return index, student id is only in column 1
            if(studentInfo[i][0] != null && studentInfo[i][0].equals(studentID)) {
                return i;
            }
        }
        //if student id not found, return -1
        return -1;
    }
        
    public static void Menu() {
         Scanner in = new Scanner(System.in);
         byte menuSelection;         
         
         //create main munu with do while loop to keep presenting menu for false choices
         do {
             System.out.println("*****STUDENT DATABASE MANAGEMENT SYSTEM*****");
             System.out.println("| 1. Add New Student:                      |");
             System.out.println("| 2. Display Student Information           |");
             System.out.println("| 3. Update Student Information            |");
             System.out.println("| 4. Delete Student                        |");
             System.out.println("| 5. Exit                                  |");
             System.out.println("********************************************");
             
             System.out.print("Enter your choice: ");
             menuSelection = in.nextByte();
             System.out.println("");  //added a line for readability
             
             switch(menuSelection) {
                 case 1: option1();
                 break;
                 
                 case 2: option2();
                 break;
                 
                 case 3: updateStudentInformation();
                 break;
                 
                 case 4: option4();
                 break;
                 
                 //exit condition
                 case 5: System.out.println("Exiting the program. Goodbye!");
                 break;
                 
                 //default case when none of the given options is entered
                 default: System.out.println("Invalid choice.  Please try again."); 
             }
         }
         //initialize loop exit condition for option 5
         while(menuSelection != 5);
     }
    
    public static void main(String[] args) {
                
        //call main menu
        Menu();
    }
    
}
