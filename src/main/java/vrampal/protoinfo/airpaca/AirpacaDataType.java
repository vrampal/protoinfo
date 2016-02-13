package vrampal.protoinfo.airpaca;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AirpacaDataType {

  SO2("SO<sub>2</sub>"),
  NO2("NO<sub>2</sub>"),
  PM10("PM<sub>2</sub>"),
  O3("O<sub>3</sub>"),
  YESTERDAY(""),
  TODAY("Global"),
  TOMORROW("Demain"),
  AFTER_TOMORROW("Après-demain");

  @Getter
  private final String oldHtml;

  public static AirpacaDataType valueOfOldHtml(String oldHtml) {
    for (AirpacaDataType value : values()) {
      if (value.getOldHtml().equals(oldHtml)) {
        return value;
      }
    }
    return null;
  }

}
