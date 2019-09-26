/*
 * James Busch
 * ICS4U1
 * 21/05/18
 * tester for all 4 locks
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public class LockClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] comboHolder = new int[3];
        int[] wrongCombo = new int[3];
        
        
        DubdlyLock dl = new DubdlyLock();
        comboHolder = dl.seeCombo();
        dl.seeCombo();
        
        assert dl.isLocked() == false;
        
        for (int i = 0; i < comboHolder.length; i++) {
            System.out.println(comboHolder[i]);
        }
        for (int i = 0; i < wrongCombo.length; i++) {//makes sure there are no matching digits
            if(comboHolder[i] != 1) wrongCombo[i] = 1;
            else wrongCombo[i] = 2;
        }
        
        dl.lock();//should lock
        dl.lock();//should say already locked
        assert dl.isLocked() == true;
        dl.tryUnlock(wrongCombo);
        assert dl.isLocked() == true;
        dl.tryUnlock(comboHolder);
        assert dl.isLocked() == false;
        dl.tryUnlock(wrongCombo);//should say already unlocked
        dl.lock();
        assert dl.getSerialNumber() == 1;
        dl.tryUnlock(wrongCombo);
        dl.tryUnlock(wrongCombo);
        dl.tryUnlock(wrongCombo);
        dl.tryUnlock(comboHolder);
        
        MasterLock ml = new MasterLock();
        assert ml.isLocked() == false;
        comboHolder = ml.seeCombo();
        ml.seeCombo();
        for (int i = 0; i < comboHolder.length; i++) {
            System.out.println(comboHolder[i]);
        }
        for (int i = 0; i < wrongCombo.length; i++) {//makes sure there are no matching digits
            if(comboHolder[i] != 1) wrongCombo[i] = 1;
            else wrongCombo[i] = 2;
        }
        ml.lock();
        ml.lock();
        assert ml.isLocked() == true;
        ml.tryUnlock(wrongCombo);
        assert ml.isLocked() == true;
        ml.tryUnlock(comboHolder);
        assert ml.isLocked() == false;
        ml.tryUnlock(wrongCombo);
        assert ml.isLocked() == false;
        assert ml.getSerialNumber() == 2;
        ml.lock();
        ml.tryUnlock(wrongCombo);
        ml.tryUnlock(wrongCombo);
        ml.tryUnlock(wrongCombo);
        ml.tryUnlock(comboHolder);
        
        MasterULock mul = new MasterULock();
        
        comboHolder = mul.seeCombo();
        wrongCombo = new int[4];
        for (int i = 0; i < wrongCombo.length; i++) {//makes sure there are no matching digits
            if(comboHolder[i] != 1) wrongCombo[i] = 1;
            else wrongCombo[i] = 2;
        }
        assert mul.isLocked() == false;
        assert mul.getSerialNumber() == 3;
        mul.lock();
        assert mul.isLocked() == true;
        mul.tryUnlock(comboHolder);
        assert mul.isLocked() == false;
        mul.lock();
        mul.tryUnlock(wrongCombo);
        mul.tryUnlock(wrongCombo);
        mul.tryUnlock(wrongCombo);
        mul.tryUnlock(comboHolder);
        
        AndroidLock al = new AndroidLock();
        comboHolder = al.seeCombo();
        wrongCombo = new int[3];
        for (int i = 0; i < wrongCombo.length; i++) {
            if(comboHolder[i] != 1) wrongCombo[i] = 1;
            else wrongCombo[i] = 2;
        }
        assert al.isLocked() == false;
        assert al.getSerialNumber() == 4;
        al.lock();
        assert al.isLocked() == true;
        al.tryUnlock(comboHolder);
        assert al.isLocked() == false;
        al.lock();
        al.tryUnlock(wrongCombo);
        al.tryUnlock(wrongCombo);
        al.tryUnlock(wrongCombo);
        al.tryUnlock(comboHolder);
    }
    
}
