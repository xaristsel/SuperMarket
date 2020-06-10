package com.company;

import com.company.Data.*;
import com.company.Data.model.Customers;
import com.company.Data.model.Products;
import com.company.Data.model.Stores;
import com.company.Data.model.Transaction;
import com.company.Data.model.Transactions;

import java.sql.Array;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Datasource datasource = new Datasource();
        datasource.open();
       // datasource.createTables();
        Transaction transaction=new Transaction();
       Transactions transactions=new Transactions();

//        List<Integer> integers=new ArrayList<>(transactions.getAllTransactions(3));
//        for(int i=0;i<integers.size();i++){
//            System.out.println("transaction "+ i+ "= "+integers.get(i));
//        }

       // a1=datasource.g(1);
        SortStoreTransactions sortStoreTransactions=new SortStoreTransactions();
        Integer id=1;
        Integer category=null;
        Double totalAmount=null;
        Integer totalPieces=null;
        String date=null;
        String paymentMethod="Card";
        List<A1> a1;
        a1=new ArrayList<>(sortStoreTransactions.sortTransactions(id,totalAmount,totalPieces,category,paymentMethod,date));
        for(A1 a1s:a1){
            System.out.println(a1s.toString());
        }
        System.out.println();

        System.out.println("a erwthma egine");
        System.out.println();

        CustomersProfile customersProfile=new CustomersProfile();

        Integer _id=1;
        Customers customer;
        customer=customersProfile.getCustomerProfile(_id);
//
        System.out.println("Customer's profile for id: "+id+" is "+customer.toString());
        System.out.println();
        List<Transactions> transactions1=new ArrayList<>();
        transactions1=customersProfile.getCustomerTransactions(_id);
        for(int i=0;i<transactions1.size();i++){
            System.out.println("Customer's transaction is "+ transactions1.get(i).toString());
        }
        System.out.println();
        List<BestCustomerProducts> bestCustomerProducts;
        bestCustomerProducts=new ArrayList<>(customersProfile.getCustomerBestProducts(_id));

        for(int i=0;i<bestCustomerProducts.size();i++){
            System.out.println(i+ ": Customer best product "+bestCustomerProducts.get(i).toString());
        }
        System.out.println();
        int a=customersProfile.getCustomersStoresCount(_id);
        System.out.println("Customer with id: " +_id+" visited "+ a+" stores.");
        List<Stores> storesVisited;
        storesVisited=new ArrayList<>(customersProfile.getCustomersStore(_id));
        for(int i=0;i<storesVisited.size();i++) {
            System.out.println(" Customer with id: " + _id + " visited:"+storesVisited.get(i).toString());
        }
        List<Double> visitingRatios;
        for(int i=1;i<11;i++) {
            visitingRatios = new ArrayList<>(customersProfile.getRatioPerHours(_id,i));
            for (int i1 = 0; i1 < visitingRatios.size(); i1++) {

                System.out.println("For Store with id:"+i +" the "+i1 + " HOUR the customer with id: "+_id+" visited " + visitingRatios.get(i1));
            }
        }
        System.out.println();
        List<TransactionPerMonth> customersMonthlyTransaction=new ArrayList<>(customersProfile.getCustomersTransactionsPerMonth(_id));
        for(int i=0;i<customersMonthlyTransaction.size();i++){
            System.out.println(customersMonthlyTransaction.get(i).toString());
        }
        System.out.println();
        List<TransactionsPerWeek> customersWeeklyTransactions=new ArrayList<>(customersProfile.getCustomersTransactionsPerWeek(_id));
        for(int i=0;i<customersWeeklyTransactions.size();i++){
            System.out.println(customersWeeklyTransactions.get(i).toString());
        }
