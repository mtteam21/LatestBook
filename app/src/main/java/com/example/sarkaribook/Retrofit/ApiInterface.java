package com.example.sarkaribook.Retrofit;

import com.example.sarkaribook.Model.Category;
import com.example.sarkaribook.Model.Subcategory;
import com.example.sarkaribook.Model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("/jewellery/capi/p_user_login.php")
    Call<Res> login(@Body User user);

    @GET("Categories/index")
    Call<List<Category>> getCategories();

    @GET("Subcat/sub_cat/")
    Call<List<Subcategory>> getSubcategories(@Query("id") String id);
}
