package com.example.eshopproject;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "sales",
foreignKeys = {
        @ForeignKey(entity = Customers.class,
        parentColumns = "username",
        childColumns = "susername",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = Products.class,
        parentColumns = "pid",
        childColumns = "spid",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)
        })
public class Sales {


    @PrimaryKey @ColumnInfo(name="sid")
    private int saleId;

    @ColumnInfo(name="spid")
    private int productId;

    @ColumnInfo(name="susername")
    private String username;

    @ColumnInfo(name="sdate")
    private String date;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
