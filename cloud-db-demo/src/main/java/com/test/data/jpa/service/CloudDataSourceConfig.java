package com.test.data.jpa.service;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by mohan on 4/3/15.
 */

@Configuration
@Profile("cloud")
public class CloudDataSourceConfig extends AbstractCloudConfig {

    @Bean
    public DataSource dataSource(){
        return connectionFactory().dataSource();
    }
}
