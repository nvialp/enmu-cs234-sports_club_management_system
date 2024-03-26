

/**
 *
 * @author Rhett CS234
 */
public interface Sequences {
//    
//    The interface Sequences
//1. getInitialValue. It gets the initial value of the sequence.
//2. getNext. It gets the next element in the sequence
//3. restart. It restarts the sequence to its initial values
//4. setStart. It sets the starting value for the sequence
//5. getNthElement. It returns the N-th element in the sequence.
//
//    
    
    public float getInitialValue();
    
    public float getNext();
    
    public void restart();
    
    public void setStart(float value);
    
    public float getNthElement(int element);
    
    
}
