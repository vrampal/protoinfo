package vrampal.protoinfo.airpaca;

import java.util.TreeMap;

public class AirpacaCityData extends TreeMap<AirpacaDataType, AirpacaLevel> {

  private static final long serialVersionUID = 1L;

  public AirpacaLevel getToday() {
    return get(AirpacaDataType.TODAY);
  }

  public AirpacaLevel getTomorrow() {
    return get(AirpacaDataType.TOMORROW);
  }

}
