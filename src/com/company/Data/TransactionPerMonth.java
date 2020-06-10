package com.company.Data;

public class TransactionPerMonth {
    private  String monthDate;
    private  int count;
    private int totalAmount;
    private double AverageAmount;

    public TransactionPerMonth(String monthDate, int count, int totalAmount, double averageAmount) {
        this.monthDate = monthDate;
        this.count = count;
        this.totalAmount = totalAmount;
        AverageAmount = averageAmount;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAverageAmount() {
        return AverageAmount;
    }

    public void setAverageAmount(double averageAmount) {
        AverageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "TransactionPerMonth{" +
                "monthDate='" + monthDate + '\'' +
                ", count=" + count +
                ", totalAmount=" + totalAmount +
                ", AverageAmount=" + AverageAmount +
                '}';
    }


}
