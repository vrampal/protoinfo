package vrampal.protoinfo.vigilence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@NoArgsConstructor
public class VigilenceDepart {

  @Getter
  @Setter
  @JacksonXmlProperty(localName = "dep")
  private String depCode;

  @Getter
  @Setter
  @JacksonXmlProperty(localName = "coul")
  private RiskLevel riskLevel;

  @Getter
  @Setter
  @JacksonXmlProperty(localName = "risque")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<RiskTypeTag> riskList = Collections.emptyList();

  public List<RiskType> getRiskTypeList() {
    List<RiskType> riskTypeList = new ArrayList<RiskType>(riskList.size());
    for (RiskTypeTag risk : riskList) {
      riskTypeList.add(risk.getVal());
    }
    return riskTypeList;
  }

}
