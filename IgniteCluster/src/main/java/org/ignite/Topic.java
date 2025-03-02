package org.ignite;



import org.apache.ignite.cache.affinity.AffinityKeyMapped;

import java.util.ArrayList;
import java.util.List;


public   class  Topic {
    private List<Long>subscribersIds;
    private String name;

    private long id;

    @AffinityKeyMapped
    private int affinityId= 5;


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
