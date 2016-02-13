package vrampal.protoinfo.airpaca;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AirpacaCity {

  AIX_EN_PROVENCE("Aix-en-Provence"),
  AUBAGNE("Aubagne"),
  AVIGNON("Avignon"),
  BRIGNOLES("Brignoles"),
  CANNES_GRASSE_ANTIBES("Cannes-Grasse-Antibes"),
  CANNE_GRASSE_ANTIBES("Canne-Grasse-Antibes"), // Typo in new site :(
  GAP("Gap"),
  HYERES("Hyères"),
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