//
        System.out.println();
        List<BestPair> bestPairs=new ArrayList<>(transaction.getAllPairs());
        for(int i=0;i< bestPairs.size();i++){
            System.out.println("id1 ="+ bestPairs.get(i).getId1()+" id2 ="+bestPairs.get(i).getid2());
        }
        System.out.println();

         List<CountAlleyShelf> countAlleyShelfList=new ArrayList<>(transaction.getAlleyShelf());
        Collections.sort(countAlleyShelfList);
        for(int i=0;i<countAlleyShelfList.size();i++){
            System.out.format(" id1 = %d and id2 = %d ",countAlleyShelfList.get(i).getId1(),countAlleyShelfList.get(i).getId2());
            System.out.println();
        }
        System.out.println();

        double apotelesma;
        apotelesma=transaction.getProductsBrandNamePerCategory(1);
        System.out.println("epwnuma proionta apo freska= "+apotelesma*100+ "%");
        System.out.println();

        apotelesma=transaction.getProductsBrandNamePerCategory(2);
        System.out.println("epwnuma proionta apo psugiou= "+apotelesma*100+ "%");
        System.out.println();

        apotelesma=transaction.getProductsBrandNamePerCategory(3);
        System.out.println("epwnuma proionta apo kavas= "+apotelesma*100+ "%");
        System.out.println();

        apotelesma=transaction.getProductsBrandNamePerCategory(4);
        System.out.println("epwnuma proionta apo peripoiisis= "+apotelesma*100+ "%");
        System.out.println();

        apotelesma=transaction.getProductsBrandNamePerCategory(5);
        System.out.println("epwnuma proionta apo spitiou= "+apotelesma*100+ "%");
        System.out.println();

        apotelesma=transaction.getProductsBrandNamePerCategory(6);
        System.out.println("epwnuma proionta apo katoikidiwn= "+apotelesma*100+ "%");
        System.out.println();

     List<String> strings=new ArrayList<>(transactions.getTimesSpentMostMoney());
     System.out.println("Times spent most money:");
     for(int i=0;i<strings.size();i++){
         System.out.println(strings.get(i));
     }
     System.out.print(Products.UPDATE_PRODUCT);
     
     
     
     
     
     
        List<RatioOfVisitsByAge> ratioOfVisitsByAges=new ArrayList<>(transactions.getRatios());
        String[] time=new String[13];
         time[1]="9-10";
        time[2]="10-11";
        time[3]="11-12";
        time[4]="12-13";
        time[5]="13-14";
        time[6]="14-15";
        time[7]="15-16";
        time[8]="16-17";
        time[9]="17-18";
        time[10]="18-19";
        time[11]="19-20";
        time[12]="20-21";

        for(int i=0;i<ratioOfVisitsByAges.size();i++) {
            try {
                System.out.println("For time between" + time[i + 1] + " the ratios of age that are visiting the market are: " +
                        " for Age 16-24: " + ratioOfVisitsByAges.get(i).getAge1()*100 +" %"+
                        " for Age 25-40: " + ratioOfVisitsByAges.get(i).getAge2()*100 + " %"+
                        " for Age 40-65: " + ratioOfVisitsByAges.get(i).getAge3()*100 + " %"+
                        " for Age 65+: " + (ratioOfVisitsByAges.get(i).getAge3())*100 +" %");
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        
        Products products=new Products();
        boolean bool=products.insertProducts("xarhs","YES",1.5,1);
        System.out.print("bool =" + bool );
//
//        for(int i=0;i<storesVisited.size();i++){
//            System.out.println(storesVisited.get(i).toString());
//        }
//        System.out.println();

//        double apotelesma;
//        apotelesma=transaction.getProductsBrandNamePerCategory(1);
//        System.out.println("epwnuma proionta apo freska= "+apotelesma*100+ "%");
//
//        apotelesma=transaction.getProductsBrandNamePerCategory(2);
//        System.out.println("epwnuma proionta apo psugiou= "+apotelesma*100+ "%");
//
//        apotelesma=transaction.getProductsBrandNamePerCategory(3);
//        System.out.println("epwnuma proionta apo kavas= "+apotelesma*100+ "%");
//
//        apotelesma=transaction.getProductsBrandNamePerCategory(4);
//        System.out.println("epwnuma proionta apo peripoiisis= "+apotelesma*100+ "%");
//
//        apotelesma=transaction.getProductsBrandNamePerCategory(5);
//        System.out.println("epwnuma proionta apo spitiou= "+apotelesma*100+ "%");
//
//        apotelesma=transaction.getProductsBrandNamePerCategory(6);
//        System.out.println("epwnuma proionta apo katoikidiwn= "+apotelesma*100+ "%");
//
//        List<RatioOfVisitsByAge> ratioOfVisitsByAges=new ArrayList<>(transactions.getRatios());
//        String[] time=new String[13];
//         time[1]="9-10";
//        time[2]="10-11";
//        time[3]="11-12";
//        time[4]="12-13";
//        time[5]="13-14";
//        time[6]="14-15";
//        time[7]="15-16";
//        time[8]="16-17";
//        time[9]="17-18";
//        time[10]="18-19";
//        time[11]="19-20";
//        time[12]="20-21";
//
//        for(int i=0;i<ratioOfVisitsByAges.size();i++) {
//            try {
//                System.out.println("For time between" + time[i + 1] + " the ratios of age that are visiting the market are: " +
//                        " for Age 16-24: " + ratioOfVisitsByAges.get(i).getAge1()*100 +" %"+
//                        " for Age 25-40: " + ratioOfVisitsByAges.get(i).getAge2()*100 + " %"+
//                        " for Age 40-65: " + ratioOfVisitsByAges.get(i).getAge3()*100 + " %"+
//                        " for Age 65+: " + (ratioOfVisitsByAges.get(i).getAge3())*100 +" %");
//            } catch (ArrayIndexOutOfBoundsException e) {
//                e.printStackTrace();
//            }
//        }
//        List<CountAlleyShelf> countAlleyShelfList=new ArrayList<>(transaction.getAlleyShelf());
//        Collections.sort(countAlleyShelfList);
//        for(int i=0;i<countAlleyShelfList.size();i++){
//            System.out.format(" id1 = %d and id2 = %d ",countAlleyShelfList.get(i).getId1(),countAlleyShelfList.get(i).getId2());
//            System.out.println();
//            System.out.println(countAlleyShelfList.get(i).count);
//            System.out.println();
//            System.out.println("antistrofh");
//        }
//
    }
}
