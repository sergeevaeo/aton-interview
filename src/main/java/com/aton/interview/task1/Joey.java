package com.aton.interview.task1;

import java.util.ArrayList;
import java.util.List;

public class Joey extends Thread {
    private final Order order;
    private final List<String> lines;
    public Joey (Order order) {
        this.order = order;
        lines = new ArrayList<>(); // все реплики Joey по порядку
        lines.add("Hey, hey.");
        lines.add("Yes, I am. As of today, I am officially Joey Tribbiani, actor slash model.");
        lines.add("You know those posters for the City Free Clinic?");
        lines.add("No, but I hear lyme disease is open, so… (crossed fingers)");
        lines.add("Thanks.");
    }

    @Override
    public void run() {
        synchronized (order) {
            while (!order.peopleOrder.isEmpty()) {
                if (order.getPerson().equals("Joey")) { // если очередь реплики Joey
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
