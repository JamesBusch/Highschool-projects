/*
 *James Busch
 *19/2/18
 *This finds any prime numbers in a set of numbers (0 -> x)
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u2;

/**
 *
 * @author jamers444
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean numbers[] = new boolean[1001];
        //true means none prime
        numbers[0] = true;
        numbers[1] = true;
        for(int i = 3; i < numbers.length; i = i + 2) {
            for( int j = 2*i; j < numbers.length; j = j + i){
            numbers[j] = true;
            }
        }
        for (int i = 2; i < numbers.length; i++) {
            if(numbers[i - 1] == false){
                System.out.print(i);
            }           
        } 
    }  
}
