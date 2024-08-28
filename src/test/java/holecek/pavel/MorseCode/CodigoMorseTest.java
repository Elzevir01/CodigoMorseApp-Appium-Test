package holecek.pavel.MorseCode;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.BrowserFactory;
import drivers.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import pageModel.CodigoMorseApp;

public class CodigoMorseTest {
	
		WebDriver driver;
		BrowserFactory bf;
		CodigoMorseApp cm;
		
		@Test
		  public void CodigoMorse() {
			cm = new CodigoMorseApp(driver);
			cm.enviarTexto("texto");
			cm.clickReproducirAudio();
		}
		
		
		@BeforeTest
		@Parameters("nodeUrl")
		  public void buildDriver(String nodeUrl) {
			  try {
					bf = new BrowserFactory();
					DriverFactory.getInstance().setDriver(bf.setDriver(nodeUrl));
					driver = DriverFactory.getInstance().getDriver();
				} catch (Exception e) {
					e.getMessage();
				}
		  }
		  @AfterTest
		  public void afterTest(){
			  bf.removeDriver();
		  }
}
