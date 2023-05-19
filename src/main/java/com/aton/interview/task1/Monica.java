package com.aton.interview.task1;

import java.util.ArrayList;
import java.util.List;

public class Monica extends Thread {
    private final Order order;
    private final List<String> lines;
    public Monica (Order order) {
        this.order = order;
        lines = new ArrayList<>(); // все реплики Monici по порядку
        lines.add("Oh, wow, so you're gonna be one of those healthy, wealthy, healthy guys?");
    }

    @Override
    public void run() {
        synchronized (order) {
            while (!order.peopleOrder.isEmpty()) {
                if (order.getPerson().equals("Monica")) { // если очередь реплики Monici
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