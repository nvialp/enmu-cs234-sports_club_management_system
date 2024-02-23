/*Rubi Guttierrez Madrid*/

//imports Scanner
import java.util.Scanner;


public class Lab4
{
 //main method that calls menu method
  public static void main (String[]args)
  { 
	Menu ();
  }

  //main menu method
  public static void Menu (){ 
    //initializes & defines input  
    byte input =0;  
    
    //do while loop for ivalid choice
    do{  
    //prints out menu    
	System.out.println ("~~~~~~~~~~~~" + "\n" +
						"Main Menu:" + "\n" +
						"1. Regular Methods" + "\n" +
						"2. Recursive Methods" + "\n" +
						"3. Quit" + "\n" +
						"~~~~~~~~~~~~" + "\n" + "Enter your choice: ");
	//creates first scanner object					
	Scanner sc1 = new Scanner (System.in);
	//saves input
	input = sc1.nextByte ();
    
    //switch cases that call other methods 
	switch (input)
	  {
	  case 1:
		MenuRegular ();
		break;
	  case 2: 
	    MenuRecursive();
	    break;
	  case 3:
	      System.out.println("Exiting the program. Bye Bye!");
	      break;
	  //if the input does not equal any of the case numbers it prints invalid choice    
	  default: 
	        System.out.println("Invalid choice. Try again");
	        break;
	  }
	//loops around if input is invalid 
    }while (input!=3);
  }


  //method for regular methods menu
  public static void MenuRegular ()
  { 
    //initializes and defines input2  
    byte input2=0;
    //do while loop for invalid choise
    do{  
    //prints out regular methods menu options    
	System.out.println ("1. Count Number of As" + "\n" +
						"2. Replace Target Character" + "\n" +
						"3. Return to Main Menu" + "\n" +
						"Enter your choice: ");
	//creates scanner object					
	Scanner sc3 = new Scanner (System.in);
	//saves user input
	input2 = sc3.nextByte ();
    //switch to call method depending on what choice is picked
	switch (input2)
	  {
	  case 1:
		reg_option1 ();
		break;
	  case 2:
		reg_option2 ();
		break;
	  case 3:
		break;
	  //if input does not equal any choices prints invalid choice method	
	  default: 
	       System.out.println("Invalid choice. Try again");
	       break;
	  }
	//loops if input2 is not one of the options given  
    }while (input2 !=3);
  }
  
    //method for recursive methods menu
  	public static void MenuRecursive ()
	{ //initializes and definies input 4
	  byte input4= 0;
	  //do while loop for invalid answer
	  do{
	  //prints out recursive methods menu    
	  System.out.println ("1. Search Character" + "\n" +
						  "2. Return to Main Menu");
	  //creates scanner object				  
	  Scanner sc6 = new Scanner (System.in);
	  //saves input
	  input4 = sc6.nextByte ();
	  //switch for input choices
	  switch(input4){
	      case 1:
	          rec_option1();
	          break;
	      case 2: 
	          break;
	       // if input choice is not 1 or 2 prints out invalid choice message   
	      default: 
	          System.out.println("Invalid choice. Try again");
	          break;
	  }
	  //loops while input is not 1 or 2
	  }while (input4 !=2);
	}
	
	//method for recursive methods menu option 1
	public static void rec_option1(){
	  //prompts user to input a string and saves input  
	  System.out.println ("Write a string: ");
	  Scanner sc7 = new Scanner (System.in);
	  String str = sc7.next();
      //prompts user to input target character and saves input
	  System.out.println ("Write the target character: ");
	  Scanner sc8 = new Scanner (System.in);
	  char chartarget = sc8.next().charAt(0);
	  
	  //if else loop that calls containsCharacter method and prints out true or false 
	  if (containsCharacter(str,chartarget) == true){
	      System.out.println("True");
	  }
	  else {
	      System.out.println("False");
	  }
	  
	}
	
	
	//method for rec_option1 to find character in string
	public static boolean containsCharacter (String str, char chartarget)
	{
        if (str.length()== 0){
            return false;
        }
        
        //if character at index is there, returns true
        if (str.charAt(0)==chartarget){
            return true;
        }
        return containsCharacter(str.substring(1), chartarget);
	}

  //method for regular methods option 1
  public static void reg_option1 ()
  {
    //prompts user to enter string and saves input 
	System.out.println ("Write the string: ");
	Scanner sc2 = new Scanner (System.in);
	String s = sc2.next ();
	//calls countA method and prints number of As
	System.out.println ("There are: " + countA (s) + " a's");
  }

  //method to count number of A's in string for reg_option1
  public static int countA (String s)
  {
    //initializes count and characters  
	int count = 0;
	char a = 'a';
	char A = 'A';
	
	//for loop to go through every letter in strintg
	for (int i = 0; i < s.length (); i++)
	  {

		char letter = s.charAt (i);
        
        //if a is found, adds to count
		if ((letter == a) || (letter == A))
		  {
			count = count + 1;
		  }
	  }
	//returns amount of As  
	return count;
  }

  //method for regular methods option 2
  public static void reg_option2 ()
  {
    //prompts user to enter string and saves input  
	System.out.println ("Write the string: ");
	Scanner sc4 = new Scanner (System.in);
	String inputstring = sc4.next ();
    
    //prompts user to enter target character and saves input
	System.out.println ("Write the target character: ");
	Scanner sc5 = new Scanner (System.in);
	char target = sc5.next ().charAt (0);

    //prompts user to enter new character and saves input
	System.out.println ("Write the new character:");
	Scanner sc6 = new Scanner (System.in);
	char newchar = sc6.next ().charAt (0);

    //calls replace method and prints out new string
	System.out.println (replace (inputstring, target, newchar));

  }

  //method to replace target character in string with new character
  public static String replace (String inputstring, char target, char newchar)
  {
    //initializes and defines an empty string  
	String newstring = "";

    //for every letter in inputstring
	for (int j = 0; j < inputstring.length (); j++)
	  {
        //if the letter at the index equals the target character
		if (inputstring.charAt (j) == target)
		  {
            //empty string adds the new character
			newstring += newchar;
		  }
		//if letter at index does not equal target character  
		else
		  {
		    //old character is saved in newstring
			newstring += inputstring.charAt (j);
		  }
	  }
	//returns string with replaced characters   
	return newstring;
  }
}
