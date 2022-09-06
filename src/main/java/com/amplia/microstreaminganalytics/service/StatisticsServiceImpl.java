package com.amplia.microstreaminganalytics.service;

import com.amplia.microstreaminganalytics.model.Statistics;
import com.amplia.microstreaminganalytics.rabbitmq.message.DataPoint;
import com.amplia.microstreaminganalytics.rabbitmq.message.DataStream;
import com.amplia.microstreaminganalytics.repository.StatisticsRepository;
import com.amplia.microstreaminganalytics.statistics.StatisticsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsCalculator statisticsCalculator;

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public Statistics calculateStatistics(String deviceId, DataStream dataStream) {
        Statistics statistics = new Statistics();
        ArrayList<Integer> values = new ArrayList<>();
        statistics.setDeviceId(deviceId);
        statistics.setDataStreamId(dataStream.getId());
        statistics.setTimestamp(Instant.now().toEpochMilli());

        for (DataPoint dataPoint : dataStream.getDatapoints()) {
            values.add(dataPoint.getValue());
        }

        statistics.setMean(statisticsCalculator.calculateMean(values));
        statistics.setMode(statisticsCalculator.calculateMode(values));
        statistics.setMedian(statisticsCalculator.calculateMedian(values));
        statistics.setStandardDeviation(statisticsCalculator.calculateStandardDeviation(values));
        statistics.setQuartiles(statisticsCalculator.calculateQuartiles(values));
        statistics.setMaxValue(statisticsCalculator.calculateMaxValue(values));
        statistics.setMinValue(statisticsCalculator.calculateMinValue(values));

        return statistics;

    }

    @Override
    public void saveStatistics(Statistics statistics) {
        statisticsRepository.save(statistics);
    }
}
