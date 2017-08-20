package vrampal.protoinfo.ecowatt;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EcowattFetcherTest {

  private EcowattFetcher fetcher;

  @Before
  public void setUp() {
    fetcher = new EcowattFetcher();
  }

  @Test
  public void testFetchEcowattRegion() {
    EcowattData data = fetcher.fetch(EcowattRegion.PACA);
    assertNotNull(data);
    data = fetcher.fetch(EcowattRegion.BRETAGNE);
    assertNotNull(data);
  }

}
