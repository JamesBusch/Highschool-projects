/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.a5;

/**
 *
 * @author jamers444
 */
public class FractionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraction j = new Fraction(1, 2);
        Fraction i = new Fraction(2, 4);
        Fraction k = new Fraction(1, 4);
        Fraction l = new Fraction(2, 1);
        System.out.println(j.toString());
        System.out.println(i.toString());
        assert j.size() == 0.5;
        assert i.size() == 0.5;
        assert j.equals(i);
        assert k.equals(Fraction.times(j, i));
        assert l.equals(Fraction.larger(l, i));
        assert j.times(i).equals(k);
        j.invert();
        System.out.println(j.toString());
        assert l.equals( j );
        ProperFraction hello = new ProperFraction(2, 4);
        assert hello.equals(i);
        assert i.equals(hello);
        MixedFraction fam = new MixedFraction(4, 2, 3);
        System.out.println(fam.toString());
    }
}
