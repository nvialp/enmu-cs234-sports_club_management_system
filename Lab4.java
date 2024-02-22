/*
 * 
 */

/**
 *
 * @author rhett
 */

import java.util.Scanner;

public class Lab4 {

     public static void reg_option1(){
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Give me a string: ");
        s = scanner.nextLine();
        int number = countA(s);
        System.out.println("\nThere are " + number + " a's in your string: " + "\n" );
        System.out.print("~~~~~~~~~~~~~~~\n"
                + "1. Count number of A's\n"
                + "2. Replace Target Character\n"
                + "3. Return Main\n"
                + "~~~~~~~~~~~~~~~~\n"
                + "Enter your choice: ");
    }// end of reg_option1
    
    public static void reg_option2(){
         Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.println("Give me a string: ");
        userInput = scanner.nextLine();
        String A;
        System.out.print("Give me a target letter to replace: ");
        A = scanner.nextLine();
        String B;
        System.out.print("Give me the replacement character: ");
        B = scanner.nextLine();
        char a = A.charAt(0);
        char b = B.charAt(0);
        String newString = replace(userInput, a, b);
        System.out.println("\nYour new string is " + newString + "\n");
        System.out.print("~~~~~~~~~~~~~~~\n"
                + "1. Count number of A's\n"
                + "2. Replace Target Character\n"
                + "3. Return Main\n"
                + "~~~~~~~~~~~~~~~~\n"
                + "Enter your choice: ");
    } // end of reg_options2
    
    public static String replace(String s, char a, char b){  // char a is one to be replaced, char b is new character
        String changedString = "";
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == a){
                changedString += b;
            }else {
                changedString += s.charAt(i);
            }
        }
        return changedString;
    }/// end of replace method
    
    public static int countA(String s){
        int counter = 0;
        char letter = 'a';
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == letter){
                counter++;
                }
            }
        return counter;
    } // end of method countA
     
    
      public static void rec_option1(){
        Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.print("Give me a string: ");
        userInput = scanner.nextLine();
        String A;
        System.out.print("Give me a target letter: ");
        A = scanner.nextLine();
        char a = A.charAt(0);
        boolean output = containsCharacter(userInput, a);
        if (output == true){
            System.out.println("\nYour string contains " + a + "\n");
            System.out.print("~~~~~~~~~~~~~~~\n"
                    + "1. Search Character \n"
                    + "2. Return Main \n"
                    + "~~~~~~~~~~~~~~~~~~\n"
                    + "Enter your choice: ");
        }
        else{
           System.out.println("Your string does not contain " + a + "\n");
           System.out.print("~~~~~~~~~~~~~~~\n"
                    + "1. Search Character \n"
                    + "2. Return Main \n"
                    + "~~~~~~~~~~~~~~~~~~\n"
                    + "Enter your choice: ");
        }
    }//end of rec_option1
    
    public static boolean containsCharacter(String str, char a){
        if (str.length() == 0){
            return false;
        }
        if (str.charAt(0) == a){
            return true;
        }
        return containsCharacter(str.substring(1), a);
    }//end of containsCharacter
    
      public static void Menu(){
        Scanner scanner = new Scanner(System.in);
        boolean done = true;
        int choice;
        System.out.print("~~~~~~~~~~~~~~~\n"
                + "Main Menu:\n"
                + "1. Regular Methods\n"
                + "2. Recursive Methods\n"
                + "3. Quit\n"
                + "~~~~~~~~~~~~~~~~~~\n"
                + "Enter your choice: ");
        do{
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    MenuRegular();
                    break;
                case 2:
                    MenuRecursive();
                    break;
                case 3:
                    done = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again: ");
                    System.out.print("~~~~~~~~~~~~~~~\n"
                                    + "Main Menu:\n"
                                    + "1. Regular Methods\n"
                                    + "2. Recursive Methods\n"
                                    + "3. Quit\n"
                                    + "~~~~~~~~~~~~~~~~~~\n"
                                    + "Enter your choice: ");
                    
            }
            
            
            
            
        }
        while (done);
        
    }// end of Menu
      
      public static void MenuRegular(){
        Scanner scanner = new Scanner(System.in);
        boolean done = true;
        int choice;
        System.out.print("~~~~~~~~~~~~~~~\n"
                + "1. Count number of A's\n"
                + "2. Replace Target Character\n"
                + "3. Return Main\n"
                + "~~~~~~~~~~~~~~~~~~\n"
                + "Enter your choice: ");
        do{
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    reg_option1();
                    break;
                case 2:
                    reg_option2();
                    break;
                case 3:
                    done = false;
                    System.out.print("~~~~~~~~~~~~~~~\n"
                                    + "Main Menu:\n"
                                    + "1. Regular Methods\n"
                                    + "2. Recursive Methods\n"
                                    + "3. Quit\n"
                                    + "~~~~~~~~~~~~~~~~~~\n"
                                    + "Enter your choice: ");
                    break;
                default:
                    System.out.println("Invalid choice, please try again: ");
                    System.out.print("~~~~~~~~~~~~~~~\n"
                    + "1. Count number of A's\n"
                    + "2. Replace Target Character\n"
                    + "3. Return Main\n"
                    + "~~~~~~~~~~~~~~~~~~\n"
                    + "Enter your choice: ");
            }
            
        }
        while (done);
        
    }// end of MenuRegular
      
      public static void MenuRecursive(){
          
          Scanner scanner = new Scanner(System.in);
        boolean done = true;
        int choice;
        System.out.print("~~~~~~~~~~~~~~~\n"
                + "1. Search Character \n"
                + "2. Return Main \n"
                + "~~~~~~~~~~~~~~~~~~\n"
                + "Enter your choice: ");
        do{
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    rec_option1();
                    
                    break;
                case 2:
                    done = false;
                    System.out.print("~~~~~~~~~~~~~~~\n"
                                    + "Main Menu:\n"
                                    + "1. Regular Methods\n"
                                    + "2. Recursive Methods\n"
                                    + "3. Quit\n"
                                    + "~~~~~~~~~~~~~~~~~~\n"
                                    + "Enter your choice: ");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.\n ");
                    System.out.print("~~~~~~~~~~~~~~~\n"
                    + "1. Search Character \n"
                    + "2. Return Main \n"
                    + "~~~~~~~~~~~~~~~~~~\n"
                    + "Enter your choice: ");
            }
            
        }
        while (done);
          
      }// end of MenuRecursive
      
      
    
    
    public static void main(String[] args) {
        Menu();
    }//end of main 
}/// end of program
        

//reg_option1
//countA
//reg_option2
//replace
//rec_option1
//containsCharacter
//Menu
//MenuRegular
//MenuRecursive


