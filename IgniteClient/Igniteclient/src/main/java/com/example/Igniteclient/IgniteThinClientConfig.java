package com.example.Igniteclient;


import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.ClientConnectorConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteThinClientConfig {

    @Bean
    public Ignite ignite () {
        ClientConnectorConfiguration clientConnectorCfg = new ClientConnectorConfiguration();
// Set a port range from 10000 to 10005
        clientConnectorCfg.setPort(10000);
        clientConnectorCfg.setPortRange(5);

        IgniteConfiguration cfg = new IgniteConfiguration().setClientConnectorConfiguration(clientConnectorCfg);

// Start a node
        return Ignition.start(cfg);


    }
}