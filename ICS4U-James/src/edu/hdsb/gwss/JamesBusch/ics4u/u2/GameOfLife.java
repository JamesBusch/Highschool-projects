/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u2;

import java.util.Scanner;

/**
 *
 * @author jamers444
 */
public class GameOfLife {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[][] gameBoardOne;
        char[][] gameBoardTwo;
        
        gameBoardOne = createBoard();
        gameBoardTwo = gameBoardOne;
        
    }
  
    public static char[][] createBoard(){
        Scanner input = new Scanner(System.in);
        int rowSize;
        int columnSize;
        char[][] gameBoard;
        System.out.println("input row size");
        rowSize = Integer.parseInt(input.nextLine());
        System.out.println("input column size");
        columnSize = Integer.parseInt(input.nextLine());
        gameBoard = new char[rowSize][columnSize];
        return gameBoard;
    }
    
    public static int countNeighbors(){
    
        
        
    return -1;
    }
    
    
    
}
