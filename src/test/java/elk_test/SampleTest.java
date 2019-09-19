package elk_test;

import core.ExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExecutionListener.class)
public class SampleTest {

  @Test(description = "login")
  public void login() {
    System.out.println("Login method running...");
  }

  @Test(description = "search for flights", dependsOnMethods = "login")
  public void search() {}

  @Test(description = "select flight", dependsOnMethods = "search")
  public void select() {
    Assert.assertEquals("abd", "abc");
  }

  @Test(description = "book flight", dependsOnMethods = "select")
  public void book() {}
}
