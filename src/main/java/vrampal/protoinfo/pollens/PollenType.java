package vrampal.protoinfo.pollens;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PollenType {

  CUPRESSACEES(0, "Cupressacées"),
  NOISETIER(1, "Noisetier"),
  AULNE(2, "Aulne"),
  PEUPLIER(3, "Peuplier"),
  SAULE(4, "Saule"),
  FRENE(5, "Frene"),
  CHARME(6, "Charme"),
  BOULEAU(7, "Bouleau"),
  PLATENE(8, "Platene"),
  CHENE(9, "Chene"),
  OLIVIER(10, "Olivier"),
  TILLEUL(11, "Tilleul"),
  CHATAIGNIER(12, "Chataignier"),
  RUMEX(13, "Rumex"),
  GRAMINEES(14, "Graminees"),
  PLANTAIN(15, "Plantain"),
  URTICACEES(16, "Urticacees"),
  ARMOISES(17, "Armoises"),
  AMBROISIE(18, "Ambroisie");

  @Getter
  private final int index;

  @Getter
  private final String name;

}
