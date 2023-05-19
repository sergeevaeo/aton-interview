package com.aton.interview.task1;

import net.jcip.annotations.NotThreadSafe;

import java.util.LinkedList;
import java.util.List;

@NotThreadSafe
public class Person extends Thread {
    private final Order order;
    private final String name;
    private final List<String> lines;

    public Person(Order order, String name) {
        this.name = name;
        this.order = order;
        lines = new LinkedList<>();
    }

    public void addPhrase(String phrase) {
        lines.add(phrase);
    }

    @Override
    public void run() {
        synchronized (order) {
            while (!order.getPeopleOrder().isEmpty()) {
                if (order.getPerson().equals(name)) {
                    System.out.println(name + ": " + lines.remove(0));
                    order.removePerson(); // удаление из очереди
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