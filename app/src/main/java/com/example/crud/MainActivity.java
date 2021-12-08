package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    ListView txt3;
    RecyclerView r1;
   // ArrayList<EmpleadosBJ> listaempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button3);
        txt3 = findViewById(R.id.list1);
        //r1= findViewById(R.id.recyclerid);
      //  r1.setLayoutManager(new LinearLayoutManager(this));
        Mostrar();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(siguiente);
            }
        });
    }
    String dato="";
    private void Mostrar(){
        AppDataBase db = Room.databaseBuilder(MainActivity.this,
                AppDataBase.class, "BaseDeDatosI").allowMainThreadQueries().build();
        List<Empleados> lista = db.empleadoDao().getAll();

        ArrayList<EmpleadoBJ> listaempleado= new ArrayList<>();

        String[] valores= new String[lista.size()];

       for(int i = 0; i<lista.size();i++){

          //empleadoBJ= new EmpleadoBJ(lista.get(i).getId(),lista.get(i).nombre,lista.get(i).edad,lista.get(i).telefono);
            valores[i] =""+lista.get(i).getId()+" Nombre: "+lista.get(i).nombre+" edad: "+lista.get(i).edad+" telefono: "+lista.get(i).telefono+" ";

       }
       // ArrayList<String> myList = new ArrayList<String>(Arrays.asList(valores.split(",")));
       // AdapterDatos adaptador= new AdapterDatos(listaempleado);
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,valores);
        txt3.setAdapter(adaptador);
        txt3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dato = valores[position];
                Enviar();
            }
        });
    }
    private void Enviar(){
        Intent inte = new Intent(MainActivity.this,MainActivity3.class);
        inte.putExtra("empleado",dato);
        startActivity(inte);

    }
}