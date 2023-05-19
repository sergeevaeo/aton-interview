package com.aton.interview.task1;

import java.util.LinkedList;
import java.util.Queue;

public class Order {
    public Queue<String> peopleOrder;

    public Order() {
        peopleOrder = new LinkedList<>();
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
        return peopleOrder.peek();
    }

    public void removePerson() {
        peopleOrder.remove();
    }
}