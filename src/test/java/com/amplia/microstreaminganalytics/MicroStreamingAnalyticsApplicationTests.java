package com.amplia.microstreaminganalytics;

import com.amplia.microstreaminganalytics.statistics.StatisticsCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class MicroStreamingAnalyticsApplicationTests {

    @Autowired
    private StatisticsCalculator statisticsCalculator;

    private static final Logger logger = LoggerFactory.getLogger(MicroStreamingAnalyticsApplicationTests.class);


    @Test
    void contextLoads() {
        Assertions.assertThat(statisticsCalculator).isNotNull();
    }

    @Test
    void mean() {
        logger.info("Checking mean equality");
        Assertions.assertThat(this.statisticsCalculator.calculateMean(new ArrayList<>(Arrays.asList(1, 2, 3)))).isEqualTo("2.0");
    }

    @Test
    void mode() {
        logger.info("Checking mode equality");
        Assertions.assertThat(this.statisticsCalculator.calculateMode(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4)))).isEqualTo("3");
    }

    @Test
    void median() {
        logger.info("Checking median equality");
        Assertions.assertThat(this.statisticsCalculator.calculateMedian(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4)))).isEqualTo("3");
    }

    @Test
    void standardDeviation() {
        logger.info("Checking standardDeviation equality");
        Assertions.assertThat(this.statisticsCalculator.calculateStandardDeviation(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4)))).isEqualTo("1.019803902718557");
    }

    @Test
    void quartiles() {
        logger.info("Checking quartiles equality");
        Assertions.assertThat(this.statisticsCalculator.calculateQuartiles(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5)))).isEqualTo("2,3,4");
    }

    @Test
    void minimum() {
        logger.info("Checking minimum equality");
        Assertions.assertThat(this.statisticsCalculator.calculateMinValue(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4)))).isEqualTo("1");
    }

    @Test
    void maximum() {
        logger.info("Checking maximum equality");
        Assertions.assertThat(this.statisticsCalculator.calculateMaxValue(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4)))).isEqualTo("4");
    }

}
