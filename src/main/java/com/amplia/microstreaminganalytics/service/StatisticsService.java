package com.amplia.microstreaminganalytics.service;

import com.amplia.microstreaminganalytics.model.Statistics;
import com.amplia.microstreaminganalytics.rabbitmq.message.DataStream;

public interface StatisticsService {

    Statistics calculateStatistics(String deviceId, DataStream dataStream);

    void saveStatistics(Statistics statistics);

}
