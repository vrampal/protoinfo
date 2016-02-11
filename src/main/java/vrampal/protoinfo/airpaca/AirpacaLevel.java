package vrampal.protoinfo.airpaca;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AirpacaLevel {

  NIV1(1, "1", "Très bon"),
  NIV2(2, "2", "Très bon"),
  NIV3(3, "3", "Bon"),
  NIV4(4, "4", "Bon"),
  NIV5(5, "5", "Moyen"),
  NIV6(6, "6", "Médiocre"),
  NIV7(7, "7", "Médiocre"),
  NIV8(8, "8", "Mauvais"),
  NIV9(9, "9", "Mauvais"),
  NIV10(10, "10", "Très mauvais");


  @Getter
  private final int level;

  @Getter
  private final String levelStr;

  @Getter
  private final String desc;

  public static AirpacaLevel valueOfLevelStr(String levelStr) {
    for (AirpacaLevel level : values()) {
      if (level.getLevelStr().equals(levelStr)) {
        return level;
      }
    }
    return null;
  }


}
