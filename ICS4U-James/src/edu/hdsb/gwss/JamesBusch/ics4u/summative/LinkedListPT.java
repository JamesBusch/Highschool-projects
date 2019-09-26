package edu.hdsb.gwss.JamesBusch.ics4u.summative;

import edu.hdsb.gwss.JamesBusch.ics4u.u4.Node;

/**
 * Linked List of Students
 *
 * @version v2018.S2
 */
public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return returns the size (# of students) in the linked list.
     */
    public int size() {
        int i = 0;
        boolean cont = true;
        NodePT holder = new NodePT(null);
        holder = head;
        do {
            if (isEmpty()) {
                cont = false;
            } else if (holder.getNext() == null) {
                i++;
                cont = false;
            } else {
                holder = holder.getNext();
                i++;
            }
        } while (cont == true);
        return i;
    }

    /**
     * This method makes the linked list empty.
     */
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    /**
     * This method returns true if the linked list is empty
     *
     * @return returns true if there are no student objects in the linked list
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * This method adds a student object to the end of the linked list.
     *
     * @param student
     */
    public void addAtEnd(CSStudent student) {
        if (isEmpty()) {
            this.tail = new NodePT(student);
            this.head = tail;
        } else {
            NodePT holder = new NodePT(student);
            this.tail.setNext(holder);
            this.tail = holder;
        }
    }

    /**
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get(int key) {
        boolean found = false;
        CSStudent student = null;
        NodePT holder = new NodePT(this.head.getData());
        if(tail.getData().getKey() == key){
            student = tail.getData();
            found = true;
        }
         if(head.getData().getKey() == key){
            student = head.getData();
            found = true;
        }
        while (found == false) {
            if(isEmpty() || holder == null) found = true;
            else if (holder.getData().getKey() == key) {
                found = true;
                student = holder.getData();
            } else {
                if (holder.equals(tail)) {
                    found = true;       
                } else {
                    holder = holder.getNext();
                }
            }
        } 
        return student;
        
        
    }

    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not
     * found
     */
    public CSStudent remove(int key) {
        NodePT studentHolder = null;

        if (isEmpty()); else if (head.getData().getKey() == key) {
            studentHolder = head;
            head = head.getNext();
        } else if (tail.getData().getKey() == key) {
            NodePT holder = null;
            if (!isEmpty()) {
                studentHolder = tail;
                if (size() == 1) {
                    makeEmpty();
                } else {
                    do {
                        holder = holder.getNext();
                    } while (holder.getNext() != tail);
                    holder.setNext(null);
                    tail = holder;
                }
            }

        } else {
            studentHolder = head;
            do {
                studentHolder = studentHolder.getNext();
            } while (studentHolder.getNext().getData().getKey() != key && studentHolder != null);
            NodePT holderTwo = studentHolder.getNext();
            studentHolder.setNext(holderTwo.getNext());
            holderTwo.setNext(null);
        }
        return studentHolder.getData();
    }

    /**
     * DONE FOR YOU
     */
    @Override
    public String toString() {
        return "HEAD: " + toString(this.head);
    }

    /**
     * DONE FOR YOU
     */
    private String toString(NodePT n) {
        String s = "";
        if (n != null) {
            s = n.getData() + " --> " + this.toString(n.getNext());
        }
        return s;
    }

}
