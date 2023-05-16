package com.aton.interview.task1;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Chandler chandler = new Chandler(order);
        chandler.setName("Chandler");

        Joey joey = new Joey(order);
        joey.setName("Joey");

        Phoebe phoebe = new Phoebe(order);
        phoebe.setName("Phoebe");

        Monica monica = new Monica(order);
        monica.setName("Monica");


        joey.start();
        chandler.start();
        phoebe.start();
        monica.start();


    }

}
