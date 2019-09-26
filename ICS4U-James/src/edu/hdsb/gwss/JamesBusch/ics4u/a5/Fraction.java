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
public class Fraction {

    protected int numerator;
    protected int denominator;

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (this.denominator == 0) {
            this.denominator = 1;
            System.out.println("Cant set denominator to 0 defualt to 1");
        } else if (this.denominator < 0) {
            this.numerator = this.numerator * -1;
            this.denominator = this.denominator * -1;
        }
        this.reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double size() {
        return (double) numerator / denominator;
    }

    public Fraction larger(Fraction f) {
        Fraction j;
        if (this.size() >= f.size()) {
            j = this;
        } else {
            j = f;
        }
        return j;
    }

    public static Fraction larger(Fraction f, Fraction g) {
        Fraction j;
        if (f.size() >= g.size()) {
            j = f;
        } else {
            j = g;
        }
        return j;
    }

    public boolean equals(Fraction f) {
        boolean areEqual = false;
        if (this.size() == f.size()) {
            areEqual = true;
        }
        return areEqual;
    }

    public void invert() {
        int holder;
        if (numerator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
        holder = denominator;
        denominator = numerator;
        numerator = holder;
        this.reduce();
    }

    public void reduce() {
        int dividor = gcd(numerator, denominator);
        numerator = numerator / dividor;
        denominator = denominator / dividor;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    protected int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public Fraction times(Fraction f) {
        int newNumerator, newDenominator;
        Fraction j;
        newNumerator = this.numerator * f.numerator;
        newDenominator = this.denominator * f.denominator;

        j = new Fraction(newNumerator, newDenominator);
        return j;
    }

    public static Fraction times(Fraction f, Fraction g) {
        int newNumerator, newDenominator;
        Fraction j;
        newNumerator = f.numerator * g.numerator;
        newDenominator = f.denominator * g.denominator;

        j = new Fraction(newNumerator, newDenominator);
        return j;
    }
}
