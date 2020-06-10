package com.company.Data;

import java.util.Objects;

public class CountAlleyShelf implements Comparable<CountAlleyShelf>,EqualsAndHashcode {
    private int id1;
    private int id2;
    public int count;

    public CountAlleyShelf(int id1, int id2, int count) {
        this.id1 = id1;
        this.id2 = id2;
        this.count = count;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(CountAlleyShelf countAlleyShelf) {
        if (this == countAlleyShelf) return true;
        if(this.id1==countAlleyShelf.id1 && this.id2==countAlleyShelf.id2) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2, count);
    }

    @Override
    public int compareTo(CountAlleyShelf countAlleyShelf){
        if(this.count>countAlleyShelf.count){
            return 1;
        }
        else if(this.count<countAlleyShelf.count){
            return -1;
        }
        else return 0;
    }
}
