/*
 *James Busch
 *2/9/18
 *and open the template in the editor.
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u1;

/**
 *
 * @author jamers444
 */
public class IsPalindrome {
    
    boolean isPalindrome(String s){
        s = s.toLowerCase();
        boolean mirror = true; 
        for (int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) == s.charAt(s.length() - 1 - i)){
            }else{
            mirror = false;
            } 
        }   
        return mirror;   
    }
    
}
