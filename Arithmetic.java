
/**
 *
 * @author rhett
 */
public class Arithmetic implements Sequences {
    // create three private variables
    private float initialValue;
    private float element;
    private float difference;
    
    /**
     * Constructor. It takes two variables and initializes the third by assigning it the same value as initalValue
     */
    public Arithmetic(float initialValue, float difference){
        this.initialValue = initialValue;
        this.difference = difference;
        this.element = initialValue;
        
    }// end of constructor 
    
      public float getInitialValue(){// Gets initialValue by simply returning it
          return initialValue;
          
      }// end of getInitialValue
      
      
      /**
       * implicitly gets element that is calling method and adds it to the difference variable
       * it then adds to the element variable and returns it
       */
      public float getNext(){
          this.element = element + difference;
          return element;
      }// end of getNext
      
      public void restart(){// sets the element calling the method to the intialValue variable
          this.element = initialValue;
          
      }// end of restart
      
      public void setStart(float value){// lets you start wherever, initialValue is set to whatever the input value is
          this.initialValue = value;
          
      }// end of setStart
      
      /**
       * creates float value that stores initialValue added to the product of difference and the value element -1.
       * returns that value
       */
      public float getNthElement(int element){
          //xn = a + d(n-1)
          float value = this.initialValue + (this.difference*(element-1));
          return value;
          
      }// end of getNthElement


}
