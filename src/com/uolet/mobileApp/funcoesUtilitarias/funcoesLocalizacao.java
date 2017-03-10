package com.uolet.mobileApp.funcoesUtilitarias;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class funcoesLocalizacao {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	public funcoesLocalizacao(AndroidDriver<WebElement> oldDriver){
		this.driver = oldDriver;
		wait = new WebDriverWait(driver, 1000);
	}	
	
	public void confirmaTelaInicial () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='iconQrCode']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@resource-id='iconQrCode']")));
	}
	public void confirmaTelaLogin () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='UOLET']")));  
		Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='UOLET']")));
	}
	public void confirmaTelaQrCode () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.uolet.app:id/status_view']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.widget.TextView[@resource-id='com.uolet.app:id/status_view']")));
	}
	public void confirmaTelaCarteira () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Resgatados']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='Resgatados']")));
	}
	public void confirmaTelaMapa () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Radar de Ofertas']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='Radar de Ofertas']")));
	}
	public void confirmaTelaMenu () {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Minha Uolet']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='Minha Uolet']")));
	}
	public void confirmaTelaAlteracoesDados (){
		
	}
	public void confirmaTelaMeusInteresses (){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Selecione seus interesses:']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='Selecione seus interesses:']")));		
	}
	public void confirmaTelaCampanha (){
		
	}
	public void confirmaTelaTermosUso (){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='https://uolet.com/termos-de-uso/']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.widget.EditText[@text='https://uolet.com/termos-de-uso/']")));
	}
	public void confirmaTelaPoliticaPrivacidade (){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='https://uolet.com/politica-de-privacidade/']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.widget.EditText[@text='https://uolet.com/politica-de-privacidade/']")));
	}
	public void confirmaAlertaAndroidInvocado (){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")));
		Assert.assertTrue(isElementPresent(By.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")));
	}
	
	//fazendo a funcao isElementPresent retornar um valor true ou false
	private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
