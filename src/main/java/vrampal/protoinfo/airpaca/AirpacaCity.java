package vrampal.protoinfo.airpaca;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AirpacaCity {

  AIX_EN_PROVENCE("Aix-en-Provence"),
  AVIGNON("Avignon"),
  CANNES_GRASSE_ANTIBES("Canne-Grasse-Antibes"),
  MARSEILLE("Marseille"),
  NICE("Nice"),
  TOULON("Toulon");

  @Getter
  private final String name;

  public static AirpacaCity valueOfName(String name) {
    for (AirpacaCity city : values()) {
      if (city.getName().equals(name)) {
        return city;
      }
    }
    return null;
  }

}
