package vrampal.protoinfo.vigilence;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class VigilenceFetcherTest {

  private VigilenceFetcher fetcher;

  @Before
  public void setUp() {
    fetcher = new VigilenceFetcher();
  }

  @Test
  public void testFetch() {
    VigilenceData data = fetcher.fetch();
    assertNotNull(data);
  }

}
