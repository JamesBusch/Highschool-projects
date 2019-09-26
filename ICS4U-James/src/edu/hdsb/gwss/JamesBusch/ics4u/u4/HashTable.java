/*
 * James Busch
 * 8/5/18
 * This is the hashtable that creates a large array and places objects inside of 
 * it for a more efficent way of storing data
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class HashTable implements HashTableInterface{
    
    //class varibles
    private final int DEFUALT_SIZE = 53;
    //object varibles
    private Student[] hashTable;
    
    /**
     * defualts size of the hash table to 53
     */
    public HashTable(){
        hashTable = new Student[DEFUALT_SIZE];
    }
    
    /**
     *
     * @param size the size of the hashTable
     */
    public HashTable(int size){
        hashTable = new Student[size];
    }
    
    
    @Override
    public int size() {
        int sizeCounter = 0;
        for (int i = 0; i < capacity(); i++) {
            if(hashTable[i] != null) sizeCounter++;
        }
        return sizeCounter;
    }

    @Override
    public int capacity() {
        return hashTable.length;
    }

    @Override
    public double loadFactor() {
       return (double)size() / capacity()  * 100;
    }

    @Override
    public void makeEmpty() {
        hashTable = new Student[hashTable.length];
    }

    @Override
    public boolean isEmpty() {
       return(size() == 0);
    }

    
    private void rehash() {
        Student[] holderTable;
        holderTable = hashTable;
        int newSize = capacity() + size() * 4;
        while(!isPrime(newSize))newSize++;
        hashTable = new Student[newSize];
        for (int i = 0; i < holderTable.length; i++) {
            if(holderTable[i] == null);
            else put(holderTable[i].hashCode(), holderTable[i]);
        }
    }

    @Override
    public Student get(int key) {
        int position = hash(key);
        int positionChecker = position;
        boolean found = false;
        Student student = null;
        
        if(position < 0);
        else if(isEmpty());
        else{
            while(!found){
                if(hashTable[position] == null){
                    if(position == capacity() - 1)position = 0;
                    else position++;
                }
                else if(hashTable[position].hashCode() == key){
                    found = true;
                    student = hashTable[position];
                }else{
                    if(position == capacity() - 1)position = 0;
                    else position++;
                }
                if(position == positionChecker)found = true;
            }
        }
        return student;
    }

    @Override
    public void put(int key, Student value) {
        int position = hash(key);
        boolean placed = false;
        if(loadFactor() > 75)rehash();
        
        if(position < 0);
        else{
            while(!placed){
                if(hashTable[position] == null){
                    hashTable[position] = value;
                    placed = true;
                }
                else{
                    if(hashTable[position].equals(value))placed = true;
                    if(position == capacity())position = 0;
                    else position++;
                }
            }
        }
    }

    @Override
    public boolean contains(Student value) {
        if (this.isEmpty()) return false;
        for (int i = 0; i < capacity(); i++) {
            if(hashTable[i] == null);
            else if(hashTable[i].equals(value))return true;
        }
        return false;
    }

    @Override
    public boolean containsKey(int key) {
        for (int i = 0; i < capacity(); i++) {
            if(hashTable[i] == null);
            else if(hashTable[i].getId() == key)return true;
            
        }
        return false;
    }

    @Override
    public int hash(int key) {
        return key % capacity();
    }
    
    private boolean isPrime(int num) {
        if (num % 2 == 0) return false;
        for (int i = 3; i * i < num; i += 2)
            if (num % i == 0) return false;
        return true;
    }  
}  