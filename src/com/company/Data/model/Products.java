package com.company.Data.model;

import com.company.Datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Products {
    private Datasource datasource=new Datasource();

    public static final String TABLE_PRODUCTS="products";

    public static final String COLUMN_PRODUCTS_ID = "ID";
    public static final String COLUMN_PRODUCTS_NAME = "Name";
    public static final String COLUMN_PRODUCTS_PRICE = "Price";
    public static final String COLUMN_PRODUCTS_BRAND_NAME = "BrandName";
    public static final String COLUMN_PRODUCTS_CATEGORY = "Categoryid";

    public static final String INSERT_INTO_PRODUCTS="INSERT INTO "+TABLE_PRODUCTS+
            "("+COLUMN_PRODUCTS_NAME+" , "+COLUMN_PRODUCTS_BRAND_NAME+" , "+COLUMN_PRODUCTS_PRICE+" , "+COLUMN_PRODUCTS_CATEGORY+
            ") VALUES(?,?,?,?)";
    
    
    public static int idCopy;

    public static final String UPDATE_PRODUCT="UPDATE "+ TABLE_PRODUCTS +  
    		" SET "+
    		COLUMN_PRODUCTS_NAME+" =? "+ " , "+
    		COLUMN_PRODUCTS_PRICE+" =? "+ " , "+
    		COLUMN_PRODUCTS_BRAND_NAME+" =? "+ " , "+
    		COLUMN_PRODUCTS_CATEGORY+" =? "+
    		"WHERE "+COLUMN_PRODUCTS_ID+" =?";
    
    public static final String UPDATE_PRODUCT_PRICE="UPDATE "+ TABLE_PRODUCTS +  
    		" SET "+    		
    		COLUMN_PRODUCTS_PRICE+" =? "+
    		"WHERE "+COLUMN_PRODUCTS_ID+" =?";

    
    public static final String DELETE_PRODUCT="DELETE FROM "+TABLE_PRODUCTS+
            " WHERE "+TABLE_PRODUCTS+"."+COLUMN_PRODUCTS_ID+" =?";
    
    public static final String GET_ALL_PRODUCTS="SELECT * "+" FROM "+TABLE_PRODUCTS;
    
    public static final String GET_PRODUCTS_BY_ID="SELECT * "+" FROM "+TABLE_PRODUCTS +" where "+COLUMN_PRODUCTS_ID+" =?";
    
    public static final String GET_PRODUCTS_ID="SELECT  "+COLUMN_PRODUCTS_ID+" FROM "+TABLE_PRODUCTS +" where "+COLUMN_PRODUCTS_NAME+" =?"+
    		" and "+COLUMN_PRODUCTS_PRICE+" =?"+" and "+COLUMN_PRODUCTS_BRAND_NAME+" =?"+" and "+COLUMN_PRODUCTS_CATEGORY+" =?";


    private int id;
    private String name;
    private double price;
    private String brandName;
    private int category;
    
    
    public Products(){}

    public Products(String name,double price,String brandName,int category){
        this.name=name;
        this.price=price;
        this.brandName=brandName;
        this.category=category;
    }
    public Products(int id,String name,double price,String brandName,int category){
    	this.id=id;
        this.name=name;
        this.price=price;
        this.brandName=brandName;
        this.category=category;
    }

    public int getIdCopy() {
        return id;
    }

    public void setIdCopy(int id) {
        this.idCopy = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean insertProducts(String name,String brandName,Double price,Integer category){
        try {
        	datasource.open();
        	System.out.println(name);
        	System.out.println(brandName);
        	System.out.println(price);
        	System.out.println(category);
        	System.out.println(INSERT_INTO_PRODUCTS);
            datasource.insertIntoProducts.setString(1,name);
            datasource.insertIntoProducts.setString(2,brandName);
            datasource.insertIntoProducts.setDouble(3,price);
            datasource.insertIntoProducts.setInt(4,category);
    		int affectedRows=datasource.insertIntoProducts.executeUpdate();
    		if(affectedRows!=1) {
                throw new SQLException("The product insert failed");
    		}
    		else return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }catch(NullPointerException e) {
        	System.out.println("name= "+name);
        	System.out.println(brandName);
        	System.out.println(price);
        	System.out.println(category);
        	e.printStackTrace();
        	return false;
        }
        finally {
                datasource.close();
        	
        }
       
    }
    
    public void updateProduct(int id,String name,double price,String brandName,int category){
    	try {
    		datasource.open();
    		System.out.println("name= "+name);
    		System.out.println("brandname= "+brandName);
    		System.out.println("price= "+price);
    		System.out.println("category= "+category);
    		System.out.println("id= "+id);
    		datasource.updateProduct.setString(1,name);
    		datasource.updateProduct.setDouble(2,price);
    		datasource.updateProduct.setString(3,brandName);
    		datasource.updateProduct.setInt(4,category);
    		datasource.updateProduct.setInt(5,id);
    		int affectedRows=datasource.updateProduct.executeUpdate();
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
            	 datasource.close();
                 System.out.println("Reseting default comit behavior");
                 datasource.connection.setAutoCommit(true);
             }catch (SQLException e){
                 System.out.println("Could not reset autocomit "+e.getMessage());
             }
         }
    }
    
    public void updateProductPrice(int id,double price){
    	try {
    		datasource.open();
    		datasource.updateProductPrice.setDouble(1,price);
    		datasource.updateProductPrice.setInt(2,id);
    		int affectedRows=datasource.updateProductPrice.executeUpdate();
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
            	 datasource.close();
                 System.out.println("Reseting default comit behavior");
                 datasource.connection.setAutoCommit(true);
             }catch (SQLException e){
                 System.out.println("Could not reset autocomit "+e.getMessage());
             }
         }
    }
    
    public void deleteProduct(Integer id) {
    	try {
    		datasource.open();
    		datasource.deleteProduct.setInt(1,id);
    		int affectedRows=datasource.deleteProduct.executeUpdate();
    		if(affectedRows==1) {
    			datasource.connection.commit();
    		}
    		else {
                throw new SQLException("The customer delete failed");

    		}
    	 }catch (Exception e){
             System.out.println("delete product exception "+ e.getMessage());
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
            	 datasource.close();
                 System.out.println("Reseting default comit behavior");
                 datasource.connection.setAutoCommit(true);
             }catch (SQLException e){
                 System.out.println("Could not reset autocomit "+e.getMessage());
             }
         }
    }
    
    public List<Products> getAllProducts(){
    	try {
    		datasource.open();
    		ResultSet resultSet=datasource.getProducts.executeQuery();
    		List<Products> products=new ArrayList<>();
    		while(resultSet.next()) {
    			Products product=new Products(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(4),resultSet.getString(3),resultSet.getInt(5));
    			products.add(product);
    			System.out.print(product.toString());
    		}
    		return products;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    	finally {
                datasource.close();
        	
        }
}
    public Products getProductById(int id){
    	try {
    		datasource.open();
    		datasource.getProductsById.setInt(1, id);
    		ResultSet resultSet=datasource.getProductsById.executeQuery();
    		resultSet.next();
    		Products product=new Products(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(4),resultSet.getString(3),resultSet.getInt(5));
    		return product;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    	finally {
                datasource.close();
        	
        }
}
    public int getProductId(String name,double price,String brandName,int category) {
    	try {
    		datasource.open();
    		datasource.getProductId.setString(1,name);
    		datasource.getProductId.setDouble(2,price);
    		datasource.getProductId.setString(3,brandName);
    		datasource.getProductId.setInt(4,category);
    		ResultSet resultSet=datasource.getProductId.executeQuery();
    		 resultSet.next();
    		 int id=(int) resultSet.getInt(1);
    		return id;

    	}catch(SQLException e) {
    		e.printStackTrace();
    		return -1;
    	}
    	finally {
    		datasource.close();
    	}
    }
}
