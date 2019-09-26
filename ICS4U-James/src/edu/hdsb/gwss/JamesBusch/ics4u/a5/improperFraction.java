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
public class improperFraction extends Fraction{

    public improperFraction(){
        super.numerator = 1;
        super.denominator = 1;
    }
    
    public improperFraction(int numerator, int denominator){
        super.numerator = numerator;
        super.denominator = denominator;
        super.reduce();
    }
 
    public MixedFraction toMixed(){
        int wholeNum = gcd(super.numerator, super.denominator);
        super.numerator = super.numerator - (wholeNum * super.denominator);
        MixedFraction f = new MixedFraction(wholeNum, super.numerator, super.denominator);
        return f;
    }
    
    
}
