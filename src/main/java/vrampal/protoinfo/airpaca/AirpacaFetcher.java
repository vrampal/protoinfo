package vrampal.protoinfo.airpaca;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AirpacaFetcher {

  private static final String URL_NEW = "http://www.airpaca.org/indice/atmo?date[date]=%1$td%%2F%1$tm%%2F%1$tY";

  private static final String URL_OLD = "http://www.atmopaca.org/atmo/indice_atmo.php";

  private static final Pattern TYPO_PATTERN = Pattern.compile("Canne-");

  @SneakyThrows(IOException.class)
  private Document fetchWithLog(String urlStr) {
    if (log.isDebugEnabled()) {
      log.debug("Fetching: " + urlStr);
    }
    Document doc = Jsoup.connect(urlStr).get();
    return doc;
  }

  private Element findTableNew(Element elem) {
    Element table = null;
    Element divIndexTable = elem.getElementById("air-atmo-index-table");
    if (divIndexTable != null) {
      table = divIndexTable.getElementsByTag("table").first();
    }
    return table;
  }

  private Element findTableOld(Element elem) {
    Element table = elem.getElementsByClass("resulttable").first();
    return table;
  }

  private AirpacaLevel parseCellNew(Element cell) {
    String text = cell.text();
    text = text.substring(0, text.indexOf(' '));
    AirpacaLevel level = AirpacaLevel.valueOfLevelStr(text);
    return level;
  }

  private AirpacaLevel parseCellOld(Element cell) {
    String text = cell.text();
    AirpacaLevel level = AirpacaLevel.valueOfLevelStr(text);
    return level;
  }

  private void analyzeTableNew(AirpacaData data, Element table) {
    Element tbody = table.getElementsByTag("tbody").first();
    if (tbody != null) {
      Elements rows = tbody.getElementsByTag("tr");
      for (Element row : rows) {
        Elements cells = row.getElementsByTag("td");
        String cityText = cells.get(0).text();
        cityText = TYPO_PATTERN.matcher(cityText).replaceAll("Cannes-"); // Typo in new site
        AirpacaCity city = AirpacaCity.valueOfName(cityText);
        if (city != null) {
          AirpacaCityData cityData = data.create(city);
          cityData.put(AirpacaDataType.YESTERDAY, parseCellNew(cells.get(1)));
          cityData.put(AirpacaDataType.TODAY, parseCellNew(cells.get(3)));
          cityData.put(AirpacaDataType.TOMORROW, parseCellNew(cells.get(3)));
        }
      }
    }
  }

  private void analyzeTableOld(AirpacaData data, Element table) {
    Element tbody = table.getElementsByTag("tbody").first();
    if (tbody != null) {
      Elements rows = tbody.getElementsByTag("tr");
      for (Element row : rows) {
        Elements cells = row.getElementsByTag("td");
        String cityText = cells.get(0).text();
        AirpacaCity city = AirpacaCity.valueOfName(cityText);
        if (city != null) {
          AirpacaCityData cityData = data.create(city);
          cityData.put(AirpacaDataType.SO2, parseCellOld(cells.get(1)));
          cityData.put(AirpacaDataType.NO2, parseCellOld(cells.get(2)));
          cityData.put(AirpacaDataType.PM10, parseCellOld(cells.get(3)));
          cityData.put(AirpacaDataType.O3, parseCellOld(cells.get(4)));
          cityData.put(AirpacaDataType.TODAY, parseCellOld(cells.get(5)));
          cityData.put(AirpacaDataType.TOMORROW, parseCellOld(cells.get(6)));
          cityData.put(AirpacaDataType.AFTER_TOMORROW, parseCellOld(cells.get(7)));
        }
      }
    }
  }

  public AirpacaData fetch(boolean useNew, boolean useOld) {
    AirpacaData data = new AirpacaData();
    if (useNew) {
      String urlStr = String.format(URL_NEW, new Date());
      Document doc = fetchWithLog(urlStr);
      Element table = findTableNew(doc);
      if (table != null) {
        analyzeTableNew(data, table);
      }
    }
    if (useOld) {
      Document doc = fetchWithLog(URL_OLD);
      Element table = findTableOld(doc);
      if (table != null) {
        analyzeTableOld(data, table);
      }
    }
    return data;
  }

}
