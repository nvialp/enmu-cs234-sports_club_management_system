
/**
 *
 * @author Rhett CS234
 */

import java.util.ArrayList;
import java.util.Random;
public class Hospital {
    
    private String name; // defining
    private ArrayList<Doctor> listOfDoctors; // defining
    
    public Hospital(String name){
        this.name = name;
        this.listOfDoctors = new ArrayList<>();
    }// Hospital constructor
    
    public void addDoctors(Doctor doctor){// adds doctors to doctors list
        listOfDoctors.add(doctor);
        //stores doctor into list of doctors
        
    }
    /**
     * Creates a random variable called rand. Uses rand to shuffle through doctor list
     * and get a random doctor. Then returns that random index. 
     */
    public Doctor getDoctor(){
        Random rand = new Random();// creates rand
        int randomIndex = rand.nextInt(listOfDoctors.size());//gets random doctor
        return listOfDoctors.get(randomIndex);
        //return doctor object
    }// end of getDoctor
    
    /**
     * Method to heal patient. Patient is passed explicitly and assigned a random doctor using getDoctor. 
     * If the patient already has too low of health using the getHealth than statement is printed showing patient dead
     * If health is not too low it is incremented by one. 
     */
    public void healPatient(Soldier patient){
        System.out.println("Soldier " + patient.getSoldierType() + " is at the hospital.");
        Doctor aDoctor = getDoctor();
        System.out.println("Doctor "+ aDoctor.getName() + " is taking care of the patient.");
        if (patient.getHealth() <= 0){// checks to see if health is zero
            System.out.println("There is nothing we can do. The patient " + patient.getSoldierType() + " is already dead.");
        }else{
            int health = patient.getHealth();// lf health isn't zero increments it by one using health variable
            health++;
            patient.setHealth(health);
            System.out.println("The patient " + patient.getSoldierType() + " is recovering.");
        }// end of else
        
    }// end of heals patient
    
    
    
}// end of class
