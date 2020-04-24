package samples.com.designpatterns;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class AppTest {
	
  @BeforeMethod
  public void beforeMethod() {
  }


  @Test
  public void add() {
    assert 5 == new App().add(2, 3) : "Expected sum is 6";
  }
}
