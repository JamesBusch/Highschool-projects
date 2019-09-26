/*
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */

package edu.hdsb.gwss.JamesBusch.ics4u.a5;

/**
 *
 * @author jamers444
 */
public class ProperFraction extends Fraction{

    public ProperFraction() {
        super.numerator = 1;
        super.denominator = 1;
    }
    public ProperFraction(int numerator, int denominator){
        if (denominator == 0) {
            denominator = 1;
            System.out.println("Cant set denominator to 0 defualt to 1");
        } else if (this.denominator < 0) {
            numerator = this.numerator * -1;
            denominator = this.denominator * -1;
        }
        
        
        super.numerator = numerator;
        super.denominator = denominator;
        super.reduce();
    }
    
    
    
}
