package com.example.crud;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface EmpleadoDao {

    @Query("SELECt * FROM empleados")
    List<Empleados> getAll();

    @Query("UPDATE empleados SET nombre = :n,edad = :e, telefono = :t  WHERE id =:id")
    void update(String n, String e,String t, int id);

    @Query("Delete from empleados WHERE id =:id")
    void delete(int id);

    @Insert
    Long insert(Empleados empleados);
}
