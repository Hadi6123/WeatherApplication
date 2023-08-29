package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.ViewModels.BasicWeatherViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import adapter.DetailAdapter;
import iterator.Iterator;
import iterator.WeatherDetail;
import iterator.WeatherIterator;
import models.DetailModels.ExtraDeail;
import models.builder.WeatherDTO;

public class ShowBasicWeather extends AppCompatActivity {

    private View homeRl, loadingPB;
    private EditText cityEdt;
    private TextView  cityNameTV, temperatureTV, conditionTV, feelsLikeTemperatureTV;
    private ImageView iconTV, backTv, searchTV;
    private RecyclerView weatherRv;

    private BasicWeatherViewModel basicWeatherViewModel;

    private Boolean searchedOnce;

    private LiveData<WeatherDTO> weatherDTOLiveData;
    private LiveData<String> cityLiveData, tempLiveData, conditionLiveData, feelsLikeLiveData, imageLoader;

    private LiveData<Boolean> getAlrSearched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_basic_weather);

        searchedOnce = false;

        homeRl = findViewById(R.id.idRLHome);
        loadingPB = findViewById(R.id.idPBLoading);
        cityNameTV = findViewById(R.id.idTVCityName);

        temperatureTV = findViewById(R.id.idInfo);

        conditionTV = findViewById(R.id.idTVCondition);
        weatherRv = findViewById(R.id.idRvWeather);
        cityEdt = findViewById(R.id.idTILCity);
        backTv = findViewById(R.id.idIVBack);
        iconTV = findViewById(R.id.idTVIcon);
        feelsLikeTemperatureTV = findViewById(R.id.idTVTemperatureFeelsLike);

        searchTV = findViewById(R.id.idTVSearch);

        basicWeatherViewModel = new ViewModelProvider(this).get(BasicWeatherViewModel.class);

        cityLiveData = basicWeatherViewModel.getmCity();
        tempLiveData = basicWeatherViewModel.getmTemp();
        conditionLiveData = basicWeatherViewModel.getmCondition();
        feelsLikeLiveData = basicWeatherViewModel.getmFeelsLike();
        getAlrSearched = basicWeatherViewModel.getGetBoolResult();
        imageLoader = basicWeatherViewModel.getImageData();

        cityLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                cityNameTV.setText(s);
            }
        });

        tempLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                temperatureTV.setText(s);
            }
        });

        conditionLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                conditionTV.setText(s);
            }
        });

        feelsLikeLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                feelsLikeTemperatureTV.setText(s);
            }
        });

        getAlrSearched.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                searchedOnce = aBoolean;
            }
        });

        imageLoader.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Picasso.get().load(s).into(iconTV);
            }
        });

        searchTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cityEdt.getText().toString() != null){
                    if (searchedOnce){
                        //basicWeatherViewModel.updateWeather(cityEdt.getText().toString());
                        basicWeatherViewModel.getWeatherDTOMutableLiveData(cityEdt.getText().toString()).observe(ShowBasicWeather.this,
                                new Observer<WeatherDTO>() {
                                    @Override
                                    public void onChanged(WeatherDTO weatherDTO) {
                                        getOutcomes(weatherDTO);
                                    }
                                });
                    } else{

                        basicWeatherViewModel.getWeatherDTOMutableLiveData(cityEdt.getText().toString()).observe(ShowBasicWeather.this,
                                new Observer<WeatherDTO>() {
                                    @Override
                                    public void onChanged(WeatherDTO weatherDTO) {
                                        getOutcomes(weatherDTO);

                                    }
                                });
                            }
                        }
                        //searchedOnce = true;

                    }
                });

    }

    private void getOutcomes(WeatherDTO weatherDTO){
        basicWeatherViewModel.updateCity(weatherDTO.getName());
        basicWeatherViewModel.updateTemp(weatherDTO.getTempC());
        basicWeatherViewModel.updateCondition(weatherDTO.getLocalTime());
        basicWeatherViewModel.updateFeelsLike(weatherDTO.getFeelC());

        basicWeatherViewModel.setImageData("http:"+ weatherDTO.getCondition().getIcon());

        WeatherIterator<WeatherDetail> iter =  WeatherDetail.getIterator();

        ExtraDeail plainDetail = new ExtraDeail();
        List<ExtraDeail> listDetails = new ArrayList<>();

        while(iter.hasNext()) {
            iter.next();
            String info = iter.getDetail(weatherDTO);

            try {
                ExtraDeail newDetail = (ExtraDeail) plainDetail.clone();
                newDetail.setName(info);
                listDetails.add(newDetail);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        weatherRv.setAdapter(new DetailAdapter(listDetails.subList(0, listDetails.size()-1)));


        basicWeatherViewModel.setAlrSearched(true);
    }
}