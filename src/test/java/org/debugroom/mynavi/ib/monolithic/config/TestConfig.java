package org.debugroom.mynavi.ib.monolithic.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

public class TestConfig {

    @Configuration
    @EnableConfigurationProperties
    public static class ServiceTestConfig{
    }

}
