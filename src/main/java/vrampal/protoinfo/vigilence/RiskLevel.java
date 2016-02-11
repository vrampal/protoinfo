package vrampal.protoinfo.vigilence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RiskLevel {

  UNDEFINED(0, ""),
  GREEN(1, "Vert"),
  YELLOW(2, "Jaune"),
  ORANGE(3, "Orange"),
  RED(4, "Rouge");

  @Getter
  private final int id;

  @Getter
  private final String name;

}
