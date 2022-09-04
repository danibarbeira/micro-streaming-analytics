package com.amplia.microstreaminganalytics.rabbitmq.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class DataStream {

    private String id;
    private String feed;
    private ArrayList<DataPoint> datapoints;

}
