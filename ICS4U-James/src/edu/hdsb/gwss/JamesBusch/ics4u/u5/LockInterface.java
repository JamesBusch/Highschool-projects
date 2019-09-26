/*
 * James Busch
 * ICS4U1
 * 18/05/18
 * Interface for needed functions for the lock parent
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public interface LockInterface {
    
    
    public boolean isLocked();
    
    public void tryUnlock(int[] combo);
    
    public void lock();
    
    public int getSerialNumber();
    
    //private/protected methods
    /*
     * private void unlock();
     * private boolean lockOut();
     * protected void setMaxNum(int maxNum);
     * protected void setComboSize(int size);
     * protected void setCombo(int[] combo);
     * protected void seeCombo();
     * protected boolean inRange(int[] combo);
     */
    
}
