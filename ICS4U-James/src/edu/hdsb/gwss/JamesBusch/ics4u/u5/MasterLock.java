/*
 * James Busch
 * ICS4U1
 * 18/05/18
 * The master lock object for the user to call
 * when called the lock makes a random combo
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public class MasterLock extends FixedLock{
    private static int MAX_NUM = 39;
    private static int COMBO_LENGTH = 3;
    private static int[] holderCombo;
    
    /**
     * Constructor for the master lock
     * Creates the new lock with a random combo
     */
    public MasterLock(){
        holderCombo = new int[COMBO_LENGTH];
        setComboSize(COMBO_LENGTH);
        setMaxNum(MAX_NUM);
        for(int i = 0; i < holderCombo.length; i++){
            holderCombo[i] = (int)(Math.random() * (MAX_NUM + 1));
        }
        setCombo(holderCombo);
    }
}
