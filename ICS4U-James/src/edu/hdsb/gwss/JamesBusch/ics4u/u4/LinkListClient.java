/*
 * Link list data type tester
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class LinkListClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkList test = new LinkList();
        assert test.isEmpty() == true;
        assert test.size() == 0;
        assert test.head() == null;
        assert test.tail() == null;
        test.removeHead();
        test.removeTail();
        
        test.addAtFront("A");
        
        assert test.head().equals("A");
        assert test.tail().equals("A");
        assert test.isEmpty() == false;
        assert test.size() == 1;
        test.makeEmpty();
        assert test.isEmpty() == true;
        
        test.addAtFront("A");
        test.addAtEnd("B");
        test.addAtEnd("C");
        
        assert test.size() == 3;
        assert test.isEmpty() == false;
        assert test.head().equals("A");
        assert test.tail().equals("C");
        
        test.remove("A");
        assert test.head().equals("B");
        assert test.tail().equals("C");
        assert test.size() == 2;
        assert test.isEmpty() == false;
        
        test.remove("B");
        assert test.head().equals("C");
        assert test.tail().equals("C");
        assert test.size() == 1;
        test.makeEmpty();
        
        for (int i = 0; i < 20; i++) {
            test.addAtEnd(i + "");
        }
        System.out.println(test.toString());
        
        assert test.isEmpty() == false;
        assert test.size() == 20;
        assert test.head().equals("0");
        assert test.tail().equals("19");
        test.remove("4");
        assert test.size() == 19;
        assert test.head().equals("0");
        assert test.tail().equals("19");
        test.remove("0");
        assert test.size() == 18;
        assert test.head().equals("1");
        assert test.tail().equals("19");
        test.remove("19");
        assert test.size() == 17;
        assert test.head().equals("1");
        assert test.tail().equals("18");
        test.removeHead();
        test.removeTail();
        assert test.size() == 15;
        assert test.head().equals("2");
        assert test.tail().equals("17");
        test.makeEmpty();
        assert test.isEmpty() == true;
        
        
        
    }
    
}
