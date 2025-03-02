package org.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.affinity.Affinity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main  {

    public static void main(String[] args) {


        Ignite ignite = null;


        if("Cluster1".equals(args[0]))
        {
            ignite = Ignition.start("ignite-config1.xml");

        }

        else if("Cluster2".equals(args[0]))
            ignite = Ignition.start("ignite-config2.xml");

        System.out.println("Hello from "+args[0]);
        System.out.println("Running as a :"+(Ignition.isClientMode()?"Client Node":"Server Node" +"..."));
        assert ignite != null;
        IgniteCache <String, List<Integer>> ignitecache  = ignite.getOrCreateCache("c1");
//        if("Cluster1".equals(args[0]))
//            ignitecache.put("X-Men",new ArrayList<>(Arrays.asList(1,2,3)));
//        else if("Cluster2".equals(args[0]))
//            ignitecache.put("Deadpool",new ArrayList<>(Arrays.asList(12,45,69)));


        while(true){

        }

    }
}