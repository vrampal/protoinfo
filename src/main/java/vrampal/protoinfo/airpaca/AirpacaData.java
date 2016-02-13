package vrampal.protoinfo.airpaca;

import java.util.TreeMap;

public class AirpacaData extends TreeMap<AirpacaCity, AirpacaCityData>{

  private static final long serialVersionUID = 1L;

  public AirpacaCityData create(AirpacaCity city) {
    AirpacaCityData cityData = get(city);
    if (cityData == null) {
      cityData = new AirpacaCityData();
      put(city, cityData);
    }
    return cityData;
  }

}
