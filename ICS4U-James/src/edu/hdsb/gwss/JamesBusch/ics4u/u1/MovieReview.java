/*
 *
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
//imports
/**
 * Movie Review Assignment
 *
 * @author James Busch
 * @version 20/2/18 v1
 * @description This program has multiple functions to do with using a word file contaning a review
 * 
 */
public class MovieReview {
    
    /**
     *
     */
    public static final int WORD_COUNT = 0;
    public static final int TOTAL_SCORE = 1;
    //to give getting array numbers meaning
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception {

        // MOVIE REVIEW FILE
        //File reviews = new File( "/Users/jamers444/NetBeansProjects/ICS4U-James/ICS4U-James/data/movie.review/MovieReviews.txt" );
        File reviews = new File( "./data/movie.review/MovieReviews.txt" );
        Scanner input = new Scanner(System.in);
        File userWordList;
        //object inilization
        
        int userNumber;
        String userWord;
        boolean inProgress = true;
        
        while(inProgress == true){
            System.out.println("What would you like to do?");
            System.out.println("1: Get the Score of a word");
            System.out.println("2: Get the average score of words in a file");
            System.out.println("3: Find the highest/lowest scoring words in a file");
            System.out.println("4: Sort words from a file into a positive.txt and negative.txt");
            System.out.println("5 exit the program");
            userNumber = Integer.parseInt(input.nextLine());
        
            switch(userNumber){
                case 1:
                    System.out.println("Enter a word");
                    userWord = input.nextLine();
                    System.out.println("The word appears " + wordCount(userWord, reviews) + " times");
                    System.out.println("The average score for reviews contaning " + userWord + " is " + wordAverage(userWord, reviews));
                    break;      
                case 2:
                    System.out.println("Enter the name of the file you want to find the average to");
                    userWord = input.nextLine();
                    userWord = "./data/movie.review/" + userWord;
                    userWordList = new File(userWord);
                    double listScore = sentenceAverage(userWordList, reviews);
                    System.out.println("The average score for the list is " + listScore);
                    if(listScore >= 2){
                        System.out.println("The overall sentimate is positive");
                    }else{
                        System.out.println("The overall sentimate is negative");
                    }
                    break;
                case 3:
                    System.out.println("Enter the name of the file you want to give words to");
                    userWord = input.nextLine();
                    userWord = "./data/movie.review/" + userWord;
                    userWordList = new File(userWord);
                    mutipleWordScore(userWordList, reviews);
                    break;
                case 4:
                    System.out.println("Enter the name of the file you want to sort");
                    userWord = input.nextLine();
                    userWord = "./data/movie.review/" + userWord;
                    userWordList = new File(userWord);
                    wordSort(userWordList, reviews);
                    break;
                case 5:
                    inProgress = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * This method will count the number of reviews that contain the key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the number of reviews that contain the key work at least once.
     * @throws java.lang.Exception
     */
    public static int wordCount( String word, File reviews ) throws Exception {
       int[] finalAnswers;
       finalAnswers = readLineByLine(word, reviews);
       return finalAnswers[WORD_COUNT]; 
    }

    /**
     * This method will accumulate the the movie review scores that contain the
     * key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the sum of the scores for reviews that contain the key work at
     * least once.
     * @throws java.lang.Exception
     */
    public static int wordTotalScore( String word, File reviews ) throws Exception {
        int[] finalAnswers;
        finalAnswers = readLineByLine(word, reviews);
        return finalAnswers[TOTAL_SCORE];
    }

    /**
     * Average score of reviews containing that word, given the specified file.
     *
     * @param word the key word the review must contain.
     * @param reviews reviews the file that contains the movie reviews.
     * @return the average score for the key word. Word Total Score / Word Count
     * @throws java.lang.Exception
     */
    public static double wordAverage( String word, File reviews ) throws Exception {
        double totalScore;
        double numOfWords;
        double answer;
        
        int[] finalAnswers;
        finalAnswers = readLineByLine(word, reviews);
        totalScore = finalAnswers[TOTAL_SCORE];
        numOfWords = finalAnswers[WORD_COUNT];
      
        if(numOfWords == 0){
            answer = 0;
        }else{
            answer = totalScore/numOfWords;
            }  
      
        return answer;
    }

    /**
     * This method returns the average movie review score of the words in the
     * file, given the specified movie review file.
     * @param wordList list of words to be tested
     * @param reviews file of all reviews
     * @return the average score of all words combined 
     * @throws java.lang.Exception 
     */
    public static double sentenceAverage( File wordList, File reviews ) throws Exception {
        Scanner userData = new Scanner(wordList);    
        
        int[] total;
        int totalScore = 0;
        int totalWords = 0;
        String currLine;

        while(userData.hasNextLine()){
            currLine = userData.nextLine();
            total = readLineByLine(currLine, reviews);
            totalScore = total[TOTAL_SCORE];
            totalWords = total[WORD_COUNT];
            
        }
        return totalScore / (double)totalWords;
    }
    
    /**
     *
     * @param wordList list of user input words
     * @param reviews list of all reviews
     * @throws Exception
     */
    public static void mutipleWordScore( File wordList, File reviews ) throws Exception{
        Scanner userData = new Scanner(wordList);
        
        double currScore;
        double bestScore = 0;
        double worstScore = 4;
        String bestWord = null;
        String worstWord = null;
        String currWord;
        
        
        while(userData.hasNextLine()){
            currWord = userData.nextLine();
            currScore = wordAverage(currWord,reviews);
            if(currScore > bestScore){
                bestScore = currScore;
                bestWord = currWord;
            }else if(currScore < worstScore && currScore != 0){
                worstScore = currScore;
                worstWord = currWord;
            }   
              
        }
        System.out.println("The worst word is " + worstWord + " with a " + worstScore);
        System.out.println("The best word is " + bestWord + " with a " + bestScore); 
    }
    
    public static void wordSort(File wordList, File reviews) throws Exception{
        Scanner userData = new Scanner(wordList);
        
        FileWriter badFile = new FileWriter("./data/movie.review/negative.txt");
        FileWriter goodFile = new FileWriter("./data/movie.review/positive.txt");
        
        BufferedWriter badWords = new BufferedWriter(badFile);
        BufferedWriter goodWords = new BufferedWriter(goodFile);
  
        double score;
        String currWord;
        
        while(userData.hasNextLine()){
            currWord = userData.nextLine();
            score = wordAverage(currWord, reviews);
            if(score >= 2.1){
                goodWords.append(currWord + "\n");
            }else if(score <= 1.9){
                badWords.append(currWord + "\n");
            }
           
        }
        badWords.close();
        goodWords.close();
         
    }
    
    
    /**
     *
     * @param word the key word that wants to be found
     * @param reviews the list of reviews
     * @return an array with wordCount at i = 0 and totalScore at i = 1
     * @throws java.lang.Exception
     */
    public static int[] readLineByLine(String word, File reviews) throws Exception {//a = 0 is word count, a = 1 is score count
        Scanner textFile = new Scanner(reviews);
        word = word.toLowerCase();
        int[] arrayTotal = new int[2];
        int currScore;
        int i = 0;
        int totalScore = 0;
        boolean hasWord;
        while(textFile.hasNextLine()){
            hasWord = false;
            StringTokenizer st = new StringTokenizer(textFile.nextLine().toLowerCase());
            currScore = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                if(st.nextToken().equals(word) && hasWord == false){
                    hasWord = true;
                    totalScore = currScore + totalScore;
                    i++;
                }      
            }
        }
        arrayTotal[0] = i;
        arrayTotal[1] = totalScore;
        return arrayTotal;
    }
}