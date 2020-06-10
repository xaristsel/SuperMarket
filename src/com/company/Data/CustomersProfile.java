package com.company.Data;

import com.company.Data.model.Customers;
import com.company.Data.model.Stores;
import com.company.Data.model.Transactions;
import com.company.Datasource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomersProfile {
    public Datasource datasource=new Datasource();
    public Transactions transactions=new Transactions();
    public CustomersProfile() {}
    public Customers getCustomerProfile(Integer id){
        try{
        	datasource.open();
            datasource.getCustomersPorfile.setInt(1,id);
            ResultSet resultSet=datasource.getCustomersPorfile.executeQuery();
            while (resultSet.next()){
                Customers customers=new Customers(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getInt(9),
                        resultSet.getInt(10),resultSet.getString(11),resultSet.getInt(12),resultSet.getString(13));
                return customers;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public List<Transactions> getCustomerTransactions(Integer id){
        try{
            datasource.open();
            datasource.getCustomersTransactions.setInt(1,id);
            ResultSet resultSet= datasource.getCustomersTransactions.executeQuery();
            List<Transactions> transactions=new ArrayList<>();
            while (resultSet.next()){

                Transactions transaction=new Transactions(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                transactions.add(transaction);
            }
            return transactions;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<BestCustomerProducts> getCustomerBestProducts(Integer id){
        try{
            datasource.getCustomerBestProducts.setInt(1,id);
            ResultSet resultSet=datasource.getCustomerBestProducts.executeQuery();
            List<BestCustomerProducts> products=new ArrayList<>();
            while(resultSet.next()){
                BestCustomerProducts bestProducts=new BestCustomerProducts( resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
                products.add(bestProducts);
            }
            return products;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public int getCustomersStoresCount(Integer id){
        try{
            datasource.getCustomerStoresCount.setInt(1,id);
            ResultSet resultSet=datasource.getCustomerStoresCount.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }


    public List<Stores>getCustomersStore(Integer id){
        try{
            datasource.getCustomerStores.setInt(1,id);
            ResultSet resultSet=datasource.getCustomerStores.executeQuery();
            List<Stores> getCustomerStores=new ArrayList<>();
            while(resultSet.next()) {
                Stores store = new Stores(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5),
                        resultSet.getInt(6), resultSet.getString(7), resultSet.getString(8));
                    int counter=1;
                    for(int i=0;i<getCustomerStores.size();i++){
                        if(getCustomerStores.get(i).getId()!=store.getId()){
                            counter++;
                        }
                        else{
                            counter=0;
                            break;
                        }
                    }
                    if(counter!=0) getCustomerStores.add(store);
            }
            return getCustomerStores;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<TransactionPerMonth> getCustomersTransactionsPerMonth(Integer id){
        try{
            datasource.open();
            datasource.getCustomersMonthlyTransactions.setInt(1,id);
            ResultSet resultSet= datasource.getCustomersMonthlyTransactions.executeQuery();
            List<TransactionPerMonth> transactionPerMonths=new ArrayList<>();
            while (resultSet.next()){
                TransactionPerMonth transactionPerMonth=new TransactionPerMonth(resultSet.getString(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getDouble(4));
                transactionPerMonths.add(transactionPerMonth);
            }
            return transactionPerMonths;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<TransactionsPerWeek> getCustomersTransactionsPerWeek(Integer id){
        try{
            datasource.open();
            datasource.getCustomersWeeklyTransactions.setInt(1,id);
            ResultSet resultSet= datasource.getCustomersWeeklyTransactions.executeQuery();
            List<TransactionsPerWeek> transactionsPerWeek=new ArrayList<>();
            while (resultSet.next()){
                TransactionsPerWeek transactionsPerWeek1=new TransactionsPerWeek(resultSet.getInt(1),resultSet.getInt(2),resultSet.getDouble(3),resultSet.getDouble(4));
                transactionsPerWeek.add(transactionsPerWeek1);
            }
            return transactionsPerWeek;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Double> getRatioPerHours(int _id,int i2){
        List<String> getHours=new ArrayList<>(getCustomerVisitedHours(_id,i2));
        double[] wrario=new double[12];
        for(int i=0;i<12;i++){
            wrario[i]=0;
        }
        for(int i=0;i<getHours.size();i++){
            System.out.println(getHours.size());
            System.out.println(getHours.get(i));
            String[] str=getHours.get(i).split(":");
            int currentSecond=Integer.parseInt(str[2])+Integer.parseInt(str[1])*60+Integer.parseInt(str[0])*3600;
            int i1=transactions.getTime(currentSecond);
            switch (i1){
                case 1:
                    wrario[0]++;
                    break;
                case 2:
                    wrario[1]++;
                    break;
                case 3:
                    wrario[2]++;
                    break;
                case 4:
                    wrario[3]++;
                    break;
                case 5:
                    wrario[4]++;
                    break;
                case 6:
                    wrario[5]++;
                    break;
                case 7:
                    wrario[6]++;

                    break;
                case 8:
                    wrario[7]++;
                    break;
                case 9:
                    wrario[8]++;
                    break;
                case 10:
                    wrario[9]++;
                    break;
                case 11:
                    wrario[10]++;
                    break;
                case 12:
                    wrario[11]++;
                    break;
            }
        }

        double count=0;
        for(int i=0;i<12;i++){
            count=count+wrario[i];
        }
        List<Double> ratio=new ArrayList<>();
        double result;
        for(int i=0;i<wrario.length;i++){
            result= wrario[i]/count;
            ratio.add(result);
        }
        return ratio;
    }

    public List<String> getCustomerVisitedHours(int id,int i1){
        try {
            datasource.open();
            datasource.getCustomersVisitedTimes.setInt(1,id);
            datasource.getCustomersVisitedTimes.setInt(2,i1);
            ResultSet resultSet=datasource.getCustomersVisitedTimes.executeQuery();
            List<String> getHours=new ArrayList<>();
            while (resultSet.next()){
                String time=resultSet.getString(1);
                getHours.add(time);
            }
            return getHours;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object object){
        if(this==object){
            return true;
        }
        if(object==null){
            return false;
        }
        if(getClass()!=object.getClass()){
            return false;
        }
        return true;
    }

}
