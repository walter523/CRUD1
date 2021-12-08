package com.example.crud;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Empleados.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract EmpleadoDao empleadoDao();
}
