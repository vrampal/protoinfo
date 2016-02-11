package vrampal.protoinfo.vigilence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RiskType {

  UNDEFINED(0, ""),
  WIND(1, "Vent violent"),
  RAIN(2, "Pluie-inondation"),
  THUNDERSTORMS(3, "Orages"),
  FLOOD(4, "Inondation"),
  SNOW(5, "Neige-verglas"),
  HEAT(6, "Canicule"),
  COLD(7, "Grand-froid"),
  AVALANCHES(8, "Avalanches"),
  WAVES(9, "Vagues-submersion");

  @Getter
  private final int id;

  @Getter
  private final String name;

}
