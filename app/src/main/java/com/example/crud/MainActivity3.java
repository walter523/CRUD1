package com.example.crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity3 extends AppCompatActivity {
    String empleado;
    EditText nombre,edad,telefono;
    TextView id;
    Button btna,btnActualizar,btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btna=findViewById(R.id.buttonatras);
        btnActualizar=findViewById(R.id.buttonActualizar);
        btnDelete=findViewById(R.id.buttonDelete);
        nombre= findViewById(R.id.text1);
        id= findViewById(R.id.idempleado);
        edad= findViewById(R.id.text2);
        telefono= findViewById(R.id.text3);
        empleado= getIntent().getStringExtra("empleado");
        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(empleado.split(" ")));
        id.setText(myList.get(0));
        nombre.setText(myList.get(2));
        edad.setText(myList.get(4));
        telefono.setText(myList.get(6));

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regresar();
            }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDataBase db = Room.databaseBuilder(MainActivity3.this,
                        AppDataBase.class, "BaseDeDatosI").allowMainThreadQueries().build();
                //Empleados empleados = new Empleados();
                db.empleadoDao().update(nombre.getText().toString(), edad.getText().toString(), telefono.getText().toString(),Integer.parseInt(id.getText().toString()));
                Toast.makeText(getApplicationContext(),"Actualizado",Toast.LENGTH_LONG).show();
                Regresar();

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder con = new AlertDialog.Builder(MainActivity3.this);
                con.setMessage("Desea borrar este registro");
                con.setTitle("Confirmacion");
                con.setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AppDataBase db = Room.databaseBuilder(MainActivity3.this,
                                AppDataBase.class, "BaseDeDatosI").allowMainThreadQueries().build();
                        //Empleados empleados = new Empleados();
                        db.empleadoDao().delete(Integer.parseInt(id.getText().toString()));
                        Regresar();
                    }
                });
                con.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog de=con.create();
                de.show();


            }
        });
    }
    private void Regresar(){
        Intent siguiente = new Intent(MainActivity3.this,MainActivity.class);
        startActivity(siguiente);
    }
}