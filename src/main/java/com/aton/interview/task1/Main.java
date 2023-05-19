package com.aton.interview.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Order order = new Order();
        order.addPerson("Joey");
        order.addPerson("Chandler");
        order.addPerson("Phoebe");
        order.addPerson("Chandler");
        order.addPerson("Joey");
        order.addPerson("Chandler");
        order.addPerson("Phoebe");
        order.addPerson("Joey");
        order.addPerson("Monica");
        order.addPerson("Phoebe");
        order.addPerson("Chandler");
        order.addPerson("Joey");
        order.addPerson("Chandler");
        order.addPerson("Joey");
        Person chandler = new Person(order, "Chandler");
        chandler.addPhrase("Hey.");
        chandler.addPhrase("And this from the cry-for-help department. Are you wearing make up?");
        chandler.addPhrase("What's so funny, 'cause I was thinking you look more like Joey Tribbiani, man splash woman.");
        chandler.addPhrase("Do you know which one you're gonna be?");
        chandler.addPhrase("Good luck, man. I hope you get it.");
        Person joey = new Person(order, "Joey");
        joey.addPhrase("Hey, hey.");
        joey.addPhrase("Yes, I am. As of today, I am officially Joey Tribbiani, actor slash model.");
        joey.addPhrase("You know those posters for the City Free Clinic?");
        joey.addPhrase("No, but I hear lyme disease is open, so… (crossed fingers)");
        joey.addPhrase("Thanks.");
        Person phoebe = new Person(order, "Phoebe");
        phoebe.addPhrase("Hey.");
        phoebe.addPhrase("What were you modeling for?");
        phoebe.addPhrase("You know, the asthma guy was really cute.");
        Person monica = new Person(order, "Monica");
        monica.addPhrase("Oh, wow, so you're gonna be one of those healthy, wealthy, healthy guys?");
        joey.start();
        chandler.start();
        phoebe.start();
        monica.start();
        joey.join();
        chandler.join();
        phoebe.join();
        monica.join();
    }
}