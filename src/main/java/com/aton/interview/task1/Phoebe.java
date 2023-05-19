package com.aton.interview.task1;

import java.util.ArrayList;
import java.util.List;

public class Phoebe extends Thread {
    private final Order order;
    private final List<String> lines;
    public Phoebe (Order order) {
        this.order = order;
        lines = new ArrayList<>(); // все реплики  Phoebe по порядку
        lines.add("Hey.");
        lines.add("What were you modeling for?");
        lines.add("You know, the asthma guy was really cute.");
    }


    @Override
    public void run() {
        synchronized (order) {
            while (!order.peopleOrder.isEmpty()) {
                if (order.getPerson().equals("Phoebe")) { // если очередь реплики Phoebe
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