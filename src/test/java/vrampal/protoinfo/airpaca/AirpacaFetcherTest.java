package vrampal.protoinfo.airpaca;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AirpacaFetcherTest {

  private AirpacaFetcher fetcher;

  @Before
  public void setUp() {
    fetcher = new AirpacaFetcher();
  }

  @Test
  public void testFetch() {
    AirpacaData data = fetcher.fetch(true, true);
    assertNotNull(data);
  }

}
