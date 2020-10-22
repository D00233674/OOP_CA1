package com.dkit.sd2b.kieranmccormack.ca1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class JCResults {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("students_jc_results.txt"));
        sc.useDelimiter("[,\r\n]+");

        //store studentNumber to print later
        int studentNumber = 0;

        double average;

        //read in data to two seperate arrays
        int[] codes = new int[8];
        int[] grades = new int[8];

        System.out.println("Student Number\tAverage");

        while(sc.hasNext()){
            studentNumber = sc.nextInt();

            for(int i = 0; i < grades.length; i++){
                codes[i] = sc.nextInt();
                grades[i] = sc.nextInt();
            }

//            selectFiveGrades(codes, grades);
            average = calculateAverage(selectFiveGrades(codes, grades));

//            System.out.println(Arrays.toString(selectFiveGrades(codes, grades)));
            System.out.println(studentNumber + "\t\t\t" + average);
            //format with dedicated spaces instead of tabs
        }

        //Print StudentNumber   Average
        //for each line
            //fill codes array
            //fill grades array
            //pass into selectFiveGrades
            //pass result into calculateAverage
            //print StudentNumber and Average
        //next Line/Student


//        System.out.println(studentNumber);
//        for(int i = 0; i < codes.length; i++){
//            System.out.println(codes[i] + "\t" + grades[i]);
//        }

    }
    public static int[] selectFiveGrades(int[] codes, int[] grades){
        int[] selectedGrades = new int[5];
        final int IRISHCODE = 1;
        final int ENGLISHCODE = 2;
        final int MATHSCODE = 3;
        final int CSPECODE = 218;

        //going on the fact that there isnt any duplicate codes
        //ie: student cant have two results for maths
        int highest = -1; //cant use codes - cant use 0 - grades cant be negative???
        int secondHighest = -2; //negatives work
        int j = 0; //in turn should fill first 3 spaces in array with irish, english or math grades
        for(int i = 0; i < codes.length; i++){
            if(codes[i] == IRISHCODE || codes[i] == ENGLISHCODE || codes[i] == MATHSCODE){
                selectedGrades[j] = grades[i];
                j++;
            } else if(codes[i] == CSPECODE){
                //do nothing
            } else {
                //not needed as the previous initial values are not important codes
//                if(i == 0){ //re trace as assignments have changed
//                    if(grades[i] > grades[i+1]){
//                        highest = grades[i];
//                        secondHighest = grades[i+1];
//                    } else { //duplicates????
//                        highest = grades[i+1];
//                        secondHighest = grades[i];
//                    }
//                } else {
                    if(grades[i] > highest){
                        secondHighest = highest;
                        highest = grades[i];
                    } else if(grades[i] > secondHighest){
                        secondHighest = grades[i];
                    }
//                }
            }
        }
        System.out.println(Arrays.toString(selectedGrades));
        //add highest and secondHighest into the array - needs to be more efficient
        boolean highestInputted = false;
        for(int i = 0; i < selectedGrades.length; i++){
            if(selectedGrades[i] == 0 && !highestInputted){
                selectedGrades[i] = highest;
                highestInputted = true;
            } else if(selectedGrades[i] == 0 && highestInputted){
                selectedGrades[i] = secondHighest;
            }
        }
//        for(int i = 0; i < selectedGrades.length; i++){
//            if(selectedGrades[i] == 0){
//                selectedGrades[i] = secondHighest;
//            }
//        }

        System.out.println(Arrays.toString(selectedGrades));

        return selectedGrades;
    }
    private static double calculateAverage(int[] selectedGrades){
        double average = 0;
        int sum = 0;

        for(int grade : selectedGrades){
            sum += grade;
        }

        average = sum / ((double)selectedGrades.length);

        return average;
    }
}
