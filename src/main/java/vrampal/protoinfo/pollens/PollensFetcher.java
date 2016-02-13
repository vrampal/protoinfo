package vrampal.protoinfo.pollens;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PollensFetcher {

  private static final String URL_TEMPLATE = "http://www.pollens.fr/docs/d%%20%s.gif";

  private static final int COLUMN_PIXEL = 125;

  private static final int LINE_OFFSET = 46;

  private static final int LINE_PER_POLLEN = 20;

  @SneakyThrows(IOException.class)
  private BufferedImage fetchWithLog(String urlStr) {
    if (log.isDebugEnabled()) {
      log.debug("Fetching: " + urlStr);
    }
    URL url = new URL(urlStr);
    BufferedImage image = ImageIO.read(url);
    return image;
  }

  private void analyzeImage(BufferedImage image, PollensData data) {
    Map<PollenType, PollenLevel> levels = data.getPollenLevels();
    for (PollenType pollen : PollenType.values()) {
      int y = LINE_OFFSET + (pollen.getIndex() * LINE_PER_POLLEN);
      int pixelRgb = image.getRGB(COLUMN_PIXEL, y);
      PollenLevel level = PollenLevel.valueOfRGB(pixelRgb);
      if (level != null) {
        levels.put(pollen, level);
      }
    }
  }

  public PollensData fetchDep(String depCode) {
    String urlStr = String.format(URL_TEMPLATE, depCode);
    BufferedImage image = fetchWithLog(urlStr);
    PollensData data = new PollensData(depCode);
    analyzeImage(image, data);
    return data;
  }

}
