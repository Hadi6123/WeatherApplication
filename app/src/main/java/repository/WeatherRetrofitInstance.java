package repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "http://api.weatherapi.com/";

    public static WeatherDataService getService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(WeatherDataService.class);
    }


}
