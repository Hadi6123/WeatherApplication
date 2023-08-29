package repository;

import models.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherDataService {

    // Base Url
    // https://api.themoviedb.org/3/
    //
    // End Point Url
    // movie/popular?api_key=890a86f5656fdca2767b6be3222e3526
    @GET("v1/current.json")
    Call<Example> getCurrentForcast(@Query("key") String key, @Query("q") String q, @Query("days") int days, @Query("aqi") String aqi, @Query("alerts") String alerts);
}
