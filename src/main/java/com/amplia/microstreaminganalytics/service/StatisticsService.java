package com.amplia.microstreaminganalytics.service;

import com.amplia.microstreaminganalytics.model.Statistics;
import com.amplia.microstreaminganalytics.rabbitmq.message.DataStream;

public interface StatisticsService {

    /**
     * Given a deviceId and a data stream, calculates the statistics with the values of the data points in the stream.
     *
     * @param deviceId   The id of the device.
     * @param dataStream The data stream object containing the data points.
     * @return A statistics object with the corresponding statistics calculated, the device id, data stream id and the timestamp of the calculation time.
     */
    Statistics calculateStatistics(String deviceId, DataStream dataStream);

    /**
     * Saves the statistics object in a MongoDB database.
     *
     * @param statistics The set statistics object to be saved.
     */
    void saveStatistics(Statistics statistics);

}
