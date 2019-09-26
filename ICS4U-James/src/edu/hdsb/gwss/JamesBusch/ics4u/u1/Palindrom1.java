/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author jamers444
 */
public class Palindrom1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        IsPalindrome palindromeChecker = new IsPalindrome();
        
        String userInput;
        boolean x;
        
        System.out.println("Input word");
        userInput = input.nextLine();
        
        x = palindromeChecker.isPalindrome(userInput);
        
        if(x == true){
            System.out.println("its a Palindrome");
        }else{
            System.out.println("its not");
        }
        
        
    }
    
}
