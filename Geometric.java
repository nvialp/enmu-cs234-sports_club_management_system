

/**
 *
 * @author Rhett Cs234
 * 
 */
import java.lang.Math;

public class Geometric implements Sequences {
    
    // creates three new private variables
    private float initialValue;
    private float element;
    private float ratio;
    
    /**
     * Constructor. It takes two variables and initializes the third by assigning it the same value as initalValue
     */
    public Geometric(float initialValue, float ratio){
        this.initialValue = initialValue;
        this.ratio = ratio;
        this.element = initialValue;
    }// constructor 
    
       public float getInitialValue(){// gets initialValue by simply returning it
          return initialValue;
          
      }// end of getInitialValue
      
       /**
       * implicitly gets element that is calling method and multiplies it to the ratio variable
       * it stores this result in the nextElement variable
       * it then assigns the nextElement to the element variable and returns nextElement
       */
    public float getNext(){
        float nextElement = element * ratio;
        element = nextElement;
        return nextElement;
      }// end of getNext
      
    
      public void restart(){// sets the element calling the method to the intialValue variable
          element = initialValue;
          
      }// end of restart
      
      public void setStart(float value){// lets you start wherever, initialValue is set to whatever the input value is
          this.initialValue = value;
          
      }// end of setStart
      
       /**
       * creates float value that stores initialValue multiplied to the product of ratio raised to the value of element -1.
       * returns that value
       */
      public float getNthElement(int element){
          //Xn = ar(n-1)   x10 = 10*3(10-1)= 10*3(9) = 10*19683 = 196830

          float value = initialValue * (float) (Math.pow(ratio,(element-1)));
          return value;
          
      }// end of getNthElement   
    

    
}
