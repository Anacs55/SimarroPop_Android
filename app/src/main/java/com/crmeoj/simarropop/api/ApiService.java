package com.crmeoj.simarropop.api;

import com.crmeoj.simarropop.pojo.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private ProductoAPI productoAPI;
    private Call<ArrayList<Product>> allProductsInfoCall;


    public ApiService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.10:8080/simarropop/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        productoAPI = retrofit.create(ProductoAPI.class);

    }

    public void getAll(Callback<ArrayList<Product>> callback) {

        allProductsInfoCall = productoAPI.getAll();
        allProductsInfoCall.enqueue(callback);

    }

}
