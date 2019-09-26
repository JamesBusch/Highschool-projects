/*
 * James Busch
 * 12/04/18
 * Stack data type
 * This data type holds ints >= 0 in a LIFO stack
 * The capacity is defined at the start by the user and can not grow
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class Stack implements StackInterface{
    
    //object varible
    private int[] stackArray;
    private int pointer = -1;
    
    /**
     * Default constructor sets capacity to 5
     */
    public Stack(){
        stackArray = new int[5];
        System.err.println("");
    }
    
    /**
     *
     * @param size The size of the stack to be created
     */
    public Stack(int size){
        stackArray = new int[size];
    }
    
    /**
     * gets the number from the top of the stack without getting rid of the number
     * 
     * @return the number on the top of the stack
     */
    @Override
    public int top() {
        int r = -1;
        if(!isEmpty())r = stackArray[pointer];
        return r;
    }

    /**
     * gets the number from the top of the stack and removes that number from
     * the top
     * 
     * @return the number at the top of the stack
     */
    @Override
    public int pop() {
        int returnNum = -1;
        if(!isEmpty()){ 
            returnNum = stackArray[pointer];
            pointer--;
            }
        else System.err.println("Can't pop stack with no data in it");
        return returnNum;
    }

    /**
     * Pushes int on to the top of the stack if its > -1 and not empty
     * 
     * @param value the value to be added to the top of the stack if full error is returned
     */
    @Override
    public void push(int value) {
        if(value < 0){
            System.out.println("Can not take value less than 0");
        }else if(!isFull()){
            pointer++;
            stackArray[pointer] = value;
        }else{
            System.err.println("Index outofbounds can't push anymore data");
        }
    }

    /**
     * Returns the size of the data in the stack
     * 
     * @return the size of the stack
     */
    @Override
    public int size() {
        return pointer + 1;
    }

    /**
     * Returns the total size of the stack
     * 
     * @return the amount of room in the array
     */
    @Override
    public int capacity() {
        return stackArray.length;
    }

    /**
     * returns a true false saying if the stack is empty
     * 
     * @return boolean saying if the stack is empty or not
     */
    @Override
    public boolean isEmpty() {
        return (pointer == -1);
    }

    /**
     * returns a true false saying if the stack is full
     * 
     * @return boolean saying if the stack is full or not
     */
    @Override
    public boolean isFull() {
        return (pointer + 1 == capacity());
      
    }

    /**
     * makes the stack empty to be reused from the start
     */
    @Override
    public void makeEmpty() {
        pointer = -1;
    }
}
