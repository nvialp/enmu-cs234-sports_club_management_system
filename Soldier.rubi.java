
/******************************************************************************
Rubi Guttierrez-Madrid
*******************************************************************************/
//imports ArrayList util
import java.util.ArrayList;

public class Soldier{
    //instance variables
    private int health;
    private String soldierType;
    private ArrayList<String> weapons; 
    
    //constructor
    public Soldier(){
        this.health = 10;
        this.soldierType = new String();
        this.weapons = new ArrayList<>();
    }
    
    //custom constructor
    public Soldier(int health, String soldierType){
        this.health = health;
        this.soldierType = soldierType;
        this.weapons = new ArrayList<>();
    }
    
    //method to get soldier's health
    public int getHealth(){
        return health;
    }
    
    //method to get soldier's type
    public String getSoldierType(){
        return soldierType;
    }
    
    //sets soldierType to entered newSoldierType
    public void setSoldierType(String newSoldierType){
        soldierType = newSoldierType;
    }
    
    //sets health entered 
    public void setHealth (int newHealth){
        health= newHealth;
    }
    
    //method to shoot enemy soldier
    public void shootEnemy(Soldier enemy){
        //creates integer that equals the enemy's health
        int gotShot = enemy.getHealth();
        //subtracts 1 from soldier's health
        gotShot--;
        //prints out what soldier shot at what enemy
        System.out.println("The " + this.getSoldierType() + " shoots at the " + enemy.getSoldierType());
        //if the health of the enemy shot is 0
        if (gotShot <= 0){
            //prints out enemy is dead
            System.out.println(enemy.getSoldierType() + " is dead.");
        }
        else {
            //sets enemy's health after being shot
            enemy.setHealth(gotShot);
        }
    }
    
    //method to add weapon to weapons list
    public void addWeapon(String Weapon){
        weapons.add(Weapon);
    }
    
    //method to retrieve weapons list
    public ArrayList<String> getWeapons(){
        return weapons;
    }
    
    //overwritten toString to print out soldier's information
    public String toString(){
        return "The " + soldierType + " has a health of " + health + " and has the following weapons: " + weapons;
    }
}