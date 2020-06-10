package com.company;
import com.company.Data.model.*;
import java.sql.*;


public class Datasource {
    public static final String DB_NAME="SuperMarket.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\theox\\databases\\" + DB_NAME;

    private Customers customers;
    private static Stores stores;
    private  static AlleyShelf alleyShelf;
    private static Category category;
    private static OlderPrices olderPrices;
    private static Products products;
    private static Transaction transaction;
    private static Transactions transactions=new Transactions();



    public static final String add1=" AND "+category.TABLE_CATEGORY+"."+category.COLUMN_CATEGORY_ID+" =?";
    public static final String add2=" AND "+ transactions.TABLE_TRANSACTIONS+"."+transactions.COLUMN_TRANSACTIONS_TOTAL_AMOUNT+" =?";
    public static final String add3=" AND "+transactions.TABLE_TRANSACTIONS+"."+transactions.COLUMN_TRANSACTIONS_TOTAL_PIECES+" =?";
    public static final String add4=" AND " + transactions.TABLE_TRANSACTIONS+"."+transactions.COLUMN_TRANSACTIONS_DATE+" =?";
    public static final String add5=" AND "+ transactions.TABLE_TRANSACTIONS+"."+transactions.COLUMN_TRANSACTIONS_PAYMENT_METHOD+" =?";
    public static final String add6=" GROUP BY "+ transactions.TABLE_TRANSACTIONS+"."+transactions.COLUMN_TRANSACTIONS_ID;
    public static final String add7=" ORDER BY "+ transactions.TABLE_TRANSACTIONS+"."+transactions.COLUMN_TRANSACTIONS_ID;

    public PreparedStatement insertIntoCustomers;
    public PreparedStatement deleteCustomer;
    public PreparedStatement updateCustomer;
    public PreparedStatement getCustomers;
    public PreparedStatement instertIntoStores;
    public PreparedStatement deleteStore;
    public PreparedStatement updateStore;
    public PreparedStatement getStores;
    public PreparedStatement getStoresById;
    public PreparedStatement insertIntoProducts;
    public PreparedStatement deleteProduct;
    public PreparedStatement updateProduct;
    public PreparedStatement updateProductPrice;  
    public PreparedStatement getProducts;
    public PreparedStatement getProductsById;
    public PreparedStatement getProductId;
    public PreparedStatement insertIntoCategory;
    public PreparedStatement insertIntoOlderPrices;
    public PreparedStatement getOlderPrices;
    public PreparedStatement insertIntoTransactions;
    public PreparedStatement insertIntoTransaction;
    public PreparedStatement insertIntoAlleyShelf;
    public PreparedStatement transactionFromaStoreByDate;
    public PreparedStatement getStoresTransactionsTransactionProductProcuctPriceProductCategory;
    public PreparedStatement getCustomersPorfile;
    public PreparedStatement getCustomersTransactions;
    public PreparedStatement getCustomerBestProducts;
    public   PreparedStatement getCustomerStores;
    public PreparedStatement getCustomerStoresCount;
    public PreparedStatement getAllTransaction;
    public   PreparedStatement getProductionPairs;
    public PreparedStatement getMonthlyTransactions;
    public PreparedStatement getCustomersMonthlyTransactions;
    public PreparedStatement getCustomersWeeklyTransactions;
    public PreparedStatement getProductsByBrandNamePerCategory;
    public PreparedStatement getallProducts;
    public PreparedStatement getStoresAlleys;
    public PreparedStatement getCustomersVisitedTimes;
    public PreparedStatement getMostSpendMoney;
    public PreparedStatement getTimeVisitedByAges1;
    public PreparedStatement getTimeVisitedByAges2;
    public PreparedStatement getTimeVisitedByAges3;
    public PreparedStatement getTimeVisitedByAges4;
    public PreparedStatement paymentsPerStore;
    public PreparedStatement CountsPerCategoryWithPet;
    public PreparedStatement CountsPerCategoryWithoutPet;




    public StringBuilder stringBuilder=new StringBuilder();
    public  Connection connection;
    private static Datasource instance=new Datasource();


