package com.example.demo;

import java.util.Collection;
import java.util.TreeMap;
import java.sql.Time;

class Order {
    String orderId;
    Time entryTime;

    public Order(String orderId, Time entryTime) {
        this.orderId = orderId;
        this.entryTime = entryTime;
    }

    public Time getEntryTime() {
        return entryTime;
    }
}

public class OrderCollection {
    // Using TreeMap which is implemented as a Red-Black Tree
    private TreeMap<Time, Order> orderMap;

    public OrderCollection() {
        this.orderMap = new TreeMap<>();
    }

    public void addOrder(Order order) {
        this.orderMap.put(order.getEntryTime(), order);
    }

    public Collection<Order> search(Time startTime, Time endTime) {
        return orderMap.subMap(startTime, true, endTime, true).values();
    }

    public static void main(String[] args) {
        OrderCollection orderCollection = new OrderCollection();
        orderCollection.addOrder(new Order("0124", Time.valueOf("10:15:00")));
        orderCollection.addOrder(new Order("0345", Time.valueOf("09:15:00")));
        orderCollection.addOrder(new Order("0873", Time.valueOf("13:30:00")));
        orderCollection.addOrder(new Order("0314", Time.valueOf("07:30:00")));

        Time startTime = Time.valueOf("09:00:00");
        Time endTime = Time.valueOf("11:00:00");

        Collection<Order> result = orderCollection.search(startTime, endTime);

        for (Order order : result) {
            System.out.println(order.orderId + " " + order.entryTime);
        }
    }
}
