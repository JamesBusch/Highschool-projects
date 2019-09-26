/*
 * James Busch
 * ICS4U1
 * 21/05/18
 * 4 digit configurableCombo lock
 * takes in digits in either array or single int formats
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public class MasterULock extends ConfigurableCombo{
    private final int COMBO_SIZE = 4;
    
    private int[] comboHolder = new int[COMBO_SIZE];
   
    /**
     * constructor sets default combo to 0000
     */
    public MasterULock(){
        setComboSize(COMBO_SIZE);
        setCombo(comboHolder);
    }
    
    /**
     *
     * @param x1 digit one of combo
     * @param x2 digit two of combo
     * @param x3 digit three of combo
     * @param x4 digit four of combo
     */
    public MasterULock(int x1, int x2, int x3, int x4){
        setComboSize(COMBO_SIZE);
        comboHolder[0] = x1;
        comboHolder[1] = x2;
        comboHolder[2] = x3;
        comboHolder[3] = x4;
        if(inRange(comboHolder)) setCombo(comboHolder);
        else setCombo(comboHolder = new int[COMBO_SIZE]);
    }
    
    /**
     *
     * @param combo array for combo
     */
    public MasterULock(int[] combo){
        setComboSize(COMBO_SIZE);
        if(inRange(combo)) setCombo(combo);
        else setCombo(comboHolder);
    } 
    
    
}