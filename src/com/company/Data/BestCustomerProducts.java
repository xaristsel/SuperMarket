package com.company.Data;

public class BestCustomerProducts {
    private int transactionId;
    private String productName;
    private int count;

    public BestCustomerProducts(int transactionId, String productName, int count) {
        this.transactionId = transactionId;
        this.productName = productName;
        this.count = count;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BestCustomerProducts{" +
                "transactionId=" + transactionId +
                ", productName='" + productName + '\'' +
                ", count=" + count +
                '}';
    }
}
