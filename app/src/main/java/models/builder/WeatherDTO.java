package models.builder;

import models.Condition;

public interface WeatherDTO {

    int getId();

    String getName();

    String getLocalTime();

    String getTempC();

    String getFeelC();

    String getTempF();

    String getFeelF();

    Condition getCondition();

    String getWindMPH();

    String getWindKPH();

    String getWindDIR();

    String getprecip_mm();

    String getprecip_in();

    String getHumidity();

}