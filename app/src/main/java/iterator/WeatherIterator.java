package iterator;

import models.builder.WeatherDTO;
import models.builder.WeatherDTOData;

public interface WeatherIterator<T> extends Iterator<T> {

    public String getDetail(WeatherDTO weatherDTOData);
}
