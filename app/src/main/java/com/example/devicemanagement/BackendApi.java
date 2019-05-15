package com.example.devicemanagement;

import com.example.devicemanagement.Entities.Device;
import com.example.devicemanagement.Entities.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BackendApi {
    @GET("/users/{login}")
    public Call<User> getUserWithLogin(@Path("login") String login);

    @GET("/users/{login}")
    public Call<User> getUserWithId(@Path("id") int login);

    @GET("/users/{login}")
    public Call<User> getUserWithCreds(@Path("login") String login, @Query("password") String password);

    @POST("/users")
    public Call<User> registerUser(@Body User data);

    // ToDo: ПЕРВЫМ ДЕЛОМ! Эндпоинты по устройствам
    @GET("/users/{id}/devices")
    public Call<Device[]> getUsersDevices(@Path("id") int id);
}
