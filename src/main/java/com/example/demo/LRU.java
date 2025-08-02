package com.example.demo;

import java.util.HashMap;

class LRUCache {
    // Node class to store key-value pairs
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail nodes to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // Move the accessed node to the head
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            // Move the updated node to the head
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);

            if (map.size() > capacity) {
                // Remove the least recently used node
                Node tail = popTail();
                map.remove(tail.key);
            }
        }
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}

// Example usage
public  class LRU {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.set(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.set(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
