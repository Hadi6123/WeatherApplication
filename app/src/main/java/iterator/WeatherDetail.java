package iterator;

import models.builder.WeatherDTO;
import models.builder.WeatherDTOData;

public enum WeatherDetail {

    WINDMPH,
    WINDKPH,
    WINDDIR,
    PRECIP_MM,
    PRECIP_IN,
    HUMIDITY;

    /*
    RED,
    ORANGE,
    BLACK,
    GREEN,
    WHITE; */

    public static WeatherIterator<WeatherDetail> getIterator() {
        return new WeatherDetailIterator();
    }

    private static class WeatherDetailIterator implements WeatherIterator<WeatherDetail> {

        private int position;

        @Override
        public boolean hasNext() {
            return position < WeatherDetail.values().length;
        }

        @Override
        public WeatherDetail next() {
            return WeatherDetail.values()[position++];
        }

        @Override
        public String getDetail(WeatherDTO weatherDTOData){
            try{
                if (WeatherDetail.values()[position] == WINDMPH){
                    return weatherDTOData.getWindMPH();
                } else if (WeatherDetail.values()[position] == WINDKPH){
                    return weatherDTOData.getWindKPH();
                } else if (WeatherDetail.values()[position] == WINDDIR){
                    return weatherDTOData.getWindDIR();
                } else if (WeatherDetail.values()[position] == PRECIP_MM){
                    return weatherDTOData.getprecip_mm();
                } else if (WeatherDetail.values()[position] == PRECIP_IN){
                    return weatherDTOData.getprecip_in();
                } else {
                    return weatherDTOData.getHumidity();
                }
            } catch( Exception e){
                return " ";
            }
        }

    }
}
