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
	////CONFIGURACION DE CHROME DRIVER////
	public WebDriver setDriverChrome(String browser, String nodeURL) throws MalformedURLException{
		System.out.println(nodeURL);
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL(nodeURL), chromeOptions);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		
		return driver;
	}
		////CONFIGURACION DE CHROME DRIVER////
		public WebDriver setDriver(String nodeURL) throws MalformedURLException {
			System.getProperty("java.classpath");
			new DesiredCapabilities();
			
			
				try {
						UiAutomator2Options options = new UiAutomator2Options()
							.setPlatformName("Android")
							/*
							.setDeviceName("SM-J71MN")//"emulator-5554"//"SM-J71MN"
							.setUdid("52032936c0e08321")
							.setPlatformVersion("8.1.0")//"8.1.0"//11.0
							*/
							//.setDeviceName("emulator-5554")
							.setUdid("52032936c0e08321")//.setUdid("R58M54TQWPN")
							.setPlatformName("Android")
							.setPlatformVersion("8.1.0")//11.0
							//.setDeviceName("SM-A405FN/DS")
							.setAdbExecTimeout(Duration.ofSeconds(150))
							.setAutomationName("UiAutomator2")
							.setAppPackage("holecek.pavel.MorseCode")
							.setAppActivity("crc648bbdc909d4b41b63.MainActivity")
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
	////CERRAR Y REMOVER WEBDRIVER/////
	public void removeDriver() {
		driver.close();
		driver.quit();
	}
}
