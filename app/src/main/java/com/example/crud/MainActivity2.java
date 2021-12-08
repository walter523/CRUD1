package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText edt1,edt2,edt3;
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edt1 = findViewById(R.id.Edit1);
        edt2 = findViewById(R.id.Edit2);
        edt3 = findViewById(R.id.Edit3);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regresar();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDataBase db = Room.databaseBuilder(MainActivity2.this,
                        AppDataBase.class, "BaseDeDatosI").allowMainThreadQueries().build();
                Empleados empleados = new Empleados(edt1.getText().toString(), edt2.getText().toString(), edt3.getText().toString());
                Long reg = db.empleadoDao().insert(empleados);
                Toast.makeText(getApplicationContext(),"Agregado",Toast.LENGTH_LONG).show();
                Regresar();
            }
        });
    }
    private void Regresar(){
        Intent siguiente = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(siguiente);
    }
}