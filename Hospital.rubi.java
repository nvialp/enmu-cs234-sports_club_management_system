

/******************************************************************************
Rubi Guttierrez-Madrid
*******************************************************************************/
//imports ArrayLists and Random utilities
import java.util.ArrayList;
import java.util.Random;

public class Hospital{
    //instance variables
    private String name;
    private ArrayList<Doctor> doctors;
    
    //constructor
    public Hospital(String name){
        this.name = name;
        this.doctors = new ArrayList<>();
    }
    
    //adds doctor to doctor list
    public void addDoctors(Doctor doctor){
        doctors.add(doctor);
    }
    
    //gets random doctor from list
    public Doctor getDoctor(){
        //creates random element object
        Random rand = new Random();
        //picks random integer within the size of the doctors list
        int randomElement = rand.nextInt(doctors.size());
        //returns doctor at the index of random Element
        return doctors.get(randomElement);
    }
    
    //accepts Soldier variable as patient
    public void healPatient(Soldier patient){
        //prints out the patient that is at the hospital
        System.out.println("The " + patient.getSoldierType() + " is at the hospital");
        //creates a Doctor object someDoctor that equals the doctor at the random index
        Doctor someDr = getDoctor();
        //prints out what doctor is taking care of the patient
        System.out.println("Doctor " + someDr.getName() + " is taking care of the " + patient.getSoldierType());
        //if the patient's health is equal to or less than 0
        if (patient.getHealth() <= 0){
            //prints out message of patient being dead
            System.out.println("There is nothing we can do. The patient " + patient.getSoldierType() + " is already dead");
        }
        
        //if the patient's health is not 0
        else {
            //creates new integer that is equal to the patient's health +1
            int healthy = patient.getHealth() + 1 ;
            //sets new health as patient's health
            patient.setHealth(healthy);
            
            //prints out that the patient is recovering
            System.out.println("The patient " + patient.getSoldierType() + " is recovering");
        }
    }

}
