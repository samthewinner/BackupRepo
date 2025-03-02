package com.example.demo;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteThinClientConfig {

    @Bean
    public IgniteClient igniteClient() {
        ClientConfiguration cfg = new ClientConfiguration()
                .setAddresses("127.0.0.1:10800")
                .setPartitionAwarenessEnabled(true); // Connect to local Ignite server
        System.out.println(cfg.isPartitionAwarenessEnabled());

        return Ignition.startClient(cfg);
    }
}