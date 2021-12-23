package com.example.sarkaribook.Retrofit;

import android.app.DownloadManager;

import com.example.sarkaribook.Model.Category;
import com.example.sarkaribook.Model.Ebook;
import com.example.sarkaribook.Model.StorePlan;
import com.example.sarkaribook.Model.Subcategory;
import com.example.sarkaribook.Model.User;
import com.example.sarkaribook.Model.UserLogin;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("/jewellery/capi/p_user_login.php")
    Call<Res> login(@Body User user);

    @GET("Categories/index")
    Call<List<Category>> getCategories();

    @GET("Subcat/sub_cat/{id}")
    Call<List<Subcategory>> getSubcategories(@Path("id") String id);

    @GET("Categories/books/{id}")
    Call<List<Ebook>> getEbookList(@Path("id") int id);

    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("Users/verify/contact_number/{contact_number}")
    Call<UserLogin> registerUser(@Path("contact_number") String c_n,@Body UserLogin userLogin);

    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("Users/store_subscription/")
    Call<StorePlan> storePlanDetails(@Body StorePlan storePlan);

    @GET("Users/index")
    Call<List<User>> getUsers();

}
