/*Rubi Guttierrez-Madrid
****/

//imports scanner
import java.util.Scanner;

public class Lab5
{
    //initializes 2d arrays outside of methods 
    static String [] [] studentInfo = new String [100][3];
    static String [] [] academicRecords = new String [100][3];

  
    //main method
	public static void main(String[] args) {
    	    
    	/*code to to fill string for testing
    	
    	//creates string rabbit
    	String rabbit = "rabbit";
        
        //loops through each row
        for (int i = 0; i < studentInfo.length; i++){
          //loops through each column
          for (int j = 0; j< studentInfo[i].length; j++){
              //fills index with rabbit
              studentInfo[i][j] = rabbit;
          }
        } */
        
 
        //creates input variable
        int input1=0;
        
        //start of do while loop
        do{
        
        //prints out menu    
	    System.out.println("***** Student Database Management System *****"+ "\n"+
	                        "1. Add New Student" + "\n"+
	                        "2. Display Student Information"+ "\n"+
	                        "3. Update Student Information" + "\n"+
	                        "4. Delete Student"+"\n"+
	                        "5. Exit"+ "\n");
	    //creates scanner for input
	    Scanner scan2 = new Scanner(System.in);
	    //saves input into variable input1
	    input1 = scan2.nextInt();
        
        //switch for input options
        switch(input1){
            //when option 1 is chosen
            case 1:
                //calls option1() method
                option1();
                break;
            //when option 2 is chosen    
            case 2: 
                //calls option2() method
                option2();
                break;
            //when option 3 is chosen
            case 3: 
                //calls updateStudentInformation() method
                updateStudentInformation();
                break;
            //when option 4 is chosen
            case 4:
                //calls option4() method
                option4();
                break;
            //when option 5 is chosen    
            case 5:
                //prints exiting message
                System.out.println("Exiting the program");
                break;
            //if input1 does not equal one of the options    
            default:
                //prints invalid option message
                System.out.println("Invalid option. Please try again"+"\n");
                break;
        }
        
        }while (input1!=5);//loops back to main menu unless option 5 is chosen
	}
	
	//method for option1()
	public static void option1(){
    
        //creates new scanner scan1
        Scanner scan1 = new Scanner(System.in);
        //prints add new student and prompts user to enter student ID
        System.out.println("***** Add New Student *****"+ "\n" +
                           "Enter Student ID: ");
        //saves input as student ID
        String studentID = scan1.next();
        
        //saves the returned integer of findStudentIndex() when studentID is entered as a parameter
        int exists = findStudentIndex(studentID);
        //initializes index of 0
        int index = 0;
        
        //if exists (the return value of findStudentIndex() method is less than 0)
        if(exists < 0){
            //sets findEmptySlot return value as index
            index = findEmptySlot();
            
            //if index is (return value of findEmptySlot() method) is greater than or equal to 0
            if (index >= 0){
                
                //prompts user to enter student name and saves input
                System.out.println("Enter Student Name: ");
                Scanner scan4 = new Scanner(System.in);
                String studentName = scan4.next();
                
                //prompts user to enter date of birth and saves input
                System.out.println("Enter Date of Birth (MM/DD/YYYY): ");
                Scanner scan5 = new Scanner(System.in);
                String dateOfBirth = scan5.next();
                
                //prompts user to enter course and saves input
                System.out.println("Enter Course: ");
                Scanner scan6 = new Scanner(System.in);
                String course = scan6.next();
                
                //prompts user to enter GPA and saves input
                System.out.println("Enter GPA: ");
                Scanner scan7 = new Scanner(System.in);
                String gpa = scan7.next();
                
                //calls method addStudent() with input and saved variables 
                addStudent(index, studentID, studentName, dateOfBirth, course, gpa);
                //prints out success message
                System.out.println("Student added successfully!"+ "\n");
            }
            
            //if index (return value of findEmptySlot() method) is less than 0    
            else{
                //prints out message stating database is full
                System.out.println("Error: Student database is full"+ "\n");
            }
                
        }
        //if exists (return value of findStudentIndex() method) is not less than 0 
        else{
            //prints error message of student ID already existing
            System.out.println("Error: Student with ID " + studentID + " already exists."+ "\n");
        }
        
    }
    
    
   // method to find student ID in array
   public static int findStudentIndex(String studentID){
       //for every row in studentInfo array
       for (int i =0; i< studentInfo.length; i++){
          //if the row in the first column of row i is not empty or equals studentID (find student ID)
          if (studentInfo[i][0]!= null && studentInfo[i][0].equals(studentID)){
              //returns row index
              return i;
          }
       }
       //if row in first column is empty or does not equal studentID returns value of -1 (cannot find student ID)
       return -1;
    }

    //method to find empty slot in array
    public static int findEmptySlot(){
        //for every row in studentInfo array
        for (int j= 0; j< studentInfo.length; j++){
            //if the first column of row j is empty
            if(studentInfo[j][0] == null){
                //returns index of row
                return j;
            }
        }
        //if all rows in first column are full, returns value of -1
        return -1;
    }
    
    
    //method to add student   
    public static void addStudent(int index, String studentID, String studentName, String dateOfBirth, String course, String gpa){
        //sets information in appropriate row and column of studentInfo array
        studentInfo[index][0] = studentID;
        studentInfo[index][1] = studentName;
        studentInfo[index][2] = dateOfBirth;
        
        //sets information in appropriate row and column of academicRecords array
        academicRecords[index][0] = studentID;
        academicRecords[index][1] = course;
        academicRecords[index][2] = gpa;
    }
    
