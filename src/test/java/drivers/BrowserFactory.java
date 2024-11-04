package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserFactory {
	WebDriver driver;
	public BrowserFactory() {
		
	}
	private static DriverFactory instance = new DriverFactory();
	
	private static DriverFactory getInstance() {
		return instance;
	}
		////CONFIGURACION DE APPIUM DRIVER////
		public WebDriver setDriver(String nodeURL) throws MalformedURLException {
			System.getProperty("java.classpath");
			new DesiredCapabilities();
			
			
				try {
					UiAutomator2Options options = new UiAutomator2Options()
							.setPlatformName("Android")
							.setDeviceName("emulator-5554")
							.setUdid("emulator-5554")
							.setPlatformVersion("11.0")
							.setAdbExecTimeout(Duration.ofSeconds(150))
							.setAutomationName("UiAutomator2")
							.setAppPackage("com.samsung.android.calendar")
							.setAppActivity("com.android.calendar.AllInOneActivity")
							.setNewCommandTimeout(Duration.ofSeconds(60))
							.setAdbExecTimeout(Duration.ofSeconds(60))
							.setChromedriverUseSystemExecutable(true);
							
					driver = new AndroidDriver(new URL(nodeURL),options);//RemoteWebDriver AppiumDriver AndroidDriver
					
				}catch(Exception exp) {
					System.out.println("Cause is : "+exp.getCause());
					System.out.println("Message is : "+exp.getMessage());
					exp.printStackTrace();
				}
				
			return driver;

		}
	////CERRAR Y REMOVER DRIVER/////
	public void removeDriver() {
		driver.close();
		driver.quit();
	}
}
