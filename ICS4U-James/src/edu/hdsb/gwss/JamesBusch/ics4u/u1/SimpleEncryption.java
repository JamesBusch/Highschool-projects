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
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String userInput;
        String finalOutput = "";
        int rotationAmount;
        
        
        System.out.println("Input a sentence to encrypt");
        userInput = input.nextLine().toUpperCase();
        
        System.out.println("Input a rotation amount");
        rotationAmount = input.nextInt();
        
        for (int i = 0; i < userInput.length(); i++) {
            if(userInput.charAt(i) == ' '){
                finalOutput = finalOutput + " ";
            }else{
                //if()
            }
        }
        
    }
    
}
