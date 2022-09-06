package com.amplia.microstreaminganalytics.repository;

import com.amplia.microstreaminganalytics.model.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRepository extends MongoRepository<Statistics, Long> {

}
