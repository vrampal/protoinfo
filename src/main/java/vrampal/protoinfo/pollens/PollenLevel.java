package vrampal.protoinfo.pollens;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PollenLevel {

  NONE(0, 0xff000000),
  LOW1(1, 0xff00ff00),
  LOW2(2, 0xff00b050),
  MED1(3, 0xffffff00),
  MED2(4, 0xfff79646),
  HIGH(5, 0xffff0000);

  @Getter
  private final int level;

  @Getter
  private final int rgb;

  public static PollenLevel valueOfRGB(int rgb) {
    for (PollenLevel level : values()) {
      if (level.rgb == rgb) {
        return level;
      }
    }
    return null;
  }

}
