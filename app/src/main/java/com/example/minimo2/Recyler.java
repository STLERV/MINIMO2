package com.example.minimo2;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;


public class Recyler extends RecyclerView.Adapter<Recyler.ViewHolder> {

    public Recyler(Context context) {
        this.context = context;
        this.listaelementos = new ArrayList<>();
    }

    private Context context;
    private List<Element> listaelementos;

    public Recyler(List<Element> lsitaelementos) {
        this.listaelementos = lsitaelementos;
    }


    public void rellenarLista (List<Element> elementList) {
        listaelementos.addAll(elementList);
        notifyDataSetChanged();

    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Element element =listaelementos.get(i);
        viewHolder.ineMunicipiView.setText(element.getIne());
        viewHolder.nomMunicipiView.setText(element.getMunicipiNom());
        Picasso.with(context).load(element.getMunicipiEscut()).into(viewHolder.escutMuncipi);
    }

    @Override
    public int getItemCount() {
        return listaelementos.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout constraintLayout;
        private TextView nomMunicipiView;
        private TextView ineMunicipiView;
        private ImageView escutMuncipi;

        public ViewHolder(View v){
            super(v);

            constraintLayout = v.findViewById(R.id.constraintLayout);
            nomMunicipiView = v.findViewById(R.id.nomMunicipi);
            ineMunicipiView = v.findViewById(R.id.numeroIne);
            escutMuncipi = v.findViewById(R.id.escutMunicipi);



        }

    }
}