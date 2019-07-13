package vrampal.protoinfo.vigilence;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@NoArgsConstructor
public class VigilenceData {

  @Getter
  @Setter
  @JacksonXmlProperty(localName = "EV")
  private VigilenceHeader header;

  @Getter
  @Setter
  @JacksonXmlProperty(localName = "DV")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<VigilenceDepart> depList;

  public VigilenceDepart findDepartment(String depCode) {
    for (VigilenceDepart dep : depList) {
      if (depCode.equals(dep.getDepCode())) {
        return dep;
      }
    }
    return null;
  }

}
