/*
 * James Busch
 * ICS4U1
 * 18/05/18
 * Object for the android lock
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public class AndroidLock extends ConfigurableCombo{

    private final int COMBO_SIZE = 3;
    
    private int[] comboHolder = new int[COMBO_SIZE];
    
    /**
     * if no code is given defaults to 000
     */
    public AndroidLock(){
        setComboSize(COMBO_SIZE);
        setCombo(comboHolder);
    }
    
    /**
     * Constructor
     * Takes 3 ints and makes the combo from those varibles
     * @param x1 first digit of combo
     * @param x2 second digit of combo
     * @param x3 third digit of combo
     */
    public AndroidLock(int x1, int x2, int x3){
        comboHolder[0] = x1;
        comboHolder[1] = x2;
        comboHolder[2] = x3;
        if(inRange(comboHolder)) setCombo(comboHolder);
        else setCombo(comboHolder = new int[COMBO_SIZE]);
        
    }
    
    /**
     * Takes a array makes sure its in range and makes the combo the argument
     * @param combo combo in a array format, if out of range defaults to all 0's
     */
    public AndroidLock(int[] combo){
        if(inRange(combo)) setCombo(combo);
        else setCombo(comboHolder);
        setComboSize(COMBO_SIZE);
    }
    
}