    private static Datasource getInstance(){
        return instance;
    }
    public Datasource(){}
    public boolean open()  {
        try {
        	Class.forName("org.sqlite.JDBC");
             connection = DriverManager.getConnection(CONNECTION_STRING);
            insertIntoCustomers=connection.prepareStatement(customers.INSERT_INTO_CUSTOMERS);
            deleteCustomer=connection.prepareStatement(customers.DELETE_FROM_CUSTOMERS);
           updateCustomer=connection.prepareStatement(customers.UPDATE_CUSTOMER);
           getCustomers=connection.prepareStatement(customers.GET_ALL_CUSTOMERS);
            instertIntoStores=connection.prepareStatement(stores.INSERT_INTO_STORES);
            deleteStore=connection.prepareStatement(stores.DELETE_FROM_STORES);
            updateStore=connection.prepareStatement(stores.UPDATE_STORES);
            getStores=connection.prepareStatement(stores.GET_ALL_STORES);
            getStoresById=connection.prepareStatement(stores.GET_STORES_BY_ID);
            insertIntoProducts=connection.prepareStatement(products.INSERT_INTO_PRODUCTS);
            deleteProduct=connection.prepareStatement(products.DELETE_PRODUCT);
            updateProduct=connection.prepareStatement(products.UPDATE_PRODUCT);
            updateProductPrice=connection.prepareStatement(products.UPDATE_PRODUCT_PRICE);
            getProducts=connection.prepareStatement(products.GET_ALL_PRODUCTS);
            getProductsById=connection.prepareStatement(products.GET_PRODUCTS_BY_ID);
            getProductId=connection.prepareStatement(products.GET_PRODUCTS_ID);
            insertIntoCategory=connection.prepareStatement(category.INSERT_INTO_CATEGORY);
            insertIntoOlderPrices=connection.prepareStatement(olderPrices.INSERT_INTO_OLDER_PRICES);
            getOlderPrices=connection.prepareStatement(olderPrices.GET_ALL_FROM_OLDER_PRICES);
            insertIntoTransactions=connection.prepareStatement(transactions.INSERT_INTO_TRANSACTIONS);
            insertIntoTransaction=connection.prepareStatement(transaction.INSERT_INTO_TRANSACTION);
            insertIntoAlleyShelf=connection.prepareStatement(alleyShelf.INSERT_INTO_ALLEY_SHELF);
            transactionFromaStoreByDate=connection.prepareStatement(transactions.TRANSTACTIONS_FROM_A_STORE_WITH_DATE);
            getStoresTransactionsTransactionProductProcuctPriceProductCategory=connection.prepareStatement(transactions.a1);
            getCustomersPorfile=connection.prepareStatement(customers.b1);
            getCustomersTransactions =connection.prepareStatement(transactions.b2);
            getCustomerBestProducts=connection.prepareStatement(transactions.b3);
            getCustomerStores=connection.prepareStatement(transactions.b4);
            getCustomerStoresCount=connection.prepareStatement(transactions.b5);
            getProductionPairs=connection.prepareStatement(transaction.getProductsPair);
            getStoresAlleys=connection.prepareStatement(transaction.COUNT_ALLEY_SHELF_PER_STORE);
            getMonthlyTransactions =connection.prepareStatement(transactions.getTransactionsPerMonth);
            getCustomersMonthlyTransactions =connection.prepareStatement(transactions.getTransactionsPerMonth);
            getCustomersWeeklyTransactions=connection.prepareStatement(transactions.getTransactionsPerWeek);
            getProductsByBrandNamePerCategory=connection.prepareStatement(transaction.getProductsByBrandName);
            getallProducts=connection.prepareStatement(transactions.getAllTransactions);
            getCustomersVisitedTimes=connection.prepareStatement(transactions.getVisitedTimes);
            getMostSpendMoney=connection.prepareStatement(transactions.getTransactionsTime);
            getTimeVisitedByAges1=connection.prepareStatement(transactions.getTimeVisitedByAge1);
            getTimeVisitedByAges2=connection.prepareStatement(transactions.getTimeVisitedByAge2);
            getTimeVisitedByAges3=connection.prepareStatement(transactions.getTimeVisitedByAge3);
            getTimeVisitedByAges4=connection.prepareStatement(transactions.getTimeVisitedByAge4);
            paymentsPerStore=connection.prepareStatement(transactions.getTransactionsPerStore);
            CountsPerCategoryWithPet=connection.prepareStatement(transactions.getPreferencesByCustomersWithPet);
            CountsPerCategoryWithoutPet=connection.prepareStatement(transactions.getPreferencesByCustomersWithoutPet);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldnot connect to database " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	 System.out.println("error in jar" + e.getMessage());
        	 e.printStackTrace();
		} 
        return false;
    }

