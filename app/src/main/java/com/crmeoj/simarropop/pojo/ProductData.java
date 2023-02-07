package com.crmeoj.simarropop.pojo;

import com.crmeoj.simarropop.api.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductData {

    public static int ID = 0;

    public static ArrayList<Product> PRODUCTS = new ArrayList<>();
    public static ArrayList<Product> FAVORITES = new ArrayList<>();

    public static ArrayList<Product> recuperarData() {

        ApiService apiService = new ApiService();

        apiService.getAll(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {

                if (response.isSuccessful()) {



                }

            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });

        return PRODUCTS;

    }


}
