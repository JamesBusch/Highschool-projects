/*
 * James Busch
 * 8/5/18
 * This is the tester for hashtable
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class HashTableClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable hashTableTest = new HashTable();
        Student testStudent = new Student();
        
        assert hashTableTest.size() == 0;
        assert hashTableTest.capacity() == 53;
        assert hashTableTest.contains(testStudent) == false;
        hashTableTest.get(123);
        assert hashTableTest.containsKey(123) == false;
        assert hashTableTest.loadFactor() == 0;
        
        for (int i = 0; i < 39; i++) {
            Student s = new Student(i,i,i + "",i + "");
            hashTableTest.put(s.hashCode(), s);
            assert hashTableTest.size() == i + 1;
            assert hashTableTest.capacity() == 53;
            assert hashTableTest.get(s.hashCode()).equals(s);
            assert hashTableTest.contains(s) == true;
            assert hashTableTest.containsKey(s.getId()) == true;
            assert hashTableTest.loadFactor() == (double)(i + 1) / 53 * 100;
            
        }
     
        Student s = new Student(123,123, "James", "Busch");
        hashTableTest.put(s.hashCode(), s);
    }
    
}
