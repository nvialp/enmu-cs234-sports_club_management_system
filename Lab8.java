
/**
 *
 * @author Rhett CS234
 */
public class Lab8 {

    public static void main(String[] args) {
        Sequences s1 = new Arithmetic(3,5);
        Sequences s2 = new Geometric(4,0.5f);
        
        System.out.println("The initial value for the arithmetic sequence is " + s1.getInitialValue());
        for (int i = 0; i < 5; i++)
        {
            System.out.println("\tNext value for the Arithmetic sequence is: " + s1.getNext());
            
        }
        
        System.out.println("The value for the 9th element in the sequence is: " + s1.getNthElement(9));
        
        System.out.println("The initial value for the Geometric sequence is: " + s2.getInitialValue());
        
        for (int i = 0; i < 10; i++)
        {
            System.out.println("\tNext value for the Geometric sequence is: " + s2.getNext());
             if (i==5)
             {
                 s2.restart();
                 System.out.println("The initial value for the Geometric sequence is: " + s2.getInitialValue());
                 
             }
        }
        
        System.out.println("The value for the 10th element in the sequence is: " + s2.getNthElement(10));
        
        // Change the starting value
        s1.setStart(100);
        s2.setStart(200);
        
        System.out.println("The initial value for the Arithmetic sequence is: "+ s1.getInitialValue());
        System.out.println("The 3rd element is: " + s1.getNthElement(3));
        System.out.println("The initial vlaue for the Geometric sequence is: " + s2.getInitialValue());
        System.out.println("The 4th element is: " + s2.getNthElement(4));
        
        
    }
}
