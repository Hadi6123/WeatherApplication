package models.builder;

import models.Condition;

public class WeatherDTODataBuilder implements WeatherDTOBuilder{

    private String name;
    private String localTime;
    private Double tempc;
    private Double feelc;
    private Double tempf;
    private Double feelf;
    private Condition condition;
    private Double windMPH;
    private Double windKPH;
    private String windDir;
    private Double precip_mm;
    private Double precip_in;
    private Double humidity;


    @Override
    public WeatherDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public WeatherDTOBuilder setLocalTime(String localTime) {
        this.localTime = localTime;
        return this;
    }

    @Override
    public WeatherDTOBuilder setTempc(Double tempc) {
        this.tempc = tempc;
        return this;
    }

    @Override
    public WeatherDTOBuilder setFeelc(Double feelc) {
        this.feelc = feelc;
        return this;
    }

    @Override
    public WeatherDTOBuilder setTempf(Double tempf) {
        this.tempf = tempf;
        return this;
    }

    @Override
    public WeatherDTOBuilder setFeelf(Double feelf) {
        this.feelf = feelf;
        return this;
    }

    @Override
    public WeatherDTOBuilder setCondition(Condition condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public WeatherDTOBuilder setWindMPH(Double windMPH) {
        this.windMPH = windMPH;
        return this;
    }

    @Override
    public WeatherDTOBuilder setWindKPH(Double windKPH) {
        this.windKPH = windKPH;
        return this;

    }

    @Override
    public WeatherDTOBuilder setWindDir(String windDir) {
        this.windDir = windDir;
        return this;
    }

    @Override
    public WeatherDTOBuilder setPrecip_mm(Double precip_mm) {
        this.precip_mm = precip_mm;
        return this;
    }

    @Override
    public WeatherDTOBuilder setPrecip_in(Double precip_in) {
        this.precip_in = precip_in;
        return this;
    }

    @Override
    public WeatherDTOBuilder setHumidity(Double humidity) {
        this.humidity = humidity;
        return this;
    }

    @Override
    public WeatherDTO build() {
        WeatherDTOData weatherDTO = new WeatherDTOData();

        weatherDTO.setName(condition.getText() + " at " + name);
        weatherDTO.setLocalTime(localTime);

        weatherDTO.setTempc( "Real Temperature: " + tempc + " °C");
        weatherDTO.setFeelc("Feels Like: " + feelc + " °C");
        weatherDTO.setTempf("Real Temperature: " + tempf + " °F");
        weatherDTO.setFeelf("Feels Like: " + feelf + " °F");

        weatherDTO.setCondition(condition);

        weatherDTO.setWindKPH("Wind Speed (Km/h): " + windKPH);
        weatherDTO.setWindMPH("Wind Speed (Mph): " + windMPH);
        weatherDTO.setWindDir("Wind Direction: " + windDir);

        weatherDTO.setPrecip_mm("Precipitation Amount (mm): " + precip_mm);
        weatherDTO.setPrecip_in("Precipitation Amount (inches): " + precip_in);
        weatherDTO.setHumidity("Humidity (%): " + humidity);

        return weatherDTO;

    }

    @Override
    public WeatherDTO getTaskDTO() {
        return null;
    }
}
