package repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.R;
import com.example.weatherapp.ShowBasicWeather;

import models.Example;
import models.builder.WeatherDTO;
import models.builder.WeatherDTOBuilder;
import models.builder.WeatherDTODataBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private Application application;
    private MutableLiveData<WeatherDTO> mutableLiveData;
    private WeatherDataService weatherDataService;

    public WeatherRepository(Application application){
        this.application = application;
        this.mutableLiveData = new MutableLiveData<>();
        this.weatherDataService = WeatherRetrofitInstance.getService();
    }

    public MutableLiveData<WeatherDTO> getResult(String q){
        Call<Example> call =  weatherDataService.getCurrentForcast(application.getApplicationContext().getString(R.string.key),
                q,
                1,
                "yes",
                "ye"
                );

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {
                Example result = response.body();

                if (result != null){

                    WeatherDTOBuilder weatherDTOBuilder = new WeatherDTODataBuilder();
                    WeatherDTO weatherDTO = (WeatherDTO) weatherDTOBuilder.setTempf(result.getCurrent().getTempF())
                            .setCondition(result.getCurrent().getCondition())
                            .setFeelc(result.getCurrent().getFeelslikeC())
                            .setFeelf(result.getCurrent().getFeelslikeF())
                            .setName(result.getLocation().getName())
                            .setHumidity(Double.valueOf(result.getCurrent().getHumidity()))
                            .setLocalTime(result.getLocation().getLocaltime())
                            .setTempc(result.getCurrent().getTempC())
                            .setWindDir(result.getCurrent().getWindDir())
                            .setWindMPH(result.getCurrent().getWindMph())
                            .setWindKPH(result.getCurrent().getWindKph())
                            .setPrecip_in(result.getCurrent().getPrecipIn())
                            .setPrecip_mm(result.getCurrent().getPrecipMm())
                            .build();

                    Toast.makeText(application.getApplicationContext(), weatherDTO.getName(), Toast.LENGTH_SHORT).show();
                    mutableLiveData.setValue(weatherDTO);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return mutableLiveData;
    }
}
