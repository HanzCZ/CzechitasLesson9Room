package cz.czechitas.janhanak.czechitaslesson9.service;

import java.util.List;

import cz.czechitas.janhanak.czechitaslesson9.data.Movie;
import cz.czechitas.janhanak.czechitaslesson9.data.LoginAnswer;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("/movies")
    Call<List<Movie>> getAllMovies();

    @FormUrlEncoded
    @POST("/login")
    Call<LoginAnswer> login(
            @Field("user") String user,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/loginError")
    Call<LoginAnswer> loginError(
            @Field("user") String user,
            @Field("password") String password
    );
}