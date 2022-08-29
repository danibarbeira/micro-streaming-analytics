# micro-streaming-analytics

This is a GitHib repository for a technical test.

The test consists of a dockerized Spring Boot application, that executes a process periodically.

The process will read messages in JSON format from a RabbitMQ server, parse the messages and process the data.
It will generate statistical information of the values retrieved, consisting in the mean, medium, mode, standard deviation, quartiles and minimum/maximum values.

This data will then be stored in JSON format in a MongoDB NoSQL database. The JSON will contain a timestamp and the statistical data obtained.