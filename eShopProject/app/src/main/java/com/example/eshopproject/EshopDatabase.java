package com.example.eshopproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Customers.class,Products.class,Sales.class},version = 1)
public abstract class EshopDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
