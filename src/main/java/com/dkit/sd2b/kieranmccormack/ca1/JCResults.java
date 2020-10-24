/*
Name:               Kieran McCormack
Student Number:     D00233674
GitHub Repository:  https://github.com/D00233674/OOP_CA1.git
 */


package com.dkit.sd2b.kieranmccormack.ca1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class JCResults
{
    public static void main(String[] args)
    {

        //Setting up scanner to point to correct file
        Scanner sc = null;
        try
        {
            sc = new Scanner(new File("students_jc_results2.txt"));
            //delimiter used to tell scanner when it reaches the end of a value
            sc.useDelimiter("[,\r\n]+");


            //store studentNumber to print later
            int studentNumber = 0;

            //intialise average
            double average;

            //read in data to two seperate arrays
            int[] codes = new int[8];
            int[] grades = new int[8];

            //print table headings
            System.out.printf("%15s%15s\n", "Student Number", "Average");

            //while there is still data in the text file
            while (sc.hasNext())
            {
                //store student number
                studentNumber = sc.nextInt();

                //fill the two arrays
                for (int i = 0; i < grades.length; i++)
                {
                    codes[i] = sc.nextInt();
                    grades[i] = sc.nextInt();
                }

                //firstly figure out the five grades associated with each student
                //then using these five grades calculate the average of the five grades
                average = calculateAverage(selectFiveGrades(codes, grades));

                //output the result
                System.out.printf("%12d%17.1f\n", studentNumber, average);

            }

            sc.close();

        } catch (FileNotFoundException e)
        {
            System.out.println("File does not exist!");
        }
    }

    public static int[] selectFiveGrades(int[] codes, int[] grades)
    {
        //intialising variables
        int[] selectedGrades = new int[5];
        final int IRISHCODE = 1;
        final int ENGLISHCODE = 2;
        final int MATHSCODE = 3;
        final int CSPECODE = 218;


        int highest = -1; //cant use codes - cant use 0 - grades cant be negative
        int secondHighest = -2;
        int j = 0; //in turn should fill first 3 spaces in array with irish, english or math grades

        //run through the two arrays
        for (int i = 0; i < codes.length; i++)
        {
            //if it finds on of the following codes add it to the new array
            if (codes[i] == IRISHCODE || codes[i] == ENGLISHCODE || codes[i] == MATHSCODE)
            {
                selectedGrades[j] = grades[i];
                j++;
            //if the code is CSPE do nothing
            } else if (codes[i] == CSPECODE)
            {
                //do nothing
            } else
            {
                //in any other case work out the highest and second highest grades
                if (grades[i] > highest)
                {
                    secondHighest = highest;
                    highest = grades[i];
                } else if (grades[i] > secondHighest)
                {
                    secondHighest = grades[i];
                }
            }
        }

        //add highest and secondHighest into the array
        boolean highestInputted = false;
        for (int i = 0; i < selectedGrades.length; i++)
        {
            if (selectedGrades[i] == 0 && !highestInputted)
            {
                selectedGrades[i] = highest;
                highestInputted = true;
            } else if (selectedGrades[i] == 0 && highestInputted)
            {
                selectedGrades[i] = secondHighest;
            }
        }

        //return the new array of five grades
        return selectedGrades;
    }

    public static double calculateAverage(int[] selectedGrades)
    {
        //intialising variables
        double average = 0;
        int sum = 0;

        //run through the grades array to calculate the total
        for (int grade : selectedGrades)
        {
            sum += grade;
        }

        //divide the total by the length of the array(5) to get the average ensuring to account for integer divisiom
        average = sum / ((double) selectedGrades.length);

        //return the result
        return average;
    }
}
