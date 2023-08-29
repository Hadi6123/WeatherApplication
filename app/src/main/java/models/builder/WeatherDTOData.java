package models.builder;

import models.Condition;

public class WeatherDTOData implements WeatherDTO{

    private int id;
    private String name;
    private String localTime;
    private String tempc;
    private String feelc;
    private String tempf;
    private String feelf;
    private Condition condition;
    private String windMPH;
    private String windKPH;
    private String windDir;
    private String precip_mm;
    private String precip_in;
    private String humidity;

    public WeatherDTOData() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLocalTime() {
        return localTime;
    }

    @Override
    public String getTempC() {
        return tempc;
    }

    @Override
    public String getFeelC() {
        return feelc;
    }

    @Override
    public String getTempF() {
        return tempf;
    }

    @Override
    public String getFeelF() {
        return feelf;
    }

    @Override
    public Condition getCondition() {
        return condition;
    }

    @Override
    public String getWindMPH() {
        return windMPH;
    }

    @Override
    public String getWindKPH() {
        return windKPH;
    }

    @Override
    public String getWindDIR() {
        return windDir;
    }

    @Override
    public String getprecip_mm() {
        return precip_mm;
    }

    @Override
    public String getprecip_in() {
        return precip_in;
    }

    @Override
    public String getHumidity() {
        return humidity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public void setTempc(String tempc) {
        this.tempc = tempc;
    }

    public void setFeelc(String feelc) {
        this.feelc = feelc;
    }

    public void setTempf(String tempf) {
        this.tempf = tempf;
    }

    public void setFeelf(String feelf) {
        this.feelf = feelf;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setWindMPH(String windMPH) {
        this.windMPH = windMPH;
    }

    public void setWindKPH(String windKPH) {
        this.windKPH = windKPH;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public void setPrecip_mm(String precip_mm) {
        this.precip_mm = precip_mm;
    }

    public void setPrecip_in(String precip_in) {
        this.precip_in = precip_in;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
