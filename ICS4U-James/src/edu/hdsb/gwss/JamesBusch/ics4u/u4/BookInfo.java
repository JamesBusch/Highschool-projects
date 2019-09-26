/*
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u4;

import java.util.Objects;

/**
 *
 * @author jamers444
 */
public class BookInfo {
    //class constants
    final static String[] GENRE = {"unkown", "Fiction", "Non-Fiction"};
    final static String PUBLISHER = "Cool People";
    
    //class varible
    private static int lastID = 0;

    //object varible
    private String bookName;
    private String bookAuthor;
    private int bookPages;
    private int edition;
    private int genreID;
    
    private long id;
    
    
    //constructor info
    //1. empty
    public BookInfo() {
      
    }
    //2. (id) 123
    public BookInfo(long id) {
        this.id = id;
    }
    //3. secoundary key

    public BookInfo(String bookName, String bookAuthor, int edition) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.edition = edition;
        //this.id = ++lastID;
    }

    @Override
    public String toString() {
        return "BookInfo{" + "bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", edition=" + edition + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookInfo other = (BookInfo) obj;
        if (this.edition != other.edition) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        if (!Objects.equals(this.bookAuthor, other.bookAuthor)) {
            return false;
        }
        return true;
    }
    
    
    

    public long getId() {
        return id;
    }

    public int getBookPages() {
        return this.bookPages;
    }

    public void setBookPages(int bookPages) throws Exception{
        if(bookPages < 1){
            throw new Exception("Invalid page count");
        }
        this.bookPages = bookPages;
    }
        
    public String getBookAuthor() throws Exception{ 
        return this.bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) throws Exception{
        if(bookAuthor.equals(null) || bookAuthor.length() < 1){
            throw new Exception("Bad Title");
        }
        this.bookAuthor = bookAuthor;
    }
      
    public String getBookName() {
        return this.bookAuthor;
    }

    public void setBookName(String bookName) throws Exception {
        if(bookName.equals(null) || bookName.length() < 1){
            throw new Exception("Bad Title");
        }
        this.bookName = bookName;
    }

    public String getGenreID() {
        return GENRE[genreID];
    }

    public void setGenreID(int genreID) {
        if(genreID < 1 || genreID > GENRE.length - 1){
            //unknown genre
            this.genreID = 0;
        }else{
            this.genreID = genreID;
        }
    } 
    
}
