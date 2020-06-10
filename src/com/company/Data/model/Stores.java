package com.company.Data.model;

import com.company.Datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Stores {
    private Datasource datasource=new Datasource();
    public static final String TABLE_STORES="stores";

    public static final String COLUMN_STORES_OPENING_HOUR = "OperatingHours";
    public static final String COLUMN_STORES_ID = "ID";
    public static final String COLUMN_STORES_PHONE = "Phone";
    public static final String COLUMN_STORES_SIZE = "Size";
    public static final String COLUMN_STORES_STREET = "Street";
    public static final String COLUMN_STORES_NUMBER = "Number";
    public static final String COLUMN_STORES_POSTAL_CODE = "PostalCode";
    public static final String COLUMN_STORES_CITY = "City";

    public static int idCopy;

    public static final String INSERT_INTO_STORES="INSERT INTO "+TABLE_STORES+
            "("+COLUMN_STORES_CITY+" , "+COLUMN_STORES_STREET+" , "+COLUMN_STORES_NUMBER+" , "+
            COLUMN_STORES_POSTAL_CODE+" , "+ COLUMN_STORES_SIZE+" , "+COLUMN_STORES_PHONE+" , "+
            COLUMN_STORES_OPENING_HOUR+") VALUES(?,?,?,?,?,?,?)";
    
    public static final String DELETE_FROM_STORES="DELETE FROM "+TABLE_STORES+
            " WHERE "+COLUMN_STORES_ID+" =?";
    
    public static final String UPDATE_STORES="UPDATE "+TABLE_STORES+
            " SET "+
            COLUMN_STORES_CITY+" =?"+" , "+
            COLUMN_STORES_STREET+" =?"+" , "+
            COLUMN_STORES_NUMBER+" =?"+" , "+
            COLUMN_STORES_POSTAL_CODE+" =?"+" , "+
            COLUMN_STORES_SIZE+" =?"+" , "+
            COLUMN_STORES_PHONE+" =?"+" , "+
            COLUMN_STORES_OPENING_HOUR+" =?"+
            " WHERE "+COLUMN_STORES_ID+" =?";
    
    public static final String GET_ALL_STORES="SELECT * "+" FROM "+TABLE_STORES;
    
    public static final String GET_STORES_BY_ID="SELECT * "+" FROM "+TABLE_STORES +" where "+COLUMN_STORES_ID+" =?";



    private int id;
    private String oppeningHour;
    private String phone;
    private  int size;
    private  String street;
    private  String number;
    private  int postalCode;
    private   String city;
    public Stores(){}
    public Stores(int id,String city,String street,String number,int postalCode,int size,String phone,String openningHour) {
        this.id=id;
    	this.oppeningHour = openningHour;
        this.phone = phone;
        this.size = size;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }
    public Stores(String city,String street,String number,int postalCode,int size,String phone,String openningHour ) {
        this.oppeningHour = openningHour;
        this.phone = phone;
        this.size = size;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOppeningHour() {
        return oppeningHour;
    }

    public void setOppeningHour(String oppeningHour) {
        this.oppeningHour = oppeningHour;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString(){
        return "stores: "+
                " id= "+getId()+
                " oppening hour= "+getOppeningHour()+
                " phone= "+getPhone()+
                " size= "+getSize()+
                " address "+getStreet()+
                " number "+getNumber()+
                " postal code "+getPostalCode()+
                " city "+getCity();
    }
    public boolean insertStores(String city,String street,String number,int postalCode,int size,String phone,String openningHour){
        try{
        	datasource.open();
        	datasource.instertIntoStores.setString(1,city);
    		datasource.instertIntoStores.setString(2,street);
    		datasource.instertIntoStores.setString(3,number);
    		datasource.instertIntoStores.setInt(4,postalCode);
    		datasource.instertIntoStores.setInt(5,size);
    		datasource.instertIntoStores.setString(6,phone);
    		datasource.instertIntoStores.setString(7,openningHour);
            datasource.instertIntoStores.executeUpdate();
            return true;
        }
      
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        finally {
        	datasource.close();
        }
    }
    
    public void updateStores(int id,String city,String street,String number,int postalCode,int size,String phone,String openningHour){
    	try {
    		datasource.open();
    		datasource.updateStore.setString(1,city);
    		datasource.updateStore.setString(2,street);
    		datasource.updateStore.setString(3,number);
    		datasource.updateStore.setInt(4,postalCode);
    		datasource.updateStore.setInt(5,size);
    		datasource.updateStore.setString(6,phone);
    		datasource.updateStore.setString(7,openningHour);
    		datasource.updateStore.setInt(8,id);
    		int affectedRows=datasource.updateStore.executeUpdate();
    		if(affectedRows==1) {
    			datasource.connection.commit();
    		}
    		else {
                throw new SQLException("The store update failed");

    		}
    	 }catch (Exception e){
             System.out.println("update store exception "+ e.getMessage());
             e.printStackTrace();
             try{
                 System.out.println("Perforing rollback");
                 datasource.connection.rollback();
             }catch (SQLException e1){
                 System.out.println("oh boy! things are rly bad "+e1.getMessage());
                 e1.printStackTrace();
             }

         }finally {
             try{
                 System.out.println("Reseting default comit behavior");
                 datasource.close();
                 datasource.connection.setAutoCommit(true);
             }catch (SQLException e){
                 System.out.println("Could not reset autocomit "+e.getMessage());
             }  finally {
             	datasource.close();
             }
         }
    }
    
    public void deleteStores(Integer id) {
    	try {
    		datasource.open();
    		datasource.deleteStore.setInt(1,id);
    		int affectedRows=datasource.deleteStore.executeUpdate();
    		if(affectedRows==1) {
    			datasource.connection.commit();
    		}
    		else {
                throw new SQLException("The store delete failed");

    		}
    	 }catch (Exception e){
             System.out.println("delete  exception "+ e.getMessage());
             e.printStackTrace();
             try{
                 System.out.println("Perforing rollback");
                 datasource.connection.rollback();
             }catch (SQLException e1){
                 System.out.println("oh boy! things are rly bad "+e1.getMessage());
                 e1.printStackTrace();
             }

         }finally {
             try{
                 System.out.println("Reseting default comit behavior");
                 datasource.connection.setAutoCommit(true);
             }catch (SQLException e){
                 System.out.println("Could not reset autocomit "+e.getMessage());
             }  finally {
             	datasource.close();
             }
         }
    }
    
    public List<Stores> getAllStores(){
    	try {
    		datasource.open();
    		ResultSet resultSet=datasource.getStores.executeQuery();
    		List<Stores> Stores=new ArrayList<>();
    		while(resultSet.next()) {
    			Stores store=new Stores(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8));
    			Stores.add(store);
    			System.out.print(store.toString());
    		}
    		return Stores;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    	finally {
                datasource.close();
        	
        }
}
    public Stores getStoreById(int id){
    	try {
    		datasource.open();
    		datasource.getStoresById.setInt(1, id);
    		ResultSet resultSet=datasource.getStoresById.executeQuery();
    		resultSet.next();
    		Stores store=new Stores(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
    				resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8));
    		return store;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    	finally {
                datasource.close();
        	
        }
}
}
