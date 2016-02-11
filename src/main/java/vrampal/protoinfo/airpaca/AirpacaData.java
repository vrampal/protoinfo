package vrampal.protoinfo.airpaca;

import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;

public class AirpacaData {

  @Getter
  @Setter
  private Map<AirpacaCity, AirpacaCityData> dataByCities = new TreeMap<>();

  public AirpacaCityData getCityData(AirpacaCity city) {
    return dataByCities.get(city);
  }

}
