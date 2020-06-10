package com.company.Data;

public class BestPair {
    private int id1;
    private int id2;

    public BestPair(int id1, int id2) {
       this.id1=id1;
       this.id2=id2;
    }
    public int getId1() {
        return id1;
    }
    public void setId1(int id1) {
        this.id1 = id1;
    }
    public int getid2() {
        return id2;
    }
    public void setName(int id2) {
        this.id2 = id2;
    }

    @Override
    public String toString() {
        return "BestProducts{" +
                "id1=" + id1 +
                ", id2='" + id2 +
                '}';
    }
}
