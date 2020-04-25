package com.example.eshopproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Query("SELECT * FROM customers")
    public List<Customers> getCustomers();

    @Query("SELECT password FROM customers WHERE username=:input")
    public String getAuth(String input);

    @Insert
    public void insertCustomer(Customers customers);

    @Delete
    public void deleteCustomer(Customers customers);

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
