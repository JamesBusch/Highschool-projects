/*
 * James Busch
 * ICS4U1
 * 18/05/18
 * Parent for fixed locks only used to see combo 
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public abstract class FixedLock extends LockParent{
    
    private boolean comboSeen = false;
    
    /**
     * shows the combo but only once
     * @return the combo of the lock in a array format
     */
    public int[] seeCombo(){
        if(!comboSeen){
            System.out.println("Showing combo(You can no longer see the combo for this lock!)");
            comboSeen = true;
            return combo;
        }else{
            System.out.println("Already seen combo can not show combo again");
            return null;
        }
    }
}
