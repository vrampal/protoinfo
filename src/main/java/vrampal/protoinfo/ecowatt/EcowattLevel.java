package vrampal.protoinfo.ecowatt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EcowattLevel {

  REASONABLE(1, "vert"),
  VERY_HIGH(2, "orange"),
  EXTREME(3, "rouge");

  @Getter
  private final int level;

  @Getter
  private final String color;

  public static EcowattLevel valueOfColor(String color) {
    for (EcowattLevel level : values()) {
      if (level.getColor().equals(color)) {
        return level;
      }
    }
    return null;
  }

}
