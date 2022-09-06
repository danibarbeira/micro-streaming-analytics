package com.amplia.microstreaminganalytics.statistics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class StatisticsCalculatorImpl implements StatisticsCalculator {

    @Override
    public String calculateMean(ArrayList<Integer> numberArray) {

        Double mean = 0.0;

        for (Integer number : numberArray) {
            mean += number;
        }

        return String.valueOf(mean / numberArray.size());
    }

    @Override
    public String calculateMode(ArrayList<Integer> numberArray) {
        Integer mode = numberArray.get(0);
        int maxCount = 0;
        int value, count;
        for (int i = 0; i < numberArray.size(); i++) {
            value = numberArray.get(i);
            count = 0;
            for (Integer integer : numberArray) {
                if (integer.equals(value)) {
                    count++;
                }
                if (count > maxCount) {
                    mode = value;
                    maxCount = count;
                }
            }
        }
        if (maxCount > 1) {
            return mode.toString();
        }
        return null;
    }

    @Override
    public String calculateMedian(ArrayList<Integer> numberArray) {
        Collections.sort(numberArray);

        if (numberArray.size() % 2 == 1) {
            return String.valueOf(numberArray.get((numberArray.size() + 1) / 2 - 1));
        } else {
            double lower = numberArray.get(numberArray.size() / 2 - 1);
            double upper = numberArray.get(numberArray.size() / 2);

            return String.valueOf((lower + upper) / 2.0);
        }
    }

    @Override
    public String calculateStandardDeviation(ArrayList<Integer> numberArray) {
        return String.valueOf(Math.sqrt(this.calculateVariance(numberArray)));
    }

    @Override
    public String calculateQuartiles(ArrayList<Integer> numberArray) {
        Collections.sort(numberArray);

        StringBuilder sb = new StringBuilder(this.calculateQuartile(numberArray, 25));
        sb.append(",").append(this.calculateQuartile(numberArray, 50));
        sb.append(",").append(this.calculateQuartile(numberArray, 75));

        return sb.toString();
    }

    @Override
    public String calculateMinValue(ArrayList<Integer> numberArray) {
        Collections.sort(numberArray);
        return numberArray.get(0).toString();
    }

    @Override
    public String calculateMaxValue(ArrayList<Integer> numberArray) {
        Collections.sort(numberArray);
        return numberArray.get(numberArray.size() - 1).toString();
    }

    private double calculateVariance(ArrayList<Integer> numberArray) {
        Double mean = Double.parseDouble(this.calculateMean(numberArray));
        double sumOfSquares = 0.0;
        for (Integer number : numberArray) {
            sumOfSquares += Math.pow(number - mean, 2);
        }
        return sumOfSquares / numberArray.size();
    }

    private String calculateQuartile(ArrayList<Integer> numberArray, int quartilePercent) {
        return numberArray.get(Math.round(numberArray.size() * quartilePercent / 100)).toString();
    }

}
