package vrampal.protoinfo;

import java.util.Map;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;
import vrampal.protoinfo.airpaca.AirpacaCity;
import vrampal.protoinfo.airpaca.AirpacaCityData;
import vrampal.protoinfo.airpaca.AirpacaData;
import vrampal.protoinfo.airpaca.AirpacaFetcher;
import vrampal.protoinfo.ecowatt.EcowattData;
import vrampal.protoinfo.ecowatt.EcowattFetcher;
import vrampal.protoinfo.ecowatt.EcowattRegion;
import vrampal.protoinfo.pollens.PollenLevel;
import vrampal.protoinfo.pollens.PollenType;
import vrampal.protoinfo.pollens.PollensData;
import vrampal.protoinfo.pollens.PollensFetcher;
import vrampal.protoinfo.vigilence.RiskType;
import vrampal.protoinfo.vigilence.VigilenceData;
import vrampal.protoinfo.vigilence.VigilenceDepart;
import vrampal.protoinfo.vigilence.VigilenceFetcher;

@Slf4j
public class ProtoInfoApp {

  private static final String SEPAR = "----------";

  public static void main(String[] args) {
    new ProtoInfoApp().run();
  }

  private final AirpacaFetcher airpacaFetcher = new AirpacaFetcher();

  private final EcowattFetcher ecowatFetcher = new EcowattFetcher();

  private final PollensFetcher pollensFetcher = new PollensFetcher();

  private final VigilenceFetcher vigilenceFetch = new VigilenceFetcher();

  public void run() {
    protoAirPaca();
    //protoEcowatt();
    //protoPollens();
    protoVigilence();
  }

  private void protoAirPaca() {
    AirpacaData data = airpacaFetcher.fetch(true, true);

    for (Entry<AirpacaCity, AirpacaCityData> entry : data.entrySet()) {
      log.info(entry.toString());
      AirpacaCity city = entry.getKey();
      AirpacaCityData cityData = entry.getValue();
      String msg = String.format("City : %s - Today : %d - Tomorow : %d", city.getName(),
          cityData.getToday().getLevel(), cityData.getTomorrow().getLevel());
      log.info(msg);
    }
    log.info(SEPAR);
  }

  private void protoEcowatt() {
    EcowattData data = ecowatFetcher.fetch(EcowattRegion.PACA);

    String msg = String.format("Today : %d - Tomorow : %d", data.getToday().getLevel(), data.getTomorow().getLevel());
    log.info(msg);
    log.info(SEPAR);
  }

  private void protoPollens() {
    PollensData pollens = pollensFetcher.fetchDep("06");

    Map<PollenType, PollenLevel> levels = pollens.getPollenLevels();
    for (Entry<PollenType, PollenLevel> entry : levels.entrySet()) {
      String msg = String.format("%s : %d", entry.getKey().getName(), entry.getValue().getLevel());
      log.info(msg);
    }
    log.info(SEPAR);
  }

  private void protoVigilence() {
    VigilenceData cv = vigilenceFetch.fetch();

    VigilenceDepart dv = cv.findDepartment("06");
    String msg = String.format("Departement : %s - vigilance : %s", dv.getDepCode(), dv.getRiskLevel().getName());
    log.info(msg);
    for (RiskType risque : dv.getRiskTypeList()) {
      msg = String.format("Risque : %s", risque.getName());
      log.info(msg);
    }
    log.info(SEPAR);
  }

}
