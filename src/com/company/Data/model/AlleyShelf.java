package com.company.Data.model;

import com.company.Datasource;
import java.sql.SQLException;

public class AlleyShelf {
    private Datasource datasource=new Datasource();

    public static final String TABLE_ALLEY_SHELF="AlleyShelf";

    public static final String COLUMN_ALLEY_SHELF_STORE="Storeid";
    public static final String COLUMN_ALLEY_SHELF_PRODUCT="Productid";
    public static final String COLUMN_ALLEY_SHELF_ALLEY="alley";
    public static final String COLUMN_ALLEY_SHELF_SHELF="shelf";

    public static final String INSERT_INTO_ALLEY_SHELF="INSERT INTO "+TABLE_ALLEY_SHELF+
            "("+COLUMN_ALLEY_SHELF_STORE+" , "+COLUMN_ALLEY_SHELF_PRODUCT+" , "+COLUMN_ALLEY_SHELF_ALLEY+" , "+
            COLUMN_ALLEY_SHELF_SHELF+") VALUES(?,?,?,?)";

    private  int store;
    private int product;
    private int alley;
    private int shelf;

    public AlleyShelf(){}
    public AlleyShelf(int store, int product, int alley, int shelf) {
        this.store = store;
        this.product = product;
        this.alley = alley;
        this.shelf = shelf;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getAlley() {
        return alley;
    }

    public void setAlley(int alley) {
        this.alley = alley;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public boolean insertAlleyShelf(int store,int product,int alley,int shelf){
        try {
        	datasource.open();
            datasource.insertIntoAlleyShelf.setInt(1,store);
            datasource.insertIntoAlleyShelf.setInt(2,product);
            datasource.insertIntoAlleyShelf.setInt(4,alley);
            datasource.insertIntoAlleyShelf.setInt(5,shelf);
            datasource.insertIntoAlleyShelf.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    	finally{
    		datasource.close();
    		
    	}
    }
}
