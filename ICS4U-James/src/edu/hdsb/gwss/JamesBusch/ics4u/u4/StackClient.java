/*
 * James Busch
 * 20/4/18
 * Stack client tester
 * checks errors in object functions
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class StackClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack stackTestOne = new Stack(10);
        assert stackTestOne.isEmpty() == true;
        assert stackTestOne.top() == -1;
        assert stackTestOne.isFull() == false;
        for (int i = 0; i < stackTestOne.capacity(); i++) {
            stackTestOne.push(i);
            System.out.print(stackTestOne.top());
            System.out.print(" ");
            assert stackTestOne.isEmpty() == false;
            assert stackTestOne.size() == i + 1;
        }
        System.out.println("-After stack fill data-");
        System.out.println("-is full test-");
        assert stackTestOne.isFull() == true;
        System.out.println("-capacity test-");
        assert stackTestOne.capacity() == 10;
        System.out.println("-top num test-");
        assert stackTestOne.top() == 9;
        System.out.println("-size test-");
        assert stackTestOne.size() == 10;
        System.out.println("-empty test-");
        assert stackTestOne.isEmpty() == false;
        
        for (int i = stackTestOne.capacity(); i > 0; i--) {
            assert stackTestOne.pop() == i - 1;
            System.out.print(i);
            System.out.print(" ");
        }
        assert stackTestOne.isEmpty() == true;  
        System.out.println("-should return error-");
        stackTestOne.pop();//this seems to show up at the secound line instead of the last one
        }
    }
    
