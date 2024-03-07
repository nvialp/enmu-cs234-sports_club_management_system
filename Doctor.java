

/**
 *
 * @author Rhett CS234
 */
public class Doctor {
    private String name; //defining
    
    public Doctor(String name){// constructor
        this.name = name;
           
    }// end of constructor
    
    public String getName(){// returns name
         return name;
    }// end of getName
    
   public void setName(String name){// sets name for Doctor
       this.name = name;
   }// end of setName
}
