/*
 * Mountain Paths - Greedy Algorithm
 * ICS4U1
 * James Busch
 * 2018.04.07 - v1.0
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u3;

import java.util.*;
import java.io.*;
import java.awt.*;
//imports

public class MountainPaths {

    /**
     * Mount Paths
     */
    public static void main( String[] args ) throws Exception {

        // ***********************************
        // TASK 1:  read data into a 2D Array
        // 
        System.out.println( "TASK 1: READ DATA" );
        int[][] data = read( "Colorado.844x480.dat" );
        // ***********************************
        // Construct DrawingPanel, and get its Graphics context
        //
        DrawingPanel panel = new DrawingPanel( data[0].length, data.length );
        Graphics g = panel.getGraphics();

        // ***********************************
        // TASK 2:  find HIGHEST & LOWEST elevation; for GRAY SCALE
        //
        System.out.println( "TASK 2: HIGHEST / LOWEST ELEVATION" );
        int min = findMinValue( data );
        System.out.println( "\tMin: " + min );

        int max = findMaxValue( data );
        System.out.println( "\tMax: " + max );

        // ***********************************
        // TASK 3:  Draw The Map
        //
        System.out.println( "TASK 3: DRAW MAP" );
        drawMap( g, data );

        // ***********************************
        // TASK 4A:  implement indexOfMinInCol
        //
        System.out.println( "TASK 4A: INDEX OF MIN IN COL 0" );
        int minRow = indexOfMinInCol( data, 0 );
        System.out.println( "\tRow with lowest Col 0 Value: " + minRow );

        // ***********************************
        // TASK 4B:  use minRow as starting point to draw path
        //
        System.out.println( "TASK 4B: PATH from LOWEST STARTING ELEVATION" );
        g.setColor( Color.RED );
        int totalChange = drawLowestElevPath( g, data, 11, 0 ); //
        System.out.println( "\tLowest-Elevation-Change Path starting at row " + minRow + " gives total change of: " + totalChange );

        // ***********************************
        // TASK 5:  determine the BEST path
        //
        g.setColor( Color.RED );
        int bestRow = indexOfLowestElevPath( g, data );

        // ***********************************
        // TASK 6:  draw the best path
        //
        System.out.println( "TASK 6: DRAW BEST PATH" );
        //drawMap.drawMap(g); //use this to get rid of all red lines
        g.setColor( Color.GREEN ); //set brush to green for drawing best path
        totalChange = drawLowestElevPath( g, data, bestRow, 0 );
        System.out.println( "\tThe Lowest-Elevation-Change Path starts at row: " + bestRow + " and gives a total change of: " + totalChange );

    }

    /**
     * This method reads a 2D data set from the specified file. The Graphics'
     * industry standard is width by height (width x height), while programmers
     * use rows x cols / (height x width).
     *
     * @param fileName the name of the file
     * @return a 2D array (rows x cols) of the data from the file read
     */
    public static int[][] read( String fileName ) throws FileNotFoundException {
        int[][] data;
        File heightData = new File("./data/mountain.paths/" + fileName);
        Scanner scanner = new Scanner(heightData);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        int row = 1;
        int col = st.countTokens();//counts cols
        while(scanner.hasNextLine()){//counts amount of rows
            scanner.nextLine();
            row++;
        }
        data = new int[row][col];
        
        scanner = new Scanner(heightData);
        
        row = 0;
        col = 0;
        while(scanner.hasNextLine()){
            st = new StringTokenizer(scanner.nextLine());
            col = 0;
            while(st.hasMoreTokens()){
                data[row][col] = Integer.parseInt(st.nextToken());
                col++;
            }
            row++;
        }
        scanner.close();
        return data;
    }

    /**
     * @param grid a 2D array from which you want to find the smallest value
     * @return the smallest value in the given 2D array
     */
    public static int findMinValue( int[][] grid ) {
        int min = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[j][i] < min ){
                    min = grid[j][i];
                }
            } 
        }
        return min;
    }

    /**
     * @param grid a 2D array from which you want to find the largest value
     * @return the largest value in the given 2D array
     */
    public static int findMaxValue( int[][] grid ) {
        int max = 0;
            for (int i = 0; i < grid[0].length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if(grid[j][i] > max ){
                    max = grid[j][i];
                }
            } 
        }
        return max;
    }

    /**
     * Given a 2D array of elevation data create a image of size rows x cols,
     * drawing a 1x1 rectangle for each value in the array whose color is set to
     * a a scaled gray value (0-255). Note: to scale the values in the array to
     * 0-255 you must find the min and max values in the original data first.
     *
     * @param g a Graphics context to use
     * @param grid a 2D array of the data
     */
    public static void drawMap( Graphics g, int[][] data ) {
        int minValue = findMinValue(data);
        int maxValue = findMaxValue(data);
        double divider = minValue + maxValue;//adds highest and lowest value for readability
        double colourScale;
        int dataHolder;
        for (int row = 0; row < data.length; row++) {//draws each pixel
            for (int col = 0; col < data[0].length; col++) {
                dataHolder = data[row][col];//readablitiy
                colourScale = (dataHolder / divider) * 256;
                g.setColor(new Color((int)colourScale,(int)colourScale,(int)colourScale));
                g.fillRect(col, row, 1, 1);
            }
        }  
    }

    /**
     * Scan a single column of a 2D array and return the index of the row that
     * contains the smallest value
     *
     * @param grid a 2D array
     * @col the column in the 2D array to process
     * @return the index of smallest value from grid at the given col
     */
    public static int indexOfMinInCol( int[][] grid, int col ) {
        int smallestNum = grid[0][col];
        int smallestIndex = 0;
        
        for (int row = 0; row < grid.length; row++) {//checks each row
            if(grid[row][col] < smallestNum){
                smallestNum = grid[row][col];
                smallestIndex = row;
            }   
        }
        return smallestIndex;
    }

    /**
     * Find the minimum elevation-change route from West-to-East in the given
     * grid, from the given starting row, and draw it using the given graphics
     * context
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @param row - the starting row for traversing to find the min path
     * @return total elevation of the route
     */
    public static int drawLowestElevPath( Graphics g, int[][] data, int row, int col ) {
        int deltaUp;//delta is change in elevation
        int deltaMiddle;
        int deltaDown;
        if(row < 0 || col < 0) return -1;//error case
        if(col == data[0].length - 1) return 0;//base case
       
        int currHeight = data[row][col];
        if(row == 0) {//if row is at the top sets change up to max int so it dosent pick up
            deltaUp = Integer.MAX_VALUE;
            deltaDown = Math.abs(data[row + 1][col + 1] - currHeight);    
            }
        else if(row == data.length - 1){ //if rows at bottem then sets change down to max int
            deltaDown = Integer.MAX_VALUE;
            deltaUp = Math.abs(data[row - 1][col + 1] - currHeight);
        }else{
            deltaUp = Math.abs(data[row - 1][col + 1] - currHeight);
            deltaDown = Math.abs(data[row + 1][col + 1] - currHeight);
        }
        deltaMiddle = Math.abs(data[row][col + 1] - currHeight);
        //middle is consistant
        int newRow;
        int currChange;
        if(deltaMiddle <= deltaUp && deltaMiddle <= deltaDown){//checks the direction to travel
            newRow = row;
            currChange = deltaMiddle;
        }else if(deltaUp < deltaDown){
            newRow = row - 1;
            currChange = deltaUp;
        }else if(deltaDown < deltaUp){
            newRow = row + 1;
            currChange = deltaDown;
        }else{
            if(Math.round(Math.random()) == 1){//coin flip
                newRow = row - 1;
                currChange = deltaUp;
            }else{
                newRow = row + 1;
                currChange = deltaDown;
            }
        }
        g.fillRect(col + 1, newRow, 1, 1);
        return currChange + drawLowestElevPath(g, data, newRow, col + 1);   
    }

    /**
     * Generate all west-to-east paths, find the one with the lowest total
     * elevation change, and return the index of the row that path starts on.
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @return the index of the row where the lowest elevation-change path
     * starts.
     */
    public static int indexOfLowestElevPath( Graphics g, int[][] data ) {
        int currChange;
        int leastChange = Integer.MAX_VALUE;
        int bestIndex = 0;
        //declaring varibles
        for (int i = 0; i < data.length; i++) {
            currChange = drawLowestElevPath(g, data, i, 0);
            if(currChange <= leastChange){
                bestIndex = i;
                leastChange = currChange;
            }
        }
        return bestIndex;
    }
    
    

}
