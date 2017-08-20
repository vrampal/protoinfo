package vrampal.protoinfo;

import org.junit.Before;
import org.junit.Test;

public class ProtoInfoAppTest {
  
  private ProtoInfoApp app;

  @Before
  public void setUp() throws Exception {
    app = new ProtoInfoApp();
  }

  @Test
  public void testRun() {
    app.run();
  }

}
