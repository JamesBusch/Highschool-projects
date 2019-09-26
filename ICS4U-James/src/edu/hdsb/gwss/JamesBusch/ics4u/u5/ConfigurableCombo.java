/*
 * James Busch
 * ICS4U1
 * 18/05/18
 * The configurbale combo parent used to see combo and configure combo
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public abstract class ConfigurableCombo extends LockParent{
        
    /**
     * constructor sets max num to 9
     */
    protected ConfigurableCombo(){
        setMaxNum(9);
    }
    
    /**
     * Takes in a new combo and makes sure that it is in range and unlocked
     * @param combo takes in the new combo and only sets it if its in range
     */
    public void reConfigureCode(int[] combo){
        System.out.println("Setting combo");
        if(inRange(combo) && !isLocked())setCombo(combo); 
    }
    
    /**
     * user can see the combo as many times as they want as long as its unlocked
     * @return the combo if unlocked
     */
    public int[] seeCombo(){
        if(!lockState){
            return combo;
        }else{
            System.out.println("Must unlock before seeing");
            return null;
        }
    }
}
