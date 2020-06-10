package com.company.Data.model;

import com.company.Datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OlderPrices {
    private Datasource datasource=new Datasource();

    public static final String  TABLE_OLDER_PRICES="olderPrices";

    public static final String COLUMN_PRICES_ID="ID";
    public static final String COLUMN_PRICES_PRODUCT="Productid";
    public static final String COLUMN_PRICES_START_DATE="StartDate";
    public static final String COLUMN_PRICES_END_DATE="EndDate";
    public static final String COLUMN_PRICES_PRICE="Price";

    public static final String INSERT_INTO_OLDER_PRICES="INSERT INTO "+TABLE_OLDER_PRICES+
            "("+COLUMN_PRICES_PRODUCT+" , "+COLUMN_PRICES_START_DATE+" , "+COLUMN_PRICES_END_DATE+" , "+COLUMN_PRICES_PRICE+
            ") VALUES(?,?,?,?)";
    
    public static final String GET_ALL_FROM_OLDER_PRICES="SELECT *  FROM "+ TABLE_OLDER_PRICES;

    private int id;
    private int product;
    private String StartDate;
    private String endDate;
    private double price;

    public OlderPrices() {}
    public OlderPrices(int id, int product, String startDate, String endDate, double price) {
        this.id = id;
        this.product = product;
        this.StartDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }
    public OlderPrices( int product, String startDate, String endDate, double price) {
        this.product = product;
        this.StartDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean insertOlderPrices(int product,String startDate,String endDate,double price){
        try{
        	datasource.open();
            datasource.insertIntoOlderPrices.setInt(1,product);
            datasource.insertIntoOlderPrices.setString(2,startDate);
            datasource.insertIntoOlderPrices.setString(3,endDate);
            datasource.insertIntoOlderPrices.setDouble(4,price);
            datasource.insertIntoOlderPrices.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        finally {
                datasource.close();
        	
        }
    }
    
    public List<OlderPrices> getOlderPrices(){
    	try {
    		datasource.open();
    		ResultSet resultSet=datasource.getOlderPrices.executeQuery();
    		List<OlderPrices> olderPrices=new ArrayList<OlderPrices>();
    		while(resultSet.next()) {
    			OlderPrices olderPrice=new OlderPrices(resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5));
    			olderPrices.add(olderPrice);
    		}
    		return olderPrices;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    	finally {
    		datasource.close();
    	}
    }
}