    public boolean close() {
        try {
            if(insertIntoProducts!=null){
                insertIntoProducts.close();
            }
            if(deleteProduct!=null) {
            	deleteProduct.close();
            }
            if(updateProduct!=null) {
            	updateProduct.close();
            }
            if(updateProductPrice!=null) {
            	updateProductPrice.close();
            }
            if(getProducts!=null) {
            	getProducts.close();
            }
            if(getProductsById!=null) {
            	getProductsById.close();
            }
            if(getProductId!=null) {
            	getProductId.close();
            }
            if(insertIntoCustomers!=null){
                insertIntoCustomers.close();
            }
            if(deleteCustomer!=null){
                deleteCustomer.close();
            }
            if(updateCustomer!=null) {
            	updateCustomer.close();
            }
            if(instertIntoStores!=null){
                instertIntoStores.close();
            }
            if(deleteStore!=null) {
            	deleteStore.close();
            }
            if(updateStore!=null) {
            	updateStore.close();
            }
            if(getStores!=null) {
            	getStores.close();
            }
            if(getStoresById!=null) {
            	getStoresById.close();
            }
            if(insertIntoCategory!=null){
                insertIntoCategory.close();
            }
            if(insertIntoOlderPrices!=null){
                insertIntoOlderPrices.close();
            }
            if(getOlderPrices!=null) {
            	getOlderPrices.close();
            }
            if(insertIntoTransactions!=null){
                insertIntoTransactions.close();
            }
            if(insertIntoTransaction!=null){
                insertIntoTransaction.close();
            }
            if(insertIntoAlleyShelf!=null){
                insertIntoAlleyShelf.close();
            }
            if(transactionFromaStoreByDate!=null){
                transactionFromaStoreByDate.close();
            }
            if(getStoresTransactionsTransactionProductProcuctPriceProductCategory!=null){
                getStoresTransactionsTransactionProductProcuctPriceProductCategory.close();
            }
            if(getCustomersPorfile!=null){
                getCustomersPorfile.close();
            }
            if(getCustomersTransactions !=null){
                getCustomersTransactions.close();
            }
            if(getCustomerBestProducts!=null){
                getCustomerBestProducts.close();
            }
            if(getCustomerStores!=null){
                getCustomerStores.close();
            }
            if(getCustomerStoresCount!=null){
                getCustomerStoresCount.close();
            }
            if(getAllTransaction!=null){
                getAllTransaction.close();
            }
            if(getProductionPairs!=null){
                getProductionPairs.close();
            }
            if(getMonthlyTransactions !=null){
                getMonthlyTransactions.close();
            }
            if(getCustomersMonthlyTransactions !=null){
                getCustomersMonthlyTransactions.close();
            }
            if(getCustomersWeeklyTransactions!=null){
                getCustomersWeeklyTransactions.close();
            }
            if(getProductsByBrandNamePerCategory!=null){
                getProductsByBrandNamePerCategory.close();
            }
            if(getallProducts!=null){
                getallProducts.close();
            }
            if(getStoresAlleys!=null){
                getStoresAlleys.close();
            }
            if (getCustomersVisitedTimes!=null){
                getCustomersVisitedTimes.close();
            }
            if (getMostSpendMoney!=null){
                getMostSpendMoney.close();
            }
            if(getTimeVisitedByAges1!=null){
                getTimeVisitedByAges1.close();
            }
            if(getTimeVisitedByAges2!=null){
                getTimeVisitedByAges2.close();
            }if(getTimeVisitedByAges3!=null){
                getTimeVisitedByAges3.close();
            }if(getTimeVisitedByAges4!=null){
                getTimeVisitedByAges4.close();
            }
            if(paymentsPerStore!=null) {
            	paymentsPerStore.close();
            }
            if(CountsPerCategoryWithPet!=null) {
            	CountsPerCategoryWithPet.close();
            }
            if(CountsPerCategoryWithoutPet!=null) {
            	CountsPerCategoryWithoutPet.close();
            }
            connection.close();
            
        } catch (SQLException e) {
            System.out.println("Could not close connection" + e.getMessage());
            e.printStackTrace();
        }
        return false;

    }
}
