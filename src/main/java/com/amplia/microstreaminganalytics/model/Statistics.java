package com.amplia.microstreaminganalytics.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("statistics")
@Data
@NoArgsConstructor
public class Statistics {

    @Id
    private Long timestamp;

    private String deviceId;
    private String dataStreamId;
    private String mean;
    private String mode;
    private String median;
    private String standardDeviation;
    private String quartiles;
    private String minValue;
    private String maxValue;

}
