package com.example.eshopproject;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "products")
public class Products {

    @PrimaryKey @ColumnInfo(name = "pid")
    private int id;

    @ColumnInfo ( name = "quantity")
    private int quantity;

    @ColumnInfo (name="pname")
    private String name;

    @ColumnInfo (name="ptype")
    private int type; //1 For shows - 2 For movies

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

    public int getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType(int type) {
        this.type = type;


    }
}
