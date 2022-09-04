package com.amplia.microstreaminganalytics.rabbitmq.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class CustomMessage {

    private String version;
    private String device;
    private ArrayList<DataStream> datastreams;

}
