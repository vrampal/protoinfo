package vrampal.protoinfo.ecowatt;

import lombok.Getter;
import lombok.Setter;

public class EcowattData {

  @Getter
  @Setter
  private EcowattLevel today;

  @Getter
  @Setter
  private EcowattLevel tomorow;

}
