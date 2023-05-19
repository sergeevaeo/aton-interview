package com.aton.interview.task1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public List<String> peopleOrder;

    public Order() {
        peopleOrder = new ArrayList<>();
        peopleOrder.add("Joey");
        peopleOrder.add("Chandler");
        peopleOrder.add("Phoebe");
        peopleOrder.add("Chandler");
        peopleOrder.add("Joey");
        peopleOrder.add("Chandler");
        peopleOrder.add("Phoebe");
        peopleOrder.add("Joey");
        peopleOrder.add("Monica");
        peopleOrder.add("Phoebe");
        peopleOrder.add("Chandler");
        peopleOrder.add("Joey");
        peopleOrder.add("Chandler");
        peopleOrder.add("Joey");
    }

    public String getPerson() {
        return peopleOrder.get(0);
    }

    public void removePerson() {
        peopleOrder.remove(0);
    }
}