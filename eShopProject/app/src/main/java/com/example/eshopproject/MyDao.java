package com.example.eshopproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Query("SELECT MAX(pid) FROM products")
    public String getMaxProductId();

    @Query("SELECT * FROM customers")
    public List<Customers> getCustomers();

    @Query("SELECT * FROM sales")
    public List<Sales> getSales();

    @Query("SELECT password FROM customers WHERE username=:input")
    public String getAuth(String input);

    @Insert
    public void insertCustomer(Customers customers);

    @Delete
    public void deleteCustomer(Customers customers);

    @Delete
    public void deleteSale(Sales sale);

    @Update
    public void updateCustomer(Customers customers);

    @Insert
    public void insertProduct(Products products);

    @Delete
    public void deleteProduct(Products products);

    @Update
    public void updateProduct(Products products);

    @Insert
    public void insertSale(Sales sales);



}
