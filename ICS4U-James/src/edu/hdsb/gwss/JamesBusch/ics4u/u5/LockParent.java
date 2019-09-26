/*
 * James Busch
 * ICS4U1
 * 18/05/18
 * The parent for all locks created 
 * includes all data for codes and unlocking
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public abstract class LockParent implements LockInterface {

    private final int MIN_NUM = 0;
    
    private static int lastSerialNumber = 0;
    protected boolean lockState = false;//true is locked false is unlocked
    protected int[] combo;//combo can be accsed by anything to make some methods eaiser
    private boolean lockedOut = false;
    private boolean comboSeen = false;
    private int attempts = 0;
    private int serialNumber;
    private int maxNum;// all min nums are 0
    //object varibles
    
    /**
     * constructor that creates the serial number
     */
    protected LockParent(){
        serialNumber = ++lastSerialNumber;
    }
    
    /**
     * Gets the max number for a lock and stores it in the class vaibles
     * @param maxNum the max Number in the lock
     */
    protected void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    /**
     * Sets the length of the combo
     * @param size the size of the combo(Length)
     */
    protected void setComboSize(int size) {
        combo = new int[size];
    }

    /**
     * for config locks it takes in the user combo makes sure it is unlocked
     * and in range then changes the code
     * @param combo sets the current combo for the lock
     */
    protected void setCombo(int[] combo) {
        if (lockState == false) {
            if (inRange(combo)) {
                this.combo = combo;
            } else {
                System.out.println("Number in combo out of range");
            }
        } else {
            System.out.println("Must unlock before setting combo");
        }
    }

    /**
     * Just returns the state of the lock weither it is locked or unlocked
     * @return the state of the lock(True is locked false is unlocked)
     */
    @Override
    public boolean isLocked() {
        System.out.println("Checking lock state");
        return lockState;
    }

    /**
     * returns the serial number of the lock
     * @return the serial number of the lock
     */
    public int getSerialNumber(){
        return serialNumber;
    }
    
    /**
     * Makes sure the lock is not locked and if its not it locks it
     */
    @Override
    public void lock() {
        System.out.println("Attempting to lock lock");
        if(lockState)System.out.println("Already locked");
        else{
            System.out.println("Locked lock");
            lockState = true;
        }
    }

    private void unlock() {
        lockState = false;
    }

    /**
     * Makes sure the combo is the correct combo and that the lock is not
     * already unlocked
     * 
     * @param combo combo trying to get into the lock
     */
    @Override
    public void tryUnlock(int[] combo) {
        System.out.println("trying unlock");
        if (lockOut()) {
            System.out.println("LOCKED OUT CAN'T ACCSESS LOCK");
        } else if (lockState == false) {
            System.out.println("Already unlocked");
        } else if (inRange(combo)) {
            if (combo.equals(this.combo)) {
                unlock();
                attempts = 0;
                System.out.println("Unlocked");
            } else {
                attempts++;
                System.out.println("inccorect code you have failed " + attempts + " times");
            }
        } else {
            System.out.println("N");
        }
    }

    /**
     * Is called to make sure the max amount of attempts has not been made
     * @return if the max amount of attempts has been made
     */
    private boolean lockOut() {
        boolean permantlyLocked = false;
        if (attempts >= 3) {
            permantlyLocked = true;
        }
        return permantlyLocked;
    }

    

    /**
     * Takes a combo and makes sure all the digits are in range
     * @param combo the input combo
     * @return if all digits in the combo are in range
     */
    protected boolean inRange(int[] combo) {
        for (int i = MIN_NUM; i < combo.length; i++) {
            int j = combo[i];
            if (j >= MIN_NUM || j <= this.maxNum); else {
                System.out.println("Number at index" + i + "out of range");
                return false;
            }
        }
        return true;
    }
}
