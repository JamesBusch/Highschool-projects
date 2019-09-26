/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;


/**
 *
 * @author jamers444
 */
public class BookClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //empty book
        BookInfo a = new BookInfo();
        
        a.setBookAuthor("James");
        a.setBookName("Thing");
        a.setBookPages(10000);
        
        System.out.println(a);
        
        BookInfo b = new BookInfo( 1 );
        System.out.println( b );
        
        BookInfo c = new BookInfo("This is the title", "James", 1);
        System.out.println(c);
        
        BookInfo d = new BookInfo("This is a title", "James", 1);
        System.out.println(d);
        
        System.out.println(a.equals(a));
    }
    
}
