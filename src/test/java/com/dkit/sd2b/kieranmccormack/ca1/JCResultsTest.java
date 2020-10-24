package com.dkit.sd2b.kieranmccormack.ca1;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class JCResultsTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testMain() {
    }

    @Test
    public void testSelectFiveGrades() {
        System.out.println("Five Grades 1 : ");
        int[] codes = {1, 2, 3, 4, 5, 12, 42, 46};
        int[] grades = {65, 58, 45, 60, 50, 48, 42, 60};
        int[] expResult = {65, 58, 45, 60, 60};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void testSelectFiveGrades2() {
        System.out.println("Five Grades 2 : ");
        int[] codes = {3,1,2,125,137,126,57,4};
        int[] grades = {65,58,45,60,68,100,77,60};
        int[] expResult = {65,58,45,100,77};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades3() {
        System.out.println("Five Grades 3 : ");
        int[] codes = {218,2,1,5,8,3,9,57};
        int[] grades = {100,50,100,67,55,98,45,78};
        int[] expResult = {50,100,98,78,67};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades4() {
        System.out.println("Five Grades 4 : ");
        int[] codes = {1,218,3,6,2,8,5,54};
        int[] grades = {57,94,45,75,87,34,98,34};
        int[] expResult = {57,45,87,98,75};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades5() {
        System.out.println("Five Grades 5 : ");
        int[] codes = {5,218,3,6,1,2,8,12};
        int[] grades = {36,68,45,59,56,78,87,74};
        int[] expResult = {45,56,78,87,74};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades6() {
        System.out.println("Five Grades 6 : ");
        int[] codes = {13,47,218,1,3,2,137,217};
        int[] grades = {67,68,89,75,64,95,61,84};
        int[] expResult = {75,64,95,84,68};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades7() {
        System.out.println("Five Grades 7 : ");
        int[] codes = {126,83,2,3,1,65,47,48};
        int[] grades = {100,58,56,79,92,57,83,67};
        int[] expResult = {56,79,92,100,83};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades8() {
        System.out.println("Five Grades 8 : ");
        int[] codes = {1,2,3,218,54,13,9,10};
        int[] grades = {87,68,78,65,75,64,68,75};
        int[] expResult = {87,68,78,75,75};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades9() {
        System.out.println("Five Grades 9 : ");
        int[] codes = {27,46,1,2,3,41,52,137};
        int[] grades = {51,57,67,89,67,78,69,76};
        int[] expResult = {67,89,67,78,76};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }
    @Test
    public void testSelectFiveGrades10() {
        System.out.println("Five Grades 10 : ");
        int[] codes = {565,221,200,1,2,3,218,125};
        int[] grades = {83,57,87,64,97,79,100,84};
        int[] expResult = {64,97,79,87,84};
        int[] result = JCResults.selectFiveGrades(codes, grades);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void testCalculateAverage() {
        System.out.println("Average 1 : ");
        int[] fiveGrades = {65, 58, 45, 60, 60};
        double expResult = 57.6;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage2() {
        System.out.println("Average 2 : ");
        int[] fiveGrades = {65,58,45,100,77};
        double expResult = 69;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage3() {
        System.out.println("Average 3 : ");
        int[] fiveGrades = {50,100,98,67,78};
        double expResult = 78.6;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage4() {
        System.out.println("Average 4 : ");
        int[] fiveGrades = {57,45,87,75,98};
        double expResult = 72.4;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage5() {
        System.out.println("Average 5 : ");
        int[] fiveGrades = {45,56,78,87,74};
        double expResult = 68;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage6() {
        System.out.println("Average 6 : ");
        int[] fiveGrades = {75,64,95,84,68};
        double expResult = 77.2;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage7() {
        System.out.println("Average 7 : ");
        int[] fiveGrades = {100,56,92,79,83};
        double expResult = 82;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage8() {
        System.out.println("Average 8 : ");
        int[] fiveGrades = {87,68,78,75,75};
        double expResult = 76.6;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage9() {
        System.out.println("Average 9 : ");
        int[] fiveGrades = {67,89,67,76,78};
        double expResult = 75.4;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
    @Test
    public void testCalculateAverage10() {
        System.out.println("Average 10 : ");
        int[] fiveGrades = {64,97,79,87,84};
        double expResult = 82.2;
        double result = JCResults.calculateAverage(fiveGrades);

        System.out.println(result);

        assertEquals(expResult, result);
    }
}