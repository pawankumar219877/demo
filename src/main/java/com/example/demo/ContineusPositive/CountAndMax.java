package com.example.demo.ContineusPositive;

class CountAndMax {
    private long count = 0;
    private long maxCount = 0;

    public long getCount() {
        return count;
    }

    public boolean isPositive() {
        return count > 0;
    }

    public void incrementCount() {
        count++;
        if (count > maxCount) {
            maxCount = count;
        }
    }

    public void resetCount() {
        count = 0;
    }

    public void addToCount(long value) {
        count += value;
        if (count > maxCount) {
            maxCount = count;
        }
    }
}