package com.example.crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderdatos> {

    ArrayList<EmpleadoBJ> listdatos;

    public AdapterDatos(ArrayList<EmpleadoBJ> listdatos) {
        this.listdatos = listdatos;
    }

    @NonNull
    @Override
    public ViewHolderdatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderdatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderdatos holder, int position) {
        holder.datos.setText(Integer.toString(this.listdatos.get(position).getIdem()));
        holder.nombre.setText(this.listdatos.get(position).getNombre1());
        holder.edad.setText(this.listdatos.get(position).getEdad1());
        holder.telefono.setText(this.listdatos.get(position).getTelefono1());

    }

    @Override
    public int getItemCount() {
        return listdatos.size();
    }

    public class ViewHolderdatos extends RecyclerView.ViewHolder {
        TextView datos,nombre,edad,telefono;
        public ViewHolderdatos(@NonNull View itemView) {
            super(itemView);
            datos=(TextView) itemView.findViewById(R.id.datoid);
            nombre=(TextView) itemView.findViewById(R.id.nombret);
            edad=(TextView) itemView.findViewById(R.id.edadt);
            telefono=(TextView) itemView.findViewById(R.id.telefonot);
        }

        public void asignarDatos(String s) {
            datos.setText(s);
        }
    }
}
