package vrampal.protoinfo.ecowatt;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EcowattFetcher {

  @SneakyThrows(IOException.class)
  private Document fetchWithLog(String urlStr) {
    if (log.isDebugEnabled()) {
      log.debug("Fetching: " + urlStr);
    }
    Document doc = Jsoup.connect(urlStr).get();
    return doc;
  }

  private String findMessage(Element elem) {
    String message = null;
    Element divAlerte = elem.getElementsByClass("alertes").first();
    if (divAlerte != null) {
      Element img = divAlerte.getElementsByTag("img").first();
      if (img != null) {
          message = img.attr("alt");
      }
    }
    return message;
  }

  private EcowattData parseMessage(String message) {
    EcowattData data = null;
    if (message != null) {
      String[] elements = message.split(" ");
      if (elements.length == 3) {
        data = new EcowattData();
        data.setToday(EcowattLevel.valueOfColor(elements[1]));
        data.setTomorow(EcowattLevel.valueOfColor(elements[2]));
      }
    }
    return data;
  }

  public EcowattData fetch(String urlStr) {
    Document doc = fetchWithLog(urlStr);
    String message = findMessage(doc);
    EcowattData data = parseMessage(message);
    return data;
  }

  public EcowattData fetch(EcowattRegion region) {
    return fetch(region.getUrlStr());
  }

}
