package com.amplia.microstreaminganalytics.statistics;

import java.util.ArrayList;

public interface StatisticsCalculator {

    /**
     * Given an array of numbers, calculates the mean value and returns it as a String.
     *
     * @param numberArray Unordered array of numbers.
     * @return The mean value of the numbers in the array as a String.
     */
    String calculateMean(ArrayList<Integer> numberArray);

    /**
     * Given an array of numbers, calculates the mode and returns it as a String.
     *
     * @param numberArray Unordered array of numbers.
     * @return The mode of the numbers in the array as a String.
     */
    String calculateMode(ArrayList<Integer> numberArray);

    /**
     * Given an array of numbers, calculates the median value and returns it as a String.
     *
     * @param numberArray Unordered array of numbers.
     * @return The median value of the numbers in the array as a String.
     */
    String calculateMedian(ArrayList<Integer> numberArray);

    /**
     * Given an array of numbers, calculates the standard deviation value and returns it as a String.
     *
     * @param numberArray Unordered array of numbers.
     * @return The standard deviation value of the numbers in the array as a String.
     */
    String calculateStandardDeviation(ArrayList<Integer> numberArray);

    /**
     * Given an array of numbers, calculates the first, second and third quartile values and returns them as a String separated by commas.
     *
     * @param numberArray Unordered array of numbers.
     * @return The first, second and third quartile values of the numbers in the array as a String separated by commas.
     */
    String calculateQuartiles(ArrayList<Integer> numberArray);

    /**
     * Given an array of numbers, calculates the minimum value and returns it as a String.
     *
     * @param numberArray Unordered array of numbers.
     * @return The minimum value of the numbers in the array as a String.
     */
    String calculateMinValue(ArrayList<Integer> numberArray);

    /**
     * Given an array of numbers, calculates the maximum value and returns it as a String.
     *
     * @param numberArray Unordered array of numbers.
     * @return The maximum value of the numbers in the array as a String.
     */
    String calculateMaxValue(ArrayList<Integer> numberArray);

}
