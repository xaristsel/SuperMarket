package com.company.Data.model;

import com.company.Data.CountPerCategory;
import com.company.Data.RatioOfVisitsByAge;
import com.company.Data.TransactionsPerStore;
import com.company.Datasource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Transactions {
    public static int  time1=10*3600;
    public static int time2=11*3600;
    public static int time3=12*3600;
    public static int time4=13*3600;
    public static int time5=14*3600;
    public static int time6=15*3600;
    public static int time7=16*3600;
    public static int time8=17*3600;
    public static int time9=18*3600;
    public static int time10=19*3600;
    public static int time11=20*3600;
    public static int time12=21*3600;

    private int count1=0;
    private int count2=0;
    private int count3=0;
    private int count4=0;
    private int count5=0;
    private int count6=0;
    private int count7=0;
    private int count8=0;
    private int count9=0;
    private int count10=0;
    private int count11=0;
    private int count12=0;
    private Datasource datasource=new Datasource();
    public static Stores stores=new Stores();
    public static Customers customers=new Customers();
    public static Category category=new Category();
    public static Products products=new Products();
    public static Transaction transaction=new Transaction();
    public static final String TABLE_TRANSACTIONS="Transactions";

    public static final String COLUMN_TRANSACTIONS_ID="ID";
    public static final String COLUMN_TRANSACTIONS_TOTAL_AMOUNT="TotalAmount";
    public static final String COLUMN_TRANSACTIONS_TOTAL_PIECES="TotalPieces";
    public static final String COLUMN_TRANSACTIONS_STORE="Storeid";
    public static final String COLUMN_TRANSACTIONS_CUSTOMER="Customerid";
    public static final String COLUMN_TRANSACTIONS_PAYMENT_METHOD="PaymentMethod";
    public static final String COLUMN_TRANSACTIONS_DATE="Date";
    public static final String COLUMN_TRANSACTIONS_TIME="Time";

    public static final String INSERT_INTO_TRANSACTIONS="INSERT INTO "+TABLE_TRANSACTIONS+
            "("+COLUMN_TRANSACTIONS_TOTAL_AMOUNT+" , "+COLUMN_TRANSACTIONS_TOTAL_PIECES+" , "+COLUMN_TRANSACTIONS_STORE+" , "+
            COLUMN_TRANSACTIONS_CUSTOMER+" , "+COLUMN_TRANSACTIONS_PAYMENT_METHOD+" , "+COLUMN_TRANSACTIONS_DATE+" , "+COLUMN_TRANSACTIONS_TIME+
            ") VALUES(?,?,?,?,?,?,?)";

    public static final String a1="SELECT "+TABLE_TRANSACTIONS+"."+"*  "+
            " FROM "+TABLE_TRANSACTIONS+
            " INNER JOIN "+ transaction.TABLE_TRANSACTION+ " ON "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+"="+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_TRANSACTION+
            " INNER JOIN "+products.TABLE_PRODUCTS+" ON "+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+"="+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
            " WHERE "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE+" =?";

    public static final String  b2="SELECT * " +
            " FROM " +TABLE_TRANSACTIONS+
            " WHERE "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+" =?";

    public static final String b3="SELECT "+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_TRANSACTION+" , "+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_NAME+" , "+" COUNT "+" ( "+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+" ) "+
            " FROM "+TABLE_TRANSACTIONS+
            " INNER JOIN "+ transaction.TABLE_TRANSACTION + " ON "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+"="+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_TRANSACTION+
            " INNER JOIN "+ products.TABLE_PRODUCTS+ " ON "+ transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+"="+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
            " WHERE " + TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+" =?"+
            " GROUP BY "+ products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
            " ORDER BY "+ " COUNT "+ " ( "+ transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+" ) "+
            " DESC LIMIT 10 ";

    public static final String TRANSTACTIONS_FROM_A_STORE_WITH_DATE="SELECT * FROM "+ TABLE_TRANSACTIONS+
            " INNER JOIN " +stores.TABLE_STORES+ " ON " + stores.TABLE_STORES+"."+stores.COLUMN_STORES_ID+" = "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE
            +" WHERE "+stores.TABLE_STORES+"."+stores.COLUMN_STORES_ID+" = ? ";

    public static final String b4="SELECT "+stores.TABLE_STORES+"."+"* "+
            " FROM "+ TABLE_TRANSACTIONS+
            " INNER JOIN "+stores.TABLE_STORES+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE+"="+stores.TABLE_STORES+"."+stores.COLUMN_STORES_ID+
            " WHERE " +TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+" =?"+
            " ORDER BY "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE;

    public static final String b5="SELECT "+" COUNT" +" (DISTINCT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE+" ) "+
            " FROM "+TABLE_TRANSACTIONS+
            " WHERE "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+" =?";

    public static final String getTransactionsPerMonth= "SELECT STRFTIME('%Y-%m', date) AS 'month', COUNT( DISTINCT "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+" ) AS 'month_count'," +
            " SUM("+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_PRICE+ ") AS 'SUM'," +
            " (SUM("+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_PRICE+")/COUNT(DISTINCT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+")) " +
            " AS 'AVG'"+
            " FROM " +TABLE_TRANSACTIONS+
            " INNER JOIN "+transaction.TABLE_TRANSACTION+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+"="+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_TRANSACTION+
            "  INNER JOIN "+products.TABLE_PRODUCTS+" ON "+ transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+"="+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
            " WHERE "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+" =?"+
            " GROUP BY "+ "STRFTIME('%Y-%m', date)";

    public static final String getTransactionsPerWeek= "SELECT STRFTIME('%W', date) AS 'week', COUNT( DISTINCT "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+" ) AS 'week_count'," +
            " SUM("+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_PRICE+ ") AS 'SUM'," +
            " (SUM("+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_PRICE+")/COUNT(DISTINCT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+")) " +
            " AS 'AVG'"+
            " FROM " +TABLE_TRANSACTIONS+
            " INNER JOIN "+transaction.TABLE_TRANSACTION+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+"="+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_TRANSACTION+
            "  INNER JOIN "+products.TABLE_PRODUCTS+" ON "+ transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+"="+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
            " WHERE "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+" =?"+
            " GROUP BY "+ "STRFTIME('%W', date)";

    public static final String getAllTransactions="SELECT "+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+
            " FROM "+TABLE_TRANSACTIONS+
            " INNER JOIN "+ transaction.TABLE_TRANSACTION+ " ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+"="+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_TRANSACTION+
            " WHERE "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE+" =?";

    public static final String getVisitedTimes="SELECT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_TIME+
            " FROM  "+TABLE_TRANSACTIONS+
            " INNER JOIN "+ customers.TABLE_CUSTOMER+ " ON "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+"="+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_ID+
            " WHERE "+ customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_ID+ " =?"+" AND "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE+" =?";

    public static final String getTransactionsTime="SELECT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_TIME + " , "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_TOTAL_AMOUNT
            +" FROM  "+TABLE_TRANSACTIONS;

    public static final String getTimeVisitedByAge1="SELECT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_TIME+
            " FROM "+TABLE_TRANSACTIONS+
            " INNER JOIN "+customers.TABLE_CUSTOMER+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+"="+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_ID+
            " WHERE " +customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_AGE+ " <24";

    public static final String getTimeVisitedByAge2="SELECT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_TIME+
            " FROM "+TABLE_TRANSACTIONS+
            " INNER JOIN "+customers.TABLE_CUSTOMER+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+"="+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_ID+
            " WHERE " +customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_AGE+ " >23 AND "+ customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_AGE+ " <40";

    public static final String getTimeVisitedByAge3="SELECT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_TIME+
            " FROM "+TABLE_TRANSACTIONS+
            " INNER JOIN "+customers.TABLE_CUSTOMER+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+"="+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_ID+
            " WHERE " +customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_AGE+ " >39 AND "+ customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_AGE+ " <65";

    public static final String getTimeVisitedByAge4="SELECT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_TIME+
            " FROM "+TABLE_TRANSACTIONS+
            " INNER JOIN "+customers.TABLE_CUSTOMER+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+"="+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_ID+
            " WHERE " +customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_AGE+ " >64";
    
    public static final String getTransactionsPerStore="SELECT "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE +" , "+
    " ((SUM( CASE "+ TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_PAYMENT_METHOD+" WHEN 'Card' THEN 1 ELSE 0 END ) *100.0) / "
    		+ "(COUNT ( "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE+" ))) as Card, (( SUM(CASE "+
    		TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_PAYMENT_METHOD+" WHEN 'Cash' THEN 1 ELSE 0 END)*100.0 /COUNT("+
    		TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE+" ))) as Cash"+
    " FROM "+TABLE_TRANSACTIONS+
    " GROUP BY "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE +
    " ORDER BY "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_STORE;
    
    public static final String getPreferencesByCustomersWithPet="SELECT "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_EIDOS+" , "+
    		" COUNT ( "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_EIDOS+" ) AS Count "+
    		" FROM "+TABLE_TRANSACTIONS+
    		" INNER JOIN "+transaction.TABLE_TRANSACTION+ " ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+
    		"="+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_ID+
    		" INNER JOIN "+customers.TABLE_CUSTOMER+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+
    		"="+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_ID+
    		" INNER JOIN "+products.TABLE_PRODUCTS+" ON "+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+"="+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
    		" INNER JOIN "+category.TABLE_CATEGORY+" ON "+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_CATEGORY+"="+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_ID+
    		" WHERE "+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_PET+" >0"+
    		" GROUP BY "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_EIDOS+
    		" ORDER BY COUNT ( "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_EIDOS+" ) DESC";
    
    public static final String getPreferencesByCustomersWithoutPet="SELECT "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_EIDOS+" , "+
    		" COUNT ( "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_EIDOS+" ) AS Count "+
    		" FROM "+TABLE_TRANSACTIONS+
    		" INNER JOIN "+transaction.TABLE_TRANSACTION+ " ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_ID+
    		"="+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_ID+
    		" INNER JOIN "+customers.TABLE_CUSTOMER+" ON "+TABLE_TRANSACTIONS+"."+COLUMN_TRANSACTIONS_CUSTOMER+
    		"="+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_ID+
    		" INNER JOIN "+products.TABLE_PRODUCTS+" ON "+transaction.TABLE_TRANSACTION+"."+transaction.COLUMN_TRANSACTION_PRODUCT+"="+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_ID+
    		" INNER JOIN "+category.TABLE_CATEGORY+" ON "+products.TABLE_PRODUCTS+"."+products.COLUMN_PRODUCTS_CATEGORY+"="+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_ID+
    		" WHERE "+customers.TABLE_CUSTOMER+"."+customers.COLUMN_CUSTOMER_PET+" =0"+
    		" GROUP BY "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_EIDOS+
    		" ORDER BY COUNT ( "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_EIDOS+" ) DESC";


    private int id;
    private double totalAmount;
    private  int totalPieces;
    private int store;
    private int customer;
    private String paymentMethod;
    private String date;
    private String time;

    public Transactions(){}

    public Transactions(int id, double totalAmount, int totalPieces, int store, int customer, String paymentMethod, String date,String time) {
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
        return "Transactions{" +
                "id=" + id +
                ", totalAmount=" + totalAmount +
                ", totalPieces=" + totalPieces +
                ", store=" + store +
                ", customer=" + customer +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public boolean insertTransactions(int id,double totalAmount,int totalPieces,int store,int customer,String paymentMethod,String date){
        try{
        	datasource.open();
            datasource.insertIntoTransactions.setInt(1,id);
            datasource.insertIntoTransactions.setDouble(2,totalAmount);
            datasource.insertIntoTransactions.setInt(3,totalPieces);
            datasource.insertIntoTransactions.setInt(4,store);
            datasource.insertIntoTransactions.setInt(5,customer);
            datasource.insertIntoTransactions.setString(6,paymentMethod);
            datasource.insertIntoTransactions.setString(7,date);
            datasource.insertIntoTransactions.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
       
    }

    public List<Transactions> selectTransactionFromStoreByDate(int id){
        try {
            datasource.transactionFromaStoreByDate.setInt(1,id);
            ResultSet resultSet=datasource.transactionFromaStoreByDate.executeQuery();
            List<Transactions> transactions=new ArrayList<>();
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");

            while (resultSet.next()){
                Transactions transaction1;

                transaction1=new Transactions(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                transactions.add(transaction1);
            }
            return  transactions;
        }catch (SQLException e){
            System.out.println("Query failed "+e.getMessage());
            return null;
        }
     
    }
    public List<Integer>  getAllTransactions(int id){
        try {
            datasource.open();
            datasource.getallProducts.setInt(1,id);
            ResultSet resultSet=datasource.getallProducts.executeQuery();
            List<Integer> transactions=new ArrayList<>();
            while (resultSet.next()){
                int int1=resultSet.getInt(1);
                transactions.add(int1);
            }
            return transactions;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
      
    }

    public List<String> getTimesSpentMostMoney(){
        try{
            datasource.open();
            ResultSet resultSet=datasource.getMostSpendMoney.executeQuery();
            List<String> times=new ArrayList<>();
            Map<String,Integer> map=new LinkedHashMap<>();

            String string1=null;
            String string2=null;
            String string3=null;
            String string4=null;
            String string5=null;
            String string6=null;
            String string7=null;
            String string8=null;
            String string9=null;
            String string10=null;
            String string11=null;
            String string12=null;


            while (resultSet.next()) {

                String[] str = resultSet.getString(1).split(":");
                int counter = Integer.parseInt(str[2]) + Integer.parseInt(str[1]) * 60 + Integer.parseInt(str[0]) * 3600;
                int i = getTime(counter);
                switch (i) {
                    case 1:
                        count1 = count1 + resultSet.getInt(2);
                        string1 = "9-10";
                        break;
                    case 2:
                        count2 = count2 + resultSet.getInt(2);
                        string2 = "10-11";
                        break;
                    case 3:
                        count3 = count3 + resultSet.getInt(2);
                        string3 = "11-12";
                        break;
                    case 4:
                        count4 = count4 + resultSet.getInt(2);
                        string4 = "12-13";
                        break;
                    case 5:
                        count5 = count5 + resultSet.getInt(2);
                        string5 = "13-14";
                        break;
                    case 6:
                        count6 = count6 + resultSet.getInt(2);
                        string6 = "14-15";
                        break;
                    case 7:
                        count7 = count7 + resultSet.getInt(2);
                        string7 = "15-16";
                        break;
                    case 8:
                        count8 = count8 + resultSet.getInt(2);
                        string8 = "16-17";
                        break;
                    case 9:
                        count9 = count9 + resultSet.getInt(2);
                        string9 = "17-18";
                        break;
                    case 10:
                        count10 = count10 + resultSet.getInt(2);
                        string10 = "18-19";
                        break;
                    case 11:
                        count11 = count11 + resultSet.getInt(2);
                        string11 = "19-20";
                        break;
                    case 12:
                        count12 = count12 + resultSet.getInt(2);
                        string12 = "20-21";
                        break;
                }
            }

            map.put(string1,count1);
            map.put(string2,count2);
            map.put(string3,count3);
            map.put(string4,count4);
            map.put(string5,count5);
            map.put(string6,count6);
            map.put(string7,count7);
            map.put(string8,count8);
            map.put(string9,count9);
            map.put(string10,count10);
            map.put(string11,count11);
            map.put(string12,count12);
            Object[] a = map.entrySet().toArray();
            Arrays.sort(a, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return ((Map.Entry<String, Integer>) o2).getValue()
                            .compareTo(((Map.Entry<String, Integer>) o1).getValue());
                }
            });
            for (Object e : a) {
                    times.add(((String) ((Map.Entry<String, Integer>) e).getKey()));
//                System.out.println(((Map.Entry<String, Integer>) e).getKey() + " : "
//                        + ((Map.Entry<String, Integer>) e).getValue());
            }
            return times;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
    public List<Double> getTimesVisitByAge(PreparedStatement preparedStatement){
        try{
        	datasource.open();
              count1=0;
              count2=0;
              count3=0;
              count4=0;
              count5=0;
              count6=0;
              count7=0;
              count8=0;
              count9=0;
              count10=0;
              count11=0;
              count12=0;

            ResultSet resultSet=preparedStatement.executeQuery();
            List<Double> counts=new ArrayList<>();
            while (resultSet.next()){
                String[] str=resultSet.getString(1).split(":");
                int counter=Integer.parseInt(str[2])+Integer.parseInt(str[1])*60+Integer.parseInt(str[0])*3600;
                int i=getTime(counter);
                switch (i){
                    case 1:
                        count1++;
                        break;
                    case 2:
                        count2++;

                        break;
                    case 3:
                        count3++;

                        break;
                    case 4:
                        count4++;

                        break;
                    case 5:
                        count5++;

                        break;
                    case 6:
                        count6++;

                        break;
                    case 7:
                        count7++;

                        break;
                    case 8:
                        count8++;

                        break;
                    case 9:
                        count9++;

                        break;
                    case 10:
                        count10++;

                        break;
                    case 11:
                        count11++;

                        break;
                    case 12:
                        count12++;

                        break;
                }
            }
            double counter1=count1;
            double counter2=count2;
            double counter3=count3;
            double counter4=count4;
            double counter5=count5;
            double counter6=count6;
            double counter7=count7;
            double counter8=count8;
            double counter9=count9;
            double counter10=count10;
            double counter11=count11;
            double counter12=count12;




            counts.add(counter1);
            counts.add(counter2);
            counts.add(counter3);
            counts.add(counter4);
            counts.add(counter5);
            counts.add(counter6);
            counts.add(counter7);
            counts.add(counter8);
            counts.add(counter9);
            counts.add(counter10);
            counts.add(counter11);
            counts.add(counter12);
      

            return counts;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<RatioOfVisitsByAge> getRatios(){
        List<Double> countAge4=getTimesVisitByAge(datasource.getTimeVisitedByAges4);
        List<Double> countAge3=getTimesVisitByAge(datasource.getTimeVisitedByAges3);
        List<Double> countAge2=getTimesVisitByAge(datasource.getTimeVisitedByAges2);
        List <Double> countAge1=getTimesVisitByAge(datasource.getTimeVisitedByAges1);


        List<RatioOfVisitsByAge> time=new ArrayList<>();

        double count;
        for(int i=0;i<12;i++){
            count=countAge1.get(i)
            		+countAge2.get(i)
            		+countAge3.get(i)
            		+countAge4.get(i);
             time.add(new RatioOfVisitsByAge(countAge1.get(i)/count,countAge2.get(i)/count,countAge3.get(i)/count,countAge4.get(i)/count));
        }
        return time;
    }
    public int getTime(int counter){
        if(counter<time1){
            return 1;
        }
        else if(counter<time2){
            return 2;
        }
        else if(counter<time3){
            return 3;
        }
        else if(counter<time4){
            return 4;
        }
        else if(counter<time5){
            return 5;
        }
        else if(counter<time6){
            return 6;
        }
        else if(counter<time7){
            return 7;
        }
        else if(counter<time8){
            return 8;
        }
        else if(counter<time9){
            return 9;
        }
        else if(counter<time10){
            return 10;
        }
        else if(counter<time11){
            return 12;
        }
        else if(counter<time12){
            return 13;
        }
        else{
            return -1;
        }
    }
    
    public List<TransactionsPerStore> getAllPayments(){
    	try {
    		datasource.open();
    		ResultSet resultSet=datasource.paymentsPerStore.executeQuery();
    		List<TransactionsPerStore> transactionsPerStore=new ArrayList<TransactionsPerStore>();
    		while(resultSet.next()) {
    			TransactionsPerStore transactionPerStore=new TransactionsPerStore(resultSet.getInt(1),
    					resultSet.getDouble(2),resultSet.getDouble(3));
    			transactionsPerStore.add(transactionPerStore);
    		}
    		return transactionsPerStore;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    public List<CountPerCategory> getCountsPerCategoryWithPet(){
    	try {
    		datasource.open();
    		ResultSet resultSet=datasource.CountsPerCategoryWithPet.executeQuery();
    		List<CountPerCategory> counts=new ArrayList<>();
    		while(resultSet.next()) {
    			CountPerCategory count=new CountPerCategory(resultSet.getString(1),resultSet.getInt(2));
    			counts.add(count);
    		}
    		return counts;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public List<CountPerCategory> getCountsPerCategoryWithoutPet(){
    	try {
    		datasource.open();
    		ResultSet resultSet=datasource.CountsPerCategoryWithoutPet.executeQuery();
    		List<CountPerCategory> counts=new ArrayList<>();
    		while(resultSet.next()) {
    			CountPerCategory count=new CountPerCategory(resultSet.getString(1),resultSet.getInt(2));
    			counts.add(count);
    		}
    		return counts;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }





}