    //method for option2 
    public static void option2(){
        //prints out chosen option and prompts user to enter student ID
        System.out.println("***** Display Student Information *****" + "\n" +
                           "Enter Student ID: ");
        //creates new scanner and saves input as student ID
        Scanner scan8 = new Scanner(System.in);
        String studentID = scan8.next();
        
        //saves the returned integer of findStudentIndex() when studentID is entered as a parameter 
        int index = findStudentIndex(studentID);
        
        //if exists (the return value of findStudentIndex() method) is less than 0
        if (index < 0){
            //prints out error if entered student ID is not found in index
            System.out.println("Error: Student does not exist" + "\n");
        }
        
        //if entered student ID is found in index
        else{
            //calls displayStudentInformation() method with index as parameter
            displayStudentInformation(index);
        }
    }
    
    
    //method to display student's information with index of student ID as parameter
    public static void displayStudentInformation(int index){
        
        //for every column in the index row of studentInfo
        for (int i = 0; i < studentInfo[index].length; i++){
            //for the first column
            if( i==0 ){
                //prints student ID
                System.out.println("Student ID: " + studentInfo[index][i]);
            }
            //for the second column
            if (i ==1){
                //prints name
                System.out.println("Name: " + studentInfo[index][i]);
            }
            //for third column
            else{
                //prints date of birth
                System.out.println("Date of Birth: " + studentInfo[index][i]);
            }
        }
        //for every columm in the index row of academicRecords
        for (int i = 0; i < academicRecords[index].length; i++){
            //for the second column
            if (i ==1){
                //prints course
                System.out.println("Course: " + academicRecords[index][i]);
            }
            //for third column
            if (i == 2){
                //prints out GPA
                System.out.println("GPA:  " + academicRecords[index][i]+ "\n");
            }
        }
    
    }
    
    
    //method to update student's information
    public static void updateStudentInformation(){
        
        //prints out option 3 and prompts user to enter student ID
        System.out.println("***** Update Student Information *****" + "\n" +
                           "Enter Student ID: ");
        //creates scanner and saves input as student ID
        Scanner scan9 = new Scanner(System.in);
        String studentID = scan9.next();
        
        //saves the returned integer of findStudentIndex() when studentID is entered as a parameter
        int index = findStudentIndex(studentID);
        //if index (the return value of findStudentIndex() method is less than 0
         if (index < 0){
            //prints out error message when student ID is not found
            System.out.println("Error: Student does not exist" + "\n");
        }
        
        //if entered student ID is found in index 
        else{
            
            //prompts user to enter student ID and saves input
            System.out.println("Enter Student ID: ");
            Scanner scan10 = new Scanner(System.in);
            studentID = scan10.next();
            
            //prompts user to enter name and saves input
            System.out.println("Enter Student Name: ");
            Scanner scan11 = new Scanner(System.in);
            String studentName = scan11.next();
            
            //prompts user to enter date of birth and saves input
            System.out.println("Enter Date of Birth (MM/DD/YYYY): ");
            Scanner scan12 = new Scanner(System.in);
            String dateOfBirth = scan12.next();
            
            //prompts user to enter course and saves input
            System.out.println("Enter Course: ");
            Scanner scan13 = new Scanner(System.in);
            String course = scan13.next();
            
            //prompts user to enter gpa and saves input
            System.out.println("Enter GPA: ");
            Scanner scan14 = new Scanner(System.in);
            String gpa = scan14.next();
            
            //calls addStudent() to save input variables into proper rows and columns
            addStudent(index, studentID, studentName, dateOfBirth, course, gpa);
            System.out.println("Student updated successfully!" + "\n");
        }
    }
    
    
    //method for option 4
    public static void option4(){
        //prints out option and prompts user to enter student ID
         System.out.println("***** Delete Student *****" + "\n" +
                           "Enter Student ID: ");
        //creates scanner and saves input
        Scanner scan15 = new Scanner(System.in);
        String studentID = scan15.next();
        
        //saves the returned integer of findStudentIndex() when studentID is entered as a parameter
        int index = findStudentIndex(studentID);
         //if index (the return value of findStudentIndex() method is less than 0
         if (index < 0){
             //prints error message that entered student ID is not found
            System.out.println("Error: Student does not exist" +"\n");
        }
        //if entered student ID is found in index
        else{
            //calls deleteStudent() with index as parameter
            deleteStudent(index);
            //prints successful deleting
            System.out.println("Student deleted successfully!" + "\n");
        }
        
    }
    
    //method to delete student at index row
    public static void deleteStudent(int index){
        //for every column in row index of studentInfo
        for (int j = 0; j < studentInfo[index].length; j++){
            //sets columns in index row of studentInfo to empty
            studentInfo[index][j] = null;
            //sets columns in index row of academicRecords to empty
            academicRecords[index][j]=null;
        }
    }
}
