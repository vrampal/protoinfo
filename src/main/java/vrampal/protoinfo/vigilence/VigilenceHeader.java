package vrampal.protoinfo.vigilence;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@NoArgsConstructor
public class VigilenceHeader {

  @Getter
  @Setter
  private BigInteger dateinsert;

  @Getter
  @Setter
  private BigInteger dateprevue;

  @Getter
  @Setter
  private BigInteger daterun;

  @Getter
  @Setter
  private BigInteger echeance;

  @Getter
  @Setter
  private BigInteger noversion;

  @Getter
  @Setter
  private String producteur;

  @Getter
  @Setter
  private BigInteger typeprev;

  @Getter
  @Setter
  private String crueint;

  @Getter
  @Setter
  @JacksonXmlProperty(localName = "VCONSEIL")
  private TextTag hint;

  @Getter
  @Setter
  @JacksonXmlProperty(localName = "VCOMMENTAIRE")
  private TextTag comments;

  public String getHintText() {
    return hint.getText();
  }

  public String getCommentsText() {
    return comments.getText();
  }

}
