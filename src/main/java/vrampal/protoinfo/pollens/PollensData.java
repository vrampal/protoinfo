package vrampal.protoinfo.pollens;

import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class PollensData {

  @Getter
  private final String depCode;

  @Getter
  @Setter
  private Map<PollenType, PollenLevel> pollenLevels = new TreeMap<>();

}
