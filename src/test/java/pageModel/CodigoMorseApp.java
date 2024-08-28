package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CodigoMorseApp extends pageModel.Base {

	private By cajaDeTexto = By.xpath("//android.widget.EditText[@text=\"Ingresa el texto que debe traducirse a código Morse.\"]");
	private By botonAudio = By.xpath("//android.widget.Button[@content-desc=\"Reproducir usando un altavoz\"]");
	
	public CodigoMorseApp(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enviarTexto(String texto) {
		clearText(cajaDeTexto);
		sendKey(cajaDeTexto, texto);
	}
	public void clickReproducirAudio() {
		clickElemento(botonAudio);
	}
	
}
