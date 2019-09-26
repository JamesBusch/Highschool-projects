package edu.hdsb.gwss.JamesBusch.ics4u.summative;

import edu.hdsb.gwss.JamesBusch.ics4u.u4.Student;

/**
 * Open Hash Table
 * 
 * @version v2018.S2
 */
public class OpenHashTable {

    /**
     * Open Hash Table: an array of Linked Lists
     */
    private LinkedListPT[] data;

    /**
     * Creates an Open Hash Table; default size 11
     */
    public OpenHashTable() {
        this( 11 );
    }

    /**
     * Creates an Open Hash Table
     *
     * @param intialSize the initial capacity, rounded to the next prime.
     */
    public OpenHashTable( int intialSize ) {
        data = new LinkedListPT[nextPrime( intialSize )];
        makeEmpty();
    }

    /**
     * Make that hash table empty.
     */
    public void makeEmpty() {
        data = new LinkedListPT[data.length];
    }

    /**
     * This method returns true if there are no student objects in the hash
     * table.
     *
     * @return true if the hash table contains no student objects.
     */
    public boolean isEmpty() {
        return(size() == 0);
    }

    /**
     * Gets the student object given the key (student number). This method does
     * NOT remove the object.
     *
     * @param key
     * @return student object for the given key (student number)
     */
    public CSStudent get( int key ) {
        int position = hash(key);
        int positionChecker = position;
        boolean found = false;
        CSStudent student = null;
        
        if(position < 0);
        else if(isEmpty());
        else{
            while(!found){
                if(data[position] == null){
                    if(position == capacity() - 1)position = 0;
                    else position++;
                }
                else if(data[position].get(key).getKey() == key){
                    found = true;
                    student = data[position].get(key);
                }else{
                    if(position == capacity() - 1)position = 0;
                    else position++;
                }
                if(position == positionChecker)found = true;
            }
        }
        return student;
    }

    /**
     * Puts a student in the Hash Table. Duplicates are fine, and assume student
     * objects are correct and have unique keys.
     *
     * @param student valid student object
     */
    public void put( CSStudent student ) {
        int placement = hash(student.getKey());
        if(data[placement] == null){
            LinkedListPT place = new LinkedListPT();
            place.addAtEnd(student);
            data[placement] = place;
        }else{
            data[placement].addAtEnd(student);
        }
    }

    /**
     * Determines if a student object exists with the given key (student number)
     *
     * @param key key (student number)
     * @return returns true if the student with the given key (student number) exists
     */
    public boolean containsKey( int key ) {
        int placement = hash(key);
        if(data[placement] == null)return false;
        else{
            if(data[placement].get(key) == null)return false;
            return true;
        }
    }

    /**
     * The number of student objects in the hash table.
     *
     * @return the number of student objects in the hash table.
     */
    public int size() {
        int sizeCounter = 0;
        for (int i = 0; i < capacity(); i++) {
            if(data[i] != null) sizeCounter++;
        }
        return sizeCounter;
    }

    /**
     * The capacity of the Open Hash Table; THINK! THINK! THINK! TRICK?
     *
     * @return
     */
    public int capacity() {
        return data.length;
    }

    /**
     * COMPLETE!
     *
     * @return returns a graphic of the Open Hash Table
     */
    public String toString() {
        String s = "";
        for ( int i = 0; i < data.length; i++ ) {
            if( data[i] != null )
                s = s + "\n" + "HT[" + i + "] " + data[i].toString();
            else
                s = s + "\n" + "HT[" + i + "] EMPTY";
        }
        return s;
    }

    /**
     * Hash Function; COMPLETE
     *
     * @param key key (student number)
     * @return hash value
     */
    public int hash( int key ) {
        return key % data.length;
    }

    /**
     * COMPLETE
     */
    public static int nextPrime( int n ) {
        while ( !isPrime( n ) ) {
            n++;
        };
        return n;
    }

    /**
     * COMPLETE
     */
    private static boolean isPrime( long n ) {
        // EVEN TEST
        if ( n > 2 && ( n & 1 ) == 0 ) {
            return false;
        }
        // ODD FACTORS
        for ( int i = 3; i * i <= n; i += 2 ) {
            if ( n % i == 0 ) {
                return false;
            }
        }
        return true;
    }

}
