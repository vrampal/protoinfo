package vrampal.protoinfo.ecowatt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EcowattRegion {

  PACA("http://www.ecowatt-paca.fr/restez-au-courant/alertes-2/"),
  BRETAGNE("http://www.ecowatt-bretagne.fr/restez-au-courant/alertes-2/");

  @Getter
  private final String urlStr;

}
