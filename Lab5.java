
/**
 *
 * @author Rhett, CS234
 */

import java.util.Scanner;

public class Lab5 {
    
    public static int findStudentIndex(String studentID){
        for(int i = 0; i < studentInfo.length; i++){
            if (studentInfo[i][0] != null && studentInfo[i][0].equals(studentID))// makes sure value isn't null before checking if it equals
                return i;
        }//end of for loop
        
        return -1;// if -1 returns it means student ID doesn't exist
    }//end of findStudentIndex method
    
    public static void deleteStudent(int index){
        for (int i = 0; i < studentInfo.length; i++){
            //if (studentInfo[i][0] !=null && studentInfo[i][0].equals(index))
            if (i == index)
                for (int j = 0; j < 3; j++){
                    studentInfo[i][j] = null;
                    academicInfo[i][j] = null;
                }//end of for
                
        }// end of if
            
        
    }// end of deleteStudent
    
    public static void addStudent(int index, String studentID, String studentName, 
            String dateOfBirth, String course, String gpa){
        String [] tempStudent = new String[3];
        String [] tempAcademic = new String[3];
        tempStudent[0] = studentID;
        tempStudent[1] = studentName;
        tempStudent[2] = dateOfBirth;
        tempAcademic[0] = studentID;
        tempAcademic[1] = course;
        tempAcademic[2] = gpa;
     
        
        for (int i = 0; i < tempStudent.length; i++){
            studentInfo[index][i] = tempStudent[i];
            academicInfo[index][i] = tempAcademic[i];
        }//end of for loop
        
        
    }//end of addStudent
    
    public static int findEmptySlot(){
        for (int i = 0; i< studentInfo.length; i++){
            if (studentInfo[i][0] == (null))
                return i;
            
        }//end of for loop
        
        
        return -1;// means there are no empty slots left
        
    }//end of findEmptySlot
        
    public static void displayStudentInformation(int index){
        for (int i = 0; i < studentInfo.length; i++){
                if (i == index){
                    System.out.println("Student ID: " + studentInfo[i][0]);
                    System.out.println("Name: " + studentInfo[i][1]);
                    System.out.println("Date of Birth: " + studentInfo[i][2]);
                    System.out.println("Course: " + academicInfo[i][1]);
                    System.out.println("GPA: " + academicInfo[i][2]);
                }else
                    if(i == studentInfo.length){
                        System.out.println("Not in the database ");
                    }
        }          
        
    }//end of displayStudentInformation
    
    public static void updateStudentInformation(){       
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me a student ID: ");// gets student ID
        String userInput = scanner.nextLine();
        int indexNumber = findStudentIndex(userInput); //checks method. If its there it returns index #, else -1
        if (indexNumber < 0){
            System.out.println("Student with ID " + userInput +" not found");
        }else{
            if (indexNumber >= 0)
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter Date of Birth (MM/DD/YYYY): ");
            String birthDate = scanner.nextLine();
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();
            System.out.print("Enter GPA: ");
            String GPA = scanner.nextLine();
            addStudent(indexNumber, userInput, studentName, birthDate, course, GPA );
            System.out.println("Student information updated successfully! ");
        }//end of else
        
       
    }//end of updateStudentInformation
    
    public static void option1(){
        System.out.println("***** Add New Student *****");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String userInput = scanner.nextLine();
        int existing = findStudentIndex(userInput);
        int newSlot = 0;
        
        if (existing < 0){// if existing returns -1 then it means student index doesn't exist
            newSlot = findEmptySlot();
                if (newSlot >= 0){// if newSlot isn't -1 it means there is still empty spaces left to fill
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (MM/DD/YYYY): ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    String GPA = scanner.nextLine();
                    addStudent(newSlot, userInput, studentName, birthDate, course, GPA );
                    System.out.println("Success, student has been added! ");
                }else{
                    System.out.println("Error: Student database is full ");
                }
        }else{
            System.out.print("Error: Student with ID " + userInput + " already exists.\n");
        }//end of first if else
        
        
        
    }// end of option 1
    
    public static void option2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");// gets user input
        String userInput = scanner.nextLine();// stores user input in variable userInput
        int existing = findStudentIndex(userInput);// calls function to check if its there. If return is -1 it doesn't exist. 
        if ( existing >= 0){
            displayStudentInformation(existing);
        }else{
            System.out.println("Student with ID " + userInput + " not found.");
        }//end of else if
        
    }//end of option 2
    
    public static void option4(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me a student ID: ");// gets student ID from user
        String userInput = scanner.nextLine();
        int existing = findStudentIndex(userInput);// checks to see if StudentID already exists
            if ( existing >= 0){//if exists calls deletefunction
            deleteStudent(existing);
        }else{// if can't find it prints out statement
            System.out.println("The student has not been located: ");
        }//end of else if
        
    }//end of option 4
    
    
    static String [][] studentInfo = new String[100][3];
    static String [][] academicInfo = new String [100][3];

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = true;
        int choice;
        
       
        
        do{
            System.out.print("***** Student Database Management System *****\n"
                    + "1. Add New Student: \n"
                    + "2. Display Student Information: \n"
                    + "3. Update Student Information: \n"
                    + "4. Delete Student: \n"
                    + "5. Exit: \n"
                    + "Enter your choice: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    updateStudentInformation();
                    break;
                case 4:
                    option4();
                    break;
                case 5:
                    System.out.println("Exiting, thank you");
                    done = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again: ");
                
            }// end of switch
                    
           
        }// end of do 
        while(done);
    }//end of Main
}// end of program

