/*
 * James Busch
 * ICS4U1
 * 18/05/18
 * The DubdlyLock object to be called by a user
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public class DubdlyLock extends FixedLock{
    private static int MAX_NUM = 59;
    private static int COMBO_LENGTH = 3;
    private static int[] holderCombo;
    
    /**
     * Constructor for the Dubdly Lock creates a random code when called
     */
    public DubdlyLock(){
        holderCombo = new int[COMBO_LENGTH];
        setComboSize(COMBO_LENGTH);
        setMaxNum(MAX_NUM);
         for(int i = 0; i < holderCombo.length; i++){
            holderCombo[i] = (int)(Math.random() * (MAX_NUM + 1));
        }
         setCombo(holderCombo);
    }
}
