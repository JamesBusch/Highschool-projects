/*
 * James Busch
 * 2/8/18
 * EasterComes.java
 * This program takes any given year and finds when easter will be
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u1;

import java.util.Scanner;
//imports
/**
 *
 * @author jamers444
 */
public class EasterComes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //object inilization
        int year;
        //user varible
        int month;
        int day;
        //final outputs
        int a,b,c,d,e,f,g,h,i,j,k,m,p;
        //eq varibles
       
        
        System.out.println("This program takes any given year and figures out when easter will be");
        //user intro
        System.out.println("What year would you like to find out about");
        year = input.nextInt();
        //user input
        
        a = year % 19;
        b = year / 100;
        c = year % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = (b - f + 1) / 3;
        h = (19 * a + b - d - g + 15) % 30;
        i = c / 4;
        k = c % 4;
        j = (32 + 2 * e + 2 * i - h - k) % 7;
        m = (a + (11 * h) + (22 * j)) / 451;
        month = (h + j - 7 * m + 114) / 31;
        p = (h + j - 7 * m + 114) % 31;
        day = p + 1;
        //formula
        
        System.out.println("Easter will be on " + day + "/" + month + "/" + year);
        //final output
    }
    
}
