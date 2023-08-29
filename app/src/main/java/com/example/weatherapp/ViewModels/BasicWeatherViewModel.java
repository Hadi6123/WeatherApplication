package com.example.weatherapp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import models.builder.WeatherDTO;
import repository.WeatherRepository;

public class BasicWeatherViewModel extends AndroidViewModel {

    private WeatherRepository weatherRepository;
    private MutableLiveData<WeatherDTO> weatherDTOMutableLiveData;

    private String city, tempurature, condition, feelsLike, image;
    private MutableLiveData<String> mCity, mTemp, mCondition, mFeelsLike, imageData;

    private Boolean alrSearched;
    private MutableLiveData<Boolean> getBoolResult;

    public BasicWeatherViewModel(@NonNull Application application) {
        super(application);
        weatherRepository = new WeatherRepository(application);
        weatherDTOMutableLiveData = new MutableLiveData<>();

        mCity = new MutableLiveData<>();
        mTemp = new MutableLiveData<>();
        mCondition = new MutableLiveData<>();
        mFeelsLike = new MutableLiveData<>();
        imageData = new MutableLiveData<>();

        city = "";
        tempurature = "";
        condition = "";
        feelsLike = "";
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGpd7oar9qVRLdEi9N804-0YWif-FyrfITkA&usqp=CAU";

        getBoolResult = new MutableLiveData<>();
        alrSearched = false;

    }


    public LiveData<WeatherDTO> getWeatherDTOMutableLiveData(String city){
        return (weatherRepository.getResult(city));
        //return weatherDTOMutableLiveData;
    }

    /*
    public MutableLiveData<WeatherDTO> getWeatherDTOMutableLiveData(String city){
        weatherDTOMutableLiveData = (weatherRepository.getResult(city));
        return weatherDTOMutableLiveData;
    }

    public void updateWeather(String city){
        weatherDTOMutableLiveData = (weatherRepository.getResult(city));
    }  */

    public MutableLiveData<String> getmCity(){
        mCity.postValue(city);
        return mCity;
    }

    public MutableLiveData<String> getmTemp(){
        mTemp.postValue(tempurature);
        return mTemp;
    }

    public MutableLiveData<String> getmCondition(){
        mCondition.postValue(condition);
        return mCondition;
    }

    public MutableLiveData<String> getmFeelsLike(){
        mFeelsLike.postValue(feelsLike);
        return mFeelsLike;
    }

    public MutableLiveData<Boolean> getGetBoolResult(){
        getBoolResult.postValue(alrSearched);
        return getBoolResult;
    }

    public MutableLiveData<String> getImageData(){
        imageData.postValue(image);
        return imageData;
    }

    public void updateCity(String input){
        city = input;
        mCity.postValue(input);
    }

    public void updateTemp(String input){
        tempurature = input;
        mTemp.postValue(input);
    }

    public void updateCondition(String input){
        condition = input;
        mCondition.postValue(input);
    }

    public void updateFeelsLike(String input){
        feelsLike = input;
        mFeelsLike.postValue(input);
    }

    public void setAlrSearched(Boolean bool){
        alrSearched = bool;
        getBoolResult.postValue(bool);
    }

    public void setImageData(String input){
        image = input;
        imageData.postValue(input);
    }


}
