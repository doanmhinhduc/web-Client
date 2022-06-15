package com.example.webclient.service;

import com.example.webclient.entity.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductService {
    @GET("/api/v1/product")
    public Call<List<Product>> getProduct();

    @GET("api/v1/product/{id}")
    public Call<Product> getProductDetail(@Path("id") Integer id);

    @POST("api/v1/product")
    public  Call<Product> addProduct(@Body Product product);

    @PUT("api/v1/product/{id}")
    public Call<Boolean> updateProduct(@Path("id") Integer id, @Body Product product);
}
