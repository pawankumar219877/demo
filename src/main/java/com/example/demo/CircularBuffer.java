package com.example.demo;

import java.util.Arrays;

public class CircularBuffer<T> {
    private Object[] buffer;
    private int head;
    private int tail;
    private int size;

    public CircularBuffer(int capacity) {
        buffer = new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void addItem(T item) {
        buffer[head] = item;
        head = (head + 1) % buffer.length;

        // If the head overlaps with the tail, increment the tail to discard the oldest item
        if (head == tail) {
            tail = (tail + 1) % buffer.length;
        } else {
            // If not overlapping, increase the size
            size++;
        }
    }

    public Object[] getBuffer() {
        Object[] result = new Object[size];
        int index = tail;

        for (int i = 0; i < size; i++) {
            result[i] = buffer[index];
            index = (index + 1) % buffer.length;
        }

        return result;
    }

    public static void main(String[] args) {
        int maxThreshold = 5;
        CircularBuffer<Integer> buffer = new CircularBuffer<>(maxThreshold);

        for (int i = 1; i <= 12; i++) {
            buffer.addItem(i);
            System.out.println("After adding " + i + ", buffer: " + Arrays.toString(buffer.getBuffer()));
        }
    }
}

