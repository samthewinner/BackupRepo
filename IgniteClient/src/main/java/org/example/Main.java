package org.example;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.cluster.ClusterGroup;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.cluster.ClusterMetrics;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.ClientConfiguration;

import java.util.Random;



import java.util.ArrayList;
import java.util.List;


class Topic {
    private List<Long>subscribersIds;
    private String name;
    private long id;

    public List<Long> getSubscribersIds() {
        return subscribersIds;
    }

    public void setSubscribersIds(List<Long> subscribersIds) {
        this.subscribersIds = subscribersIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static public StringBuffer getRandom(){
        StringBuffer s = new StringBuffer();
        for(int i=0;i<10;i++){
            int val = ((int)Math.random()*100)%26;
            s.append((char)(val+'a'));
        }
        return s;
    }
    public static void main(String[] args) {


        ClientConfiguration cfg = new ClientConfiguration().setAddresses("localhost");


//        Ignition.setClientMode(true);
        try (IgniteClient ignite = Ignition.startClient(cfg)){

            ClientCache< String,Topic> cache = ignite.cache("c1");
            System.out.println(cache.get("Spreadpool"));
//            System.out.println("Key: Cluster1 , Value: "+cache.get("Deadpool"));;
//            System.out.println("Key: Cluster2 , Value: "+cache.get("Cluster2"));;

//            IgniteCache<String,Integer> ignitecache  = ignite.getOrCreateCache("c1");
//            ignitecache.put(getRandom().toString(),1);
//
//            System.out.println("Cache size: "+ignitecache.size());
//            System.out.println("Printing cache:----");
//            ignitecache.forEach(x-> System.out.println("KEY: "+x.getKey()+" VALUE: "+x.getValue()));

//            ClusterGroup clusterGroup = ignite.cluster().forServers();

            // Print cluster topology
//            System.out.println("Cluster Topology:");
//            for (ClusterNode node : clusterGroup.nodes()) {
//                System.out.println("Node ID: " + node.id());
//                System.out.println("Node Address: " + node.addresses());
//                System.out.println("Is Client: " + node.isClient());
//                System.out.println("Node Order: " + node.order());
//                System.out.println("Node Version: " + node.version());
//                System.out.println("Node Attributes: " + node.attributes());
//                System.out.println("----------------------------------------");
//            }
//
//            // Print cluster metrics
//            System.out.println("Cluster Metrics:");
//            for (ClusterNode node : clusterGroup.nodes()) {
//                ClusterMetrics metrics = node.metrics();
//                System.out.println("Node ID: " + node.id());
//                System.out.println("CPU Usage: " + metrics.getCurrentCpuLoad() * 100 + "%");
//                System.out.println("Heap Memory Used: " + metrics.getHeapMemoryUsed() / 1024 / 1024 + " MB");
//                System.out.println("Non-Heap Memory Used: " + metrics.getNonHeapMemoryUsed() / 1024 / 1024 + " MB");
//                System.out.println("Total Executed Jobs: " + metrics.getTotalExecutedJobs());
//                System.out.println("Active Jobs: " + metrics.getCurrentActiveJobs());
//                System.out.println("----------------------------------------");
//            }
        }
        Ignition.setClientMode(true);
        CacheConfiguration cfg1 = new CacheConfiguration();
        System.out.println(cfg1.getAffinity());;
        try(Ignite ignite = Ignition.start()){
//            System.out.println(ignite.g);
        }

    }
}