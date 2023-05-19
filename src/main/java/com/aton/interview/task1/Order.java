package com.aton.interview.task1;

import net.jcip.annotations.NotThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@NotThreadSafe
public class Order {
    private final Queue<String> peopleOrder;

    public Order() {
        peopleOrder = new LinkedList<>();
    }

    public void addPerson(String person) {
        peopleOrder.add(person);
    }

    public Queue<String> getPeopleOrder() {
        return peopleOrder;
    }

    public String getPerson() {
        return peopleOrder.peek();
    }

    public void removePerson() {
        peopleOrder.remove();
    }
}