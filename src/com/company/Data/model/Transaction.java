package com.company.Data.model;

import com.company.Data.BestPair;
import com.company.Data.CountAlleyShelf;
import com.company.Datasource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Datasource datasource=new Datasource();
    public static AlleyShelf alleyShelf=new AlleyShelf();
    public static Transactions transactions=new Transactions();
    public static Products products=new Products();
    public static Category category=new Category();
    public static final String TABLE_TRANSACTION="Transaction1";

    public static final String COLUMN_TRANSACTION_ID="ID";
    public static final String COLUMN_TRANSACTION_TRANSACTION="Transactionid";
    public static final String COLUMN_TRANSACTION_PRODUCT="Productid";
    public static final String COLUMN_TRANSACTION_PRICE="Price";

    public static final String INSERT_INTO_TRANSACTION="INSERT INTO "+TABLE_TRANSACTION+
            "("+COLUMN_TRANSACTION_TRANSACTION+" , "+COLUMN_TRANSACTION_PRODUCT+" , "+COLUMN_TRANSACTION_PRICE+
            ") VALUES(?,?,?)";

    public static final String COUNT_ALLEY_SHELF_PER_STORE=" SELECT "+alleyShelf.TABLE_ALLEY_SHELF+"."+alleyShelf.COLUMN_ALLEY_SHELF_ALLEY+" , "+alleyShelf.TABLE_ALLEY_SHELF+"."+alleyShelf.COLUMN_ALLEY_SHELF_SHELF+
            " FROM "+TABLE_TRANSACTION+
            " INNER JOIN "+transactions.TABLE_TRANSACTIONS+" ON "+TABLE_TRANSACTION+"."+COLUMN_TRANSACTION_TRANSACTION+" = "+transactions.TABLE_TRANSACTIONS+"."+transactions.COLUMN_TRANSACTIONS_ID+
            " INNER JOIN "+products.TABLE_PRODUCTS+" ON "+TABLE_TRANSACTION+"."+COLUMN_TRANSACTION_PRODUCT+" = "+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
            " INNER JOIN "+alleyShelf.TABLE_ALLEY_SHELF+" ON "+alleyShelf.TABLE_ALLEY_SHELF+"."+alleyShelf.COLUMN_ALLEY_SHELF_PRODUCT+" = "+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
    		" WHERE "+transactions.TABLE_TRANSACTIONS+"."+transactions.COLUMN_TRANSACTIONS_STORE+" =?"+
    		" GROUP BY "+TABLE_TRANSACTION+"."+COLUMN_TRANSACTION_PRODUCT+
    		" ORDER BY COUNT( "+TABLE_TRANSACTION+"."+COLUMN_TRANSACTION_PRODUCT+" ) DESC";
    
    public static final String getProductsPair="SELECT [1st]."+COLUMN_TRANSACTION_PRODUCT+", [2nd]. "+COLUMN_TRANSACTION_PRODUCT+
            ", count([1st]."+COLUMN_TRANSACTION_PRODUCT+")"+
            " FROM "+
            "(SELECT * FROM "+ TABLE_TRANSACTION+
            " WHERE "+TABLE_TRANSACTION+"."+COLUMN_TRANSACTION_TRANSACTION+" != '' "+
            ") [1st] "+
            " INNER JOIN "+
            "("+
            " SELECT * "+
            " FROM "+TABLE_TRANSACTION+
            " WHERE "+ TABLE_TRANSACTION+"."+COLUMN_TRANSACTION_TRANSACTION+" != '' "
            +") [2nd]"+
            " ON [1st]."+COLUMN_TRANSACTION_TRANSACTION+" = [2nd]. "+COLUMN_TRANSACTION_TRANSACTION+
            " WHERE [1st]. "+COLUMN_TRANSACTION_PRODUCT+" < [2nd]. "+COLUMN_TRANSACTION_PRODUCT+
            " GROUP BY [1st]. "+COLUMN_TRANSACTION_PRODUCT+", [2nd]. "+COLUMN_TRANSACTION_PRODUCT+
            " ORDER BY count([1st]. "+COLUMN_TRANSACTION_PRODUCT+") DESC LIMIT 10 ";

    public static final String getProductsByBrandName="SELECT  "+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_BRAND_NAME +" , "+ products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
            " FROM "+TABLE_TRANSACTION+
            " INNER JOIN "+products.TABLE_PRODUCTS+ " ON "+TABLE_TRANSACTION+"."+COLUMN_TRANSACTION_PRODUCT+" = "+ products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
            " INNER JOIN "+category.TABLE_CATEGORY+ " ON "+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_CATEGORY+"="+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_ID+
            " WHERE "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_ID+" =?";

    private int transaction;
    private int  product;
    private int id;
    private double price;
    public Transaction(){}
    public Transaction(int id,int transaction, int product,double price) {
        this.transaction = transaction;
        this.product = product;
        this.id=id;
        this.price=price;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean insertTransaction(int transaction, int product){
        try{
            datasource.insertIntoTransaction.setInt(1,transaction);
            datasource.insertIntoTransaction.setInt(2,product);
            datasource.insertIntoTransaction.setDouble(3,price);
            datasource.insertIntoTransaction.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        finally {
                datasource.close();
        	
        }
    }

    public List<BestPair> getAllPairs(){
        try{
            datasource.open();
            ResultSet resultSet=datasource.getProductionPairs.executeQuery();
            List<BestPair> bestProducts =new ArrayList<>();
            while(resultSet.next()){
                BestPair bestProduct =new BestPair(resultSet.getInt(1),resultSet.getInt(2));
                bestProducts.add(bestProduct);
            }
            return bestProducts;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        finally {
                datasource.close();
    }
    }

    public double getProductsBrandNamePerCategory(int id) {
        try {
            datasource.open();
            datasource.getProductsByBrandNamePerCategory.setInt(1, id);
            ResultSet resultSet = datasource.getProductsByBrandNamePerCategory.executeQuery();
            List<String> strings = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();
            double counter = 0;
            while (resultSet.next()) {
                strings.add(resultSet.getString(1));
                ids.add(resultSet.getInt(2));
            }
            for (int i = 0; i < strings.size(); i++) {
                if (strings.get(i).equals("YES")) {
                    counter++;
                }
            }
            double d = strings.size();
            if (strings.size() != 0) {
                double value = counter / d;
                return value;
            } else {
                return 0.0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return 0.0;
        }
        finally {
                datasource.close();
        	
        }
    }
        public List<CountAlleyShelf> getAlleyShelf(int id){
            try{
                datasource.open();
                datasource.getStoresAlleys.setInt(1, id);
                ResultSet resultSet=datasource.getStoresAlleys.executeQuery();
                List<CountAlleyShelf> counter=new ArrayList<>();
                boolean flag=false;
                int counter1=0;
                while (resultSet.next()){
                    counter1++;
                    flag=false;
                    CountAlleyShelf countAlleyShelf=new CountAlleyShelf(resultSet.getInt(1),resultSet.getInt(2),1);
                    for(int i=0;i<counter.size();i++){
                        if(counter.get(i).equals(countAlleyShelf)){
                            counter.get(i).setCount(counter.get(i).getCount()+1);
                            flag=true;
                        }
                    }
                    if(flag==false){
                        counter.add(countAlleyShelf);
                    }
            }
                return counter;
        }catch (SQLException e){
                e.printStackTrace();
                return null;
        }finally {
                datasource.close();
        
        }

    }


}
