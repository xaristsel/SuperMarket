package com.company.Data;

public class TransactionsPerWeek {
    public int week;
    private int count;
    private double sum;
    private double avg;

    public TransactionsPerWeek(int week, int count, double sum, double avg) {
        this.week = week;
        this.count = count;
        this.sum = sum;
        this.avg = avg;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "TransactionsPerWeek{" +
                "week=" + week +
                ", count=" + count +
                ", sum=" + sum +
                ", avg=" + avg +
                '}';
    }
}
