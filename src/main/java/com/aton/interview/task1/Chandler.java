package com.aton.interview.task1;

import java.util.ArrayList;
import java.util.List;

public class Chandler extends Thread {
    private final Order order;
    private final List<String> lines;
    public Chandler (Order order) {
        this.order = order;
        lines = new ArrayList<>(); // все реплики Chandler по порядку
        lines.add("Hey.");
        lines.add("And this from the cry-for-help department. Are you wearing make up?");
        lines.add("What's so funny, 'cause I was thinking you look more like Joey Tribbiani, man splash woman.");
        lines.add("Do you know which one you're gonna be?");
        lines.add("Good luck, man. I hope you get it.");
    }

    @Override
    public void run() {
        synchronized (order) {
            while (!order.peopleOrder.isEmpty()) {
                if (order.getPerson().equals("Chandler")) { // если очередь реплики Chendlera
                    System.out.println(Thread.currentThread().getName() + ": " + lines.remove(0));
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