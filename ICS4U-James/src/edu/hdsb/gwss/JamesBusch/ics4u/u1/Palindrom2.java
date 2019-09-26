/*
 * James Busch
 * 2/12/18
 * This takes a string and checks how many words are palindrom
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u1;

import java.util.Scanner;
import java.util.StringTokenizer;
//imports
/**
 *
 * @author jamers444
 */
public class Palindrom2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IsPalindrome palindromeChecker = new IsPalindrome();
        //object initlization
        
        int numOfPalindroms = 0;
        String userInput;
        //varible decloration
        
        System.out.println("Input a sentence and this will tell you how many words are palindrom");
        userInput = input.nextLine();
        //user input
        
        StringTokenizer st = new StringTokenizer(userInput);
        //Tokenizer taking string
        
        while(st.hasMoreTokens()){//checks every token then checks it if it is a palindrom
            if(palindromeChecker.isPalindrome(st.nextToken())){
                numOfPalindroms++;
            }
        }
        System.out.println("This sentence has " + numOfPalindroms + " Palindroms");
        

        
    }
    
}
