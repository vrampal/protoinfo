package vrampal.protoinfo.vigilence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@NoArgsConstructor
public class TextTag {

  @Getter
  @Setter
  @JacksonXmlProperty(localName = "texte")
  private String text;

}
