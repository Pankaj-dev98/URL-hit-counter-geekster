package com.geekster.urlhitcounter.service;

import com.geekster.urlhitcounter.entity.Visitor;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {
    private Map<String, Integer> hitCountMap;

    @PostConstruct
    public void initMap() {
        hitCountMap = new HashMap<>();
    }

    public void addVisitor(Visitor visitor) {
        if(hitCountMap.containsKey(visitor.getUserName()))
            throw new RuntimeException("username " + visitor.getUserName() + " already exists");

        hitCountMap.put(visitor.getUserName(), 0);
    }


    public String getTotalHitCount() {
        int count = 0;
        for(Map.Entry<String, Integer> i: hitCountMap.entrySet())
            count += i.getValue();

        return "Total url hits on all users = " + count;
    }

    public String getHitCountByName(String userName) {
        if(!hitCountMap.containsKey(userName))
            throw new RuntimeException("user with name " + userName + " is not registered");

        return userName + " Hit count = " + hitCountMap.get(userName);
    }

    public Map<String, Integer> getAllVisitors() {
        return hitCountMap;
    }

    public String getVisitorCount() {
        return "Total users = " + hitCountMap.size();
    }

    public String incrementHitCountByName(String userName) {
        if(!hitCountMap.containsKey(userName))
            throw new RuntimeException("user with name " + userName + " is not registered");

        hitCountMap.put(userName, hitCountMap.get(userName) + 1);
        return "Hit count incremented for " + userName;
    }
}
