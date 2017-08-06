package vrampal.protoinfo.ecowatt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EcowattLevel {

  REASONABLE(1, "Verte"),
  VERY_HIGH(2, "Orange"),
  EXTREME(3, "Rouge");

  @Getter
  private final int level;

  @Getter
  private final String color;

  public static EcowattLevel valueOfColor(String color) {
    for (EcowattLevel level : values()) {
      if (level.getColor().equalsIgnoreCase(color)) {
        return level;
      }
    }
    return null;
  }

}
