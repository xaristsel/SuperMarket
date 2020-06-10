package com.company.Data;

public class A1 {
        private int id;
        private double totalAmount;
        private int totalPieces;
        private int store;
        private int customer;
        private String paymentMethod;
        private String date;
        private String time;

        public A1(int id, double totalAmount, int totalPieces, int store, int customer, String paymentMethod, String date,String time) {
            this.id = id;
            this.totalAmount = totalAmount;
            this.totalPieces = totalPieces;
            this.store = store;
            this.customer = customer;
            this.paymentMethod = paymentMethod;
            this.date = date;
            this.time=time;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public int getTotalPieces() {
            return totalPieces;
        }

        public void setTotalPieces(int totalPieces) {
            this.totalPieces = totalPieces;
        }

        public int getStore() {
            return store;
        }

        public void setStore(int store) {
            this.store = store;
        }

        public int getCustomer() {
            return customer;
        }

        public void setCustomer(int customer) {
            this.customer = customer;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
        public String toString() {
            return "A1{" +
                    "id=" + id +
                    ", totalAmount=" + totalAmount +
                    ", totalPieces=" + totalPieces +
                    ", store=" + store +
                    ", customer=" + customer +
                    ", paymentMethod='" + paymentMethod + '\'' +
                    ", date='" + date + '\'' +
                    ", time= "+time+
                    '}';
        }
    }

