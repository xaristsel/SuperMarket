package com.company.Data;

import com.company.Data.model.Transactions;
import com.company.Datasource;

import javax.swing.text.TabableView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SortStoreTransactions {


    Datasource datasource = new Datasource();
    public static Transactions transactions=new Transactions();


    List<A1> a1=new ArrayList<>();

public List<A1> sortTransactions(Integer id, Double totalAmount, Integer totalPieces, Integer category, String paymentMethod, String date) {
    datasource.open();
    if (category != null) {
        if (totalAmount != null) {
            if (totalPieces != null) {
                if (date != null) {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, totalPieces, category, paymentMethod, date);


                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, totalPieces, category, date);

                    }
                } else {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, totalPieces, category, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, totalPieces, category);

                    }
                }
            } else {

                if (date != null) {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, category, date, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, category, date);

                    }
                } else {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, category, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, category);

                    }
                }
            }
        } else {
            if (totalPieces != null) {
                if (date != null) {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 =GetStoresProPriCat(datasource.stringBuilder, id, totalPieces, category, date, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalPieces, category, date);

                    }
                } else {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalPieces, category, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalPieces, category);

                    }
                }
            } else {
                if (date != null) {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, category, date, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 =GetStoresProPriCat(datasource.stringBuilder, id, category, date);

                    }
                } else {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        System.out.println(datasource.stringBuilder.toString());
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, category, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add1);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, category);

                    }
                }
            }
        }
    } else {
        if (totalAmount != null) {
            if (totalPieces != null) {
                if (date != null) {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, totalPieces, date, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, totalPieces, date);

                    }
                } else {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, totalPieces, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, totalPieces);

                    }
                }
            } else {
                if (date != null) {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, date, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, date);

                    }
                } else {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add2);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalAmount);

                    }
                }
            }
        } else {
            if (totalPieces != null) {
                if (date != null) {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalPieces, date, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalPieces, date);

                    }
                } else {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalPieces, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add3);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, totalPieces);

                    }
                }
            } else {
                if (date != null) {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, date, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add4);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, date);

                    }
                } else {
                    if (paymentMethod != null) {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add5);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id, paymentMethod);

                    } else {
                        datasource.stringBuilder = new StringBuilder();
                        datasource.stringBuilder.append(transactions.a1);
                        datasource.stringBuilder.append(datasource.add6);
                        datasource.stringBuilder.append(datasource.add7);
                        System.out.println(datasource.stringBuilder.toString());
                        a1 = GetStoresProPriCat(datasource.stringBuilder, id);

                    }
                }
            }
        }
    }
    return a1;
}
    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1, Integer x2, Integer x3, String x4, String x5){
        try{

            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(4,x3);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(5,x4);
           datasource. getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(6,x5);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);
                System.out.println(a1.toString());

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1, Integer x2, String x3, String x4){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(4,x3);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(5,x4);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Integer x1, Integer x2, String x3, String x4){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(4,x3);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(5,x4);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }


    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Integer x1, String x2, String x3){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(4,x3);
            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1, String x2, String x3){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(4,x3);
            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, String x1, String x2){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(3,x2);
            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);
            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1, Integer x2, Integer x3, String x4){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(4,x3);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(5,x4);
            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1, Integer x2, String x3){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(4,x3);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Integer x1, Integer x2, String x3){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(4,x3);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Integer x1, String x2){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(3,x2);
            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1, String x2){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(3,x2);
            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, String x1){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setString(2,x1);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1, Integer x2, Integer x3){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(4,x3);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1, Integer x2){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Integer x1, Integer x2){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(2,x1);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(3,x2);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Integer x1){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(2,x1);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id, Double x1){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setDouble(2,x1);

            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);

            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<A1> GetStoresProPriCat(StringBuilder sb, Integer id){
        try{
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory=datasource.connection.prepareStatement(sb.toString());
            datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.setInt(1,id);
            ResultSet resultSet=datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.executeQuery();
            List<A1> allElements=new ArrayList<>();
            while (resultSet.next()){
                A1 a1=new A1(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
                allElements.add(a1);
            }
            return allElements;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return null;
        }finally {
            if(datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory!=null){
                try{
                    datasource.getStoresTransactionsTransactionProductProcuctPriceProductCategory.close();

                }catch (SQLException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }




}
