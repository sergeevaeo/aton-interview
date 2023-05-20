package com.aton.interview.task1;

import net.jcip.annotations.NotThreadSafe;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@NotThreadSafe
public class Person extends Thread {
    private final Order order;
    private final String name;
    private final List<String> phrases;

    public Person(Order order, String name) {
        this.order = requireNonNull(order);
        this.name = requireNonNull(name);
        this.phrases = new LinkedList<>();
    }

    /**
     * This method adds a new phrase to the person. Should not be called outside the person context (not thread safe).
     */
    public void addPhrase(String phrase) {
        phrases.add(phrase);
    }

    @Override
    public void run() {
        synchronized (order) {
            while (!order.getPeopleOrder().isEmpty() && !phrases.isEmpty()) {
                if (order.getPerson().equals(name)) {
                    System.out.println(name + ": " + phrases.remove(0));
                    order.removePerson();
                    order.notifyAll();
                } else {
                    try {
                        order.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}