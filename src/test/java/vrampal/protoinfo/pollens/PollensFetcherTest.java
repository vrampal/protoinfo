package vrampal.protoinfo.pollens;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PollensFetcherTest {

  private PollensFetcher fetcher;

  @Before
  public void setUp() {
    fetcher = new PollensFetcher();
  }

  @Test
  public void testFetchDep() {
    PollensData data = fetcher.fetchDep("06");
    assertNotNull(data);
    data = fetcher.fetchDep("44");
    assertNotNull(data);
    data = fetcher.fetchDep("75");
    assertNotNull(data);
  }

}
