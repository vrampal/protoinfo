package vrampal.protoinfo.vigilence;

import java.io.IOException;
import java.net.URL;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Slf4j
public class VigilenceFetcher {

  private static final String URL = "http://vigilance.meteofrance.com/data/NXFR33_LFPW_.xml";

  private final ObjectMapper objectMapper = new XmlMapper();

  @SneakyThrows(IOException.class)
  private <T> T fetchWithLog(String urlStr, Class<T> valueType) {
    if (log.isDebugEnabled()) {
      log.debug("Fetching: " + urlStr);
    }
    URL url = new URL(urlStr);
    T value = objectMapper.readValue(url, valueType);
    return value;
  }

  public VigilenceData fetch() {
    return fetchWithLog(URL, VigilenceData.class);
  }

  public VigilenceData fetch(String urlStr) {
    return fetchWithLog(urlStr, VigilenceData.class);
  }

}
