package com.cheapflights;

import java.time.LocalDateTime;

@org.springframework.context.annotation.Configuration
public class Configuration {
    public Feed feed() {
        return new Feed("Cheap Flights", "www.cheapflights.cfapps.io", "Cheap Flights", "eng", "MIT", LocalDateTime.now().toString());
    }
}
