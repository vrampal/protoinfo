package vrampal.protoinfo.airpaca;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AirpacaFetcher {

  private static final String URL = "http://www.airpaca.org/indice/atmo";

  @SneakyThrows(IOException.class)
  private Document fetchWithLog(String urlStr) {
    if (log.isDebugEnabled()) {
      log.debug("Fetching: " + urlStr);
    }
    Document doc = Jsoup.connect(urlStr).get();
    return doc;
  }

  private Element findTable(Element elem) {
    Element table = null;
    Element divIndexTable = elem.getElementById("air-atmo-index-table");
    if (divIndexTable != null) {
      table = divIndexTable.getElementsByTag("table").first();
    }
    return table;
  }

  private AirpacaData parseTable(Element table) {
    AirpacaData data = new AirpacaData();
    if (table != null) {
      Element tbody = table.getElementsByTag("tbody").first();
      if (tbody != null) {
        Elements rows = tbody.getElementsByTag("tr");
        for (Element row : rows) {
          Elements cells = row.getElementsByTag("td");
          String cityText = cells.get(0).text();
          AirpacaCity city = AirpacaCity.valueOfName(cityText);
          if (city != null) {
            AirpacaCityData cityData = new AirpacaCityData();

            String todayText = cells.get(3).text();
            todayText = todayText.substring(0, todayText.indexOf(' '));
            cityData.setToday(AirpacaLevel.valueOfLevelStr(todayText));

            String tomorowText = cells.get(5).text();
            tomorowText = tomorowText.substring(0, tomorowText.indexOf(' '));
            cityData.setTomorow(AirpacaLevel.valueOfLevelStr(tomorowText));

            data.getDataByCities().put(city, cityData);
          }
        }
      }
    }
    return data;
  }

  public AirpacaData fetch() {
    Document doc = fetchWithLog(URL);
    Element table = findTable(doc);
    AirpacaData data = parseTable(table);
    return data;
  }

}
