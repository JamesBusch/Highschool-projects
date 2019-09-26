/*
 * James Busch
 * 20/4/18
 * Queue data type
 * This data type holds ints in a queue that is FIFO
 * The size is staticly defined at the start by the user and can not grow
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class Queue implements QueueInterface {
    //class varibiles
    private static int DEFULT_SIZE = 5;
    
    //object varibles
    private int[] queueArray;
    private int frontPointer = 0;
    private int backPointer = -1;

    /**
     *
     */
    public Queue() {
        queueArray = new int[DEFULT_SIZE];
    }

    /**
     * This creates the stack using a array
     * Once the queue is made it can't change size
     * 
     * @param capacity the size of the queue
     */
    public Queue(int capacity) {
        queueArray = new int[capacity];
    }
    /**
     * This object method lets you look at the front of the queue without
     * changing it
     *
     * @return Integer value at the front of the the queue, else if queue is
     * empty return null
     */
    @Override
    public Integer front() {
        Integer r = null;
        if (!isEmpty()) {
            r = queueArray[frontPointer];
        }
        return r;
    }

    /**
     * Gets the int from the back of the queue returning null if it is empty
     *
     * @return The int at the back for the queue if empty returns null
     */
    @Override
    public Integer back() {
        Integer r = null;
        if (!isEmpty()) {
            r = queueArray[backPointer];
        }
        return r;
    }

    /**
     * takes a value and adds it to the back of the queue if it is not empty
     * 
     * @param value that is added to the back of the queue
     */
    @Override
    public void enqueue(Integer value) {//adds another num to the front pointer
        if (isFull()) {
            System.err.println("can not enqueue a full queue");
        } else {
            if (backPointer == queueArray.length - 1) {
                backPointer = 0;
                queueArray[backPointer] = value;
            } else {
                backPointer++;
                queueArray[backPointer] = value;
            }
        }
    }

    /**
     * This method takes the number from the front of the queue and returns it
     * and pushes up the queue
     * 
     * @return integer value at the back of the queue, else if queue is empty
     * return null
     */
    @Override
    public Integer dequeue() {//pushes out front number
        Integer r = null;
        if (!isEmpty()) {
            r = queueArray[frontPointer];
            if (frontPointer != queueArray.length - 1) {
                frontPointer++;
            } else if (frontPointer == backPointer) {
                makeEmpty();
            } else {
                frontPointer = 0;
            }
        } else {
            System.err.println("Can't dequeue a empty queue");
        }
        return r;
    }

    /**
     * Gets the amount of data in the queue
     * 
     * @return a int of the size the stored data takes up
     */
    @Override
    public int size() {
        int r;
        if (isEmpty()) {
            r = 0;
        } else if (isFull()) {
            r = capacity();
        } else if (backPointer >= frontPointer) {
            r = ((backPointer - frontPointer) + 1);
        } else {
            r = (queueArray.length - frontPointer) + backPointer + 1;
        }

        return r;
    }

    /**
     * Lets the user see how big the queue is
     * 
     * @return the size of the array
     */
    @Override
    public int capacity() {
        return queueArray.length;
    }

    /**
     * Lets the user get a true false if the queue is empty or not
     * 
     * @return returns a boolean if queue is empty
     */
    @Override
    public boolean isEmpty() {
        return (backPointer == -1);
    }

    /**
     * Lets the user get a true false if the queue is full or not
     * 
     * @return Returns a boolean if the queue is full
     */
    @Override
    public boolean isFull() {
        boolean r = false;
        if (backPointer == frontPointer - 1 && backPointer != -1) {
            r = true;
        } else if (frontPointer == 0 && backPointer == capacity() - 1) {
            r = true;
        }
        return r;
    }

    /**
     * Sets queue to empty to be used again
     */
    @Override
    public void makeEmpty() {
        frontPointer = 0;
        backPointer = -1;
    }

}
