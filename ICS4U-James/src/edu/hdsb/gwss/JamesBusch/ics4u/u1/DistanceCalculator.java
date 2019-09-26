/*
 * James Busch
 * 2/8/18
 * this program takes two locations lons and lats and finds the distance 
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author jamers444
 */
public class DistanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double lat1, lat2, lon1, lon2;
        //user varibles
        double distance;
        //final varible
        System.out.println("Put in the lon and lat for each location");
        //user intro
        System.out.println("Lat 1:");
        lat1 = Math.toRadians(input.nextDouble());
        System.out.println("Lon 1:");
        lon1 = Math.toRadians(input.nextDouble());
        System.out.println("lat 2:");
        lat2 = Math.toRadians(input.nextDouble());
        System.out.println("lon 2:");
        lon2 = Math.toRadians(input.nextDouble());
        //user input
        
        distance = 6378.8 * Math.acos(Math.sin(lat1) * Math.sin(lat2) + 
                Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1));
        //formula to find distance
        System.out.println("The distance is " + distance + "km as the crow flies");
        //final output
    }
    
}
