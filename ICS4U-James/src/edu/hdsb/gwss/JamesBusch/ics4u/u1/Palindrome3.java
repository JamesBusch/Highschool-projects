/*
 * James Busch
 * 2/12/18
 * Takes a full sentence and checks if it is a palindrome
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u1;

import java.util.Scanner;
//imports
/**
 *
 * @author jamers444
 */
public class Palindrome3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IsPalindrome checkPlaindrome = new IsPalindrome();
        //object initlization
        
        String userInput, finalString;
        boolean palindrome;
        //varible decloration
        
        System.out.println("Input a string and this can tell if it is a plaindrome");
        userInput = input.nextLine();
        //user input
        
        finalString = userInput.toLowerCase().trim().replaceAll("\\s+","").replaceAll(",","");
        palindrome = checkPlaindrome.isPalindrome(finalString);
        //string processing
        
        if(palindrome == true){//final output
            System.out.println(userInput + " is a plaindrome");
        }else{
            System.out.println(userInput + " is not a palindrome");
        }
        
        
    }
    
}
