package com.company.Data.model;

import com.company.Datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customers {
    private Datasource datasource=new Datasource();
    public static final String TABLE_CUSTOMER="customers";
    public static final String COLUMN_CUSTOMER_ID = "ID";
    public static final String COLUMN_CUSTOMER_NAME = "Name";
    public static final String COLUMN_CUSTOMER_DATE_OF_BIRTH = "BirthDate";
    public static final String COLUMN_CUSTOMER_POINTS = "Points";
    public static final String COLUMN_CUSTOMER_STREET = "Street";
    public static final String COLUMN_CUSTOMER_NUMBER = "Number";
    public static final String COLUMN_CUSTOMER_POSTAL_CODE = "PostalCode";
    public static final String COLUMN_CUSTOMER_CITY = "City";
    public static final String COLUMN_CUSTOMER_FAMILY_MEMBERS = "FamilyMembers";
    public static final String COLUMN_CUSTOMER_PET = "Pet";
    public static final String COLUMN_CUSTOMER_CARD = "Card";
    public static final String COLUMN_CUSTOMER_AGE = "Age";
    public static final String COLUMN_CUSTOMER_PHONE = "Phone";
    
    public static int idCopy;


    public static final String INSERT_INTO_CUSTOMERS="INSERT INTO "+TABLE_CUSTOMER+
            "("+ COLUMN_CUSTOMER_NAME+" , "+COLUMN_CUSTOMER_DATE_OF_BIRTH+ " , "+
            COLUMN_CUSTOMER_POINTS+ " , "+COLUMN_CUSTOMER_STREET+ " , "+COLUMN_CUSTOMER_NUMBER+" , "+COLUMN_CUSTOMER_POSTAL_CODE+
            " , "+COLUMN_CUSTOMER_CITY+" , "+COLUMN_CUSTOMER_FAMILY_MEMBERS+" , "+COLUMN_CUSTOMER_PET+" , "+COLUMN_CUSTOMER_CARD+" , "+COLUMN_CUSTOMER_AGE+" , "+
            COLUMN_CUSTOMER_PHONE+") VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public static final String DELETE_FROM_CUSTOMERS="DELETE FROM "+TABLE_CUSTOMER+
            " WHERE "+TABLE_CUSTOMER+"."+COLUMN_CUSTOMER_ID+" =?";
    
    public static final String UPDATE_CUSTOMER="UPDATE " +TABLE_CUSTOMER+
            " SET "+
            COLUMN_CUSTOMER_NAME+" =?"+ " , "+
            COLUMN_CUSTOMER_DATE_OF_BIRTH+" =?"+ " , "+
            COLUMN_CUSTOMER_POINTS+" =?"+ " , "+
            COLUMN_CUSTOMER_STREET+" =?"+ " , "+
            COLUMN_CUSTOMER_NUMBER+" =?"+ " , "+
            COLUMN_CUSTOMER_POSTAL_CODE+" =?"+ " , "+
            COLUMN_CUSTOMER_CITY+" =?"+ " , "+
            COLUMN_CUSTOMER_FAMILY_MEMBERS+" =?"+ " , "+
            COLUMN_CUSTOMER_PET+" =?"+ " , "+
            COLUMN_CUSTOMER_CARD+" =?"+ " , "+
            COLUMN_CUSTOMER_AGE+" =?"+ " , "+
            COLUMN_CUSTOMER_PHONE+" =?"+ 
            " WHERE "+COLUMN_CUSTOMER_ID+" =?";
    

    public static final String GET_ALL_CUSTOMERS="SELECT * "+" FROM "+TABLE_CUSTOMER;


    public static final String b1="SELECT "+TABLE_CUSTOMER+"."+"* "+" FROM "+TABLE_CUSTOMER+
            " WHERE "+TABLE_CUSTOMER+"."+COLUMN_CUSTOMER_ID+" =?";
    
    private int id;
    private String name;
    private String birthDay;
    private int points;
    private String street;
    private String number;
    private int postalCode;
    private String city;
    private int familyMember;
    private int pet;
    private String card;
    private int age;
    private String Phone;

    public Customers(){}
    public Customers(int id, String name, String birthDay, int points, String street, String number, int postalCode, String city, int familyMember, 
    		int pet, String card, int age, String phone) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.points = points;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
        this.familyMember = familyMember;
        this.pet = pet;
        this.card = card;
        this.age = age;
        this.Phone = phone;
    }
    public Customers(String name, String birthDay, int points, String street, String number, int postalCode, String city, int familyMember,
    		int pet, String card, int age, String phone) {
        this.name = name;
        this.birthDay = birthDay;
        this.points = points;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
        this.familyMember = familyMember;
        this.pet = pet;
        this.card = card;
        this.age = age;
       this.Phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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

    public int getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(int familyMember) {
        this.familyMember = familyMember;
    }

    public int getPet() {
        return pet;
    }

    public void setPet(int pet) {
        this.pet = pet;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", points=" + points +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", familyMember=" + familyMember +
                ", pet=" + pet +
                ", card='" + card + '\'' +
                ", age=" + age +
                ", Phone='" + Phone + '\'' +
                '}';
    }
    public void insertCustomers(String name, String birthDay, int points, String street, String number, int postalCode, String city, int familyMember,
    		int pet, String card, int age, String phone){
        try {
        
        	datasource.open();
            datasource.insertIntoCustomers.setString(1, name);
            datasource.insertIntoCustomers.setString(2, birthDay);
            datasource.insertIntoCustomers.setInt(3, points);
            datasource.insertIntoCustomers.setString(4, street);
            datasource.insertIntoCustomers.setString(5, number);
            datasource.insertIntoCustomers.setInt(6, postalCode);
            datasource.insertIntoCustomers.setString(7, city);
            datasource.insertIntoCustomers.setInt(8, familyMember);
            datasource.insertIntoCustomers.setInt(9, pet);
            datasource.insertIntoCustomers.setString(10, card);
            datasource.insertIntoCustomers.setInt(11, age);
            datasource.insertIntoCustomers.setString(12, phone);
            datasource.insertIntoCustomers.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
        	datasource.close();
        }
    }
    
    public void updateCustomers(int id,String name, String birthDay, int points, String street, String number, int postalCode, String city, int familyMember,
    		int pet, String card, int age, String phone){
    	try {
    		datasource.open();
    		

    		datasource.updateCustomer.setString(1,name);
    		datasource.updateCustomer.setString(2,birthDay);
    		datasource.updateCustomer.setInt(3,points);
    		datasource.updateCustomer.setString(4,street);
    		datasource.updateCustomer.setString(5,number);
    		datasource.updateCustomer.setInt(6,postalCode);
    		datasource.updateCustomer.setString(7,city);
    		datasource.updateCustomer.setInt(8,familyMember);
    		datasource.updateCustomer.setInt(9,pet);
    		datasource.updateCustomer.setString(10,card);
    		datasource.updateCustomer.setInt(11,age);
    		datasource.updateCustomer.setString(12,phone);
    		datasource.updateCustomer.setInt(13,id);
    		int affectedRows=datasource.updateCustomer.executeUpdate();
    		if(affectedRows==1) {
    			datasource.connection.commit();
    		}
    		else {
                throw new SQLException("The customer update failed");

    		}
    	 }catch (Exception e){
             System.out.println("update customer exception "+ e.getMessage());
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
             }finally {
            	 datasource.close();
             }
             }
         }
    
    public void deleteCustomers(int id) {
    	try {
    		
    		datasource.open();
    		datasource.deleteCustomer.setInt(1,id);
    		int affectedRows=datasource.deleteCustomer.executeUpdate();
    		if(affectedRows==1) {
    			datasource.connection.commit();
    		}
    		else {
                throw new SQLException("The customer delete failed");

    		}
    	 }catch (Exception e){
             System.out.println("delete customer exception "+ e.getMessage());
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
             }finally {
            	 datasource.close();
             }
             }
         }
    
    
    public List<Customers> getAllProducts(){
    	try {
    		datasource.open();
    		ResultSet resultSet=datasource.getCustomers.executeQuery();
    		List<Customers> Customers=new ArrayList<>();
    		while(resultSet.next()) {
    			Customers customer=new Customers(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getString(11),resultSet.getInt(12),resultSet.getString(13));
    			Customers.add(customer);
    			System.out.print(customer.toString());
    		}
    		return Customers;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    	  finally {
          	datasource.close();
          }
    	
}
    
}
