package com.example.minimo2;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public List<Element> listaelementos;

    private DibaApi dibaApi;
    public Recyler recyler;
    public RecyclerView recylerview;
    TextView textViewIne;

    TextView textViewNameTown;
    ImageView ivImageFromUrl;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recylerview = (RecyclerView) findViewById(R.id.RecyclerView);
        recyler = new Recyler(this);
        recylerview.setAdapter(recyler);
        recylerview.setLayoutManager(new LinearLayoutManager(this));

        textViewIne = findViewById(R.id.numeroIne);
        textViewNameTown = findViewById(R.id.nomMunicipi);
        ivImageFromUrl = findViewById(R.id.escutMunicipi);
        dibaApi = DibaApi.retrofit.create(DibaApi.class);
        getData();
    }


     private void getData(){

        Call<Cities> elementCall = dibaApi.getData(1, 11);
        elementCall.enqueue(new Callback<Cities>() {
            @Override
            public void onResponse(Call<Cities> call, Response<Cities> response) {

                Cities cities = response.body();

                List<Element> elementList = cities.getElements();

                for(int i = 0; i<elementList.size(); i++){
                                   }

                recyler.rellenarLista(elementList);



            }

            @Override
            public void onFailure(Call<Cities> call, Throwable t) {

            }
        });

     }

}