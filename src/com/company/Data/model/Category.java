package com.company.Data.model;

import com.company.Datasource;
import java.sql.SQLException;

public class Category {
    private Datasource datasource=new Datasource();
    public static final String TABLE_CATEGORY="category";

    public static final String COLUMN_CATEGORY_ID= "ID";
    public static final String COLUMN_CATEGORY_EIDOS = "Name";

    public static final String INSERT_INTO_CATEGORY="INSERT INTO "+TABLE_CATEGORY+
            "("+COLUMN_CATEGORY_EIDOS+") VALUES(?)";

    private int id;
    private String eidos;

    public Category(){}
    public Category(int id, String eidos) {
        this.id = id;
        this.eidos = eidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEidos() {
        return eidos;
    }

    public void setEidos(String eidos) {
        this.eidos = eidos;
    }




    public boolean insertCategory(int id,String name,String quantity){
        try {
        	datasource.open();
            datasource.insertIntoCategory.setInt(1,id);
            datasource.insertIntoCategory.setString(2,name);
            datasource.insertIntoCategory.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        finally {
        
                datasource.close();
        	
        }
        
    }
}
