package com.crmeoj.simarropop.api;

import com.crmeoj.simarropop.pojo.Product;
import com.crmeoj.simarropop.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoAPI {

    @GET("articulos")
    Call<ArrayList<Product>> getAll();


}
