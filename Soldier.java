

/**
 *
 * @author Rhett CS234
 */
import java.util.ArrayList;
public class Soldier {
    
    private int health; // defining health
    private String soldierType; //defining what kind of soldier
    private ArrayList<String> weapons; //defining arraylist
    
    public Soldier(){// constructor 1
        this.health = 10;
        this.soldierType = "";
        this.weapons = new ArrayList<>();        
    }// end of constructor 1
    
    public Soldier(int health, String soldierType){// constructor 2
        this.health = health;
        this.soldierType = soldierType;
        this.weapons = new ArrayList<>();
    }// end of constructor 2
    
    public int getHealth(){// returns an integer value of health
        return health;
    }// end of getHealth
    
    public void setHealth(int health){
        this.health = health;
    }// end of setHealth
    
    public String getSoldierType(){
        return soldierType;
    }// end of getSoldierType
    
    public void setSoldierType(String soldierType){// gets string input for soldiertype
        this.soldierType = soldierType;
    }// of of set soldierType
    
    
    /**
     * Passes whatever enemy is getting shot explicitly and decreases health by one using getHealth
     * prints out statement showing who got shot and who did the shooting using this
     * If health is 0 prints message showing enemy is dead
     */
    
    public void shootEnemy(Soldier enemy){
        health = enemy.getHealth();// get enemy health
        health--;// decrease it by one
        System.out.println("The " + this.getSoldierType() + " shoots at the " + enemy.getSoldierType());
        if (health <= 0){// checks to see if health is zero or lower
            System.out.println("The " + enemy.getSoldierType() + " is dead");
            enemy.setHealth(health);
            
        }else{
            enemy.setHealth(health);// set enemy health to the new decreased health
        }// end of else
    }// end of shootEnemySoldier
    
    public void addWeapon(String weapon){
        this.weapons.add(weapon);// adds new weapon to list
    }// end of addWeapon
    
    public ArrayList<String> getWeapons(){
       return this.weapons;
    }// end of getWeapons
    
    /**
     * Overrides toString and prints out all soldier's info like health, type, and weapons by
     * calling each method and concatenating. 
     */
    public String toString(){
        String output = "The " + this.soldierType + " has a health of " + this.health + 
                " and has the following weapons: " + this.getWeapons();
        return output;
    }
}//end of Soldier
