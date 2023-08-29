package models.builder;

import models.Condition;

public interface WeatherDTOBuilder {

    public WeatherDTOBuilder setName(String name);

    public WeatherDTOBuilder setLocalTime(String localTime);

    public WeatherDTOBuilder setTempc(Double tempc);

    public WeatherDTOBuilder setFeelc(Double feelc) ;

    public WeatherDTOBuilder setTempf(Double tempf) ;

    public WeatherDTOBuilder setFeelf(Double feelf) ;

    public WeatherDTOBuilder setCondition(Condition condition);

    public WeatherDTOBuilder setWindMPH(Double windMPH);

    public WeatherDTOBuilder setWindKPH(Double windKPH);

    public WeatherDTOBuilder setWindDir(String windDir);

    public WeatherDTOBuilder setPrecip_mm(Double precip_mm);

    public WeatherDTOBuilder setPrecip_in(Double precip_in);

    public WeatherDTOBuilder setHumidity(Double humidity);

    //to "assemble" final product
    WeatherDTO build();

    //(optional) method to fetch already built object
    WeatherDTO getTaskDTO();
}
