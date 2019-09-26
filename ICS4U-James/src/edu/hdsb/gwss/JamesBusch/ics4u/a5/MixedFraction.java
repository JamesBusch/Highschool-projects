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
public class MixedFraction extends Fraction{
    private int wholeNum;
    private int numerator;
    private int denominator;
    
    
    public MixedFraction() {
        this.wholeNum = 1;
        this.numerator = 1;
        this.denominator = 1;
        
        
        super.numerator = 1;
        super.denominator = 1;
        
    }

    public MixedFraction(int wholeNum, int numerator, int denominator){
        if (denominator == 0) {
            denominator = 1;
            System.out.println("Cant set denominator to 0 defualt to 1");
        } else if (this.denominator < 0) {
            numerator = this.numerator * -1;
            denominator = this.denominator * -1;
        }
        
        this.wholeNum = wholeNum;
        this.numerator = numerator;
        this.denominator = denominator;
        
        super.numerator = numerator + (wholeNum * denominator);
        super.denominator = denominator; 
        super.reduce();
       
    }
    
    @Override
    public String toString(){
        
        return wholeNum + "x" + super.numerator + "/" + super.denominator;
    }
    
    public improperFraction toImproper(){
        return new improperFraction(super.numerator, super.denominator);
    }
    
}
