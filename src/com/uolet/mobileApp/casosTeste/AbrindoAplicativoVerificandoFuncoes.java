package com.uolet.mobileApp.casosTeste;

import static org.testng.Assert.fail;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AbrindoAplicativoVerificandoFuncoes {
	//AppiumDriver<WebElement> driver;
	AndroidDriver<WebElement> driver;
	WebDriverWait wait;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public void Setup() throws MalformedURLException, InterruptedException {
		com.uolet.mobileApp.funcoesDeInicializacaoTeste.criandoDriverConfigurandoCapability configuracao = new com.uolet.mobileApp.funcoesDeInicializacaoTeste.criandoDriverConfigurandoCapability(driver);
		driver = configuracao.CriandoDriver();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		Thread.sleep(5000);
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	    }
	}
	
  @Test(priority =  0, description = "Abrindo aplicativo pela primeira vez e passando o tutorial")
  public void AbrindoAplicativoEPassandoTutorial() throws MalformedURLException, InterruptedException {	   
		com.uolet.mobileApp.funcoesDeInicializacaoTeste.logandoAplicativoUolet entrando = new com.uolet.mobileApp.funcoesDeInicializacaoTeste.logandoAplicativoUolet(driver);
		entrando.passandoTutorial();		
  }
  @Test(priority = 1, description = "Clicando em carteira sem login encaminhas pagina login")
  public void ClicandoEmCarteiraSemEstarLogado () throws InterruptedException{
	  	com.uolet.mobileApp.funcoesDeInicializacaoTeste.logandoAplicativoUolet entrando = new com.uolet.mobileApp.funcoesDeInicializacaoTeste.logandoAplicativoUolet(driver);
	  	entrando.entrandoCarteiraSemLogin();
  }
  @Test(priority = 2, description = "Efetuando login via UOLET contexto")
  public void LogandoComLoginUolet () throws InterruptedException{
	  com.uolet.mobileApp.pageObjects.pageLogin logar = new com.uolet.mobileApp.pageObjects.pageLogin(driver);
	  com.uolet.mobileApp.pageObjects.pageHome home = logar.LogandoUolet("rafa@ateste.com", "123456");
	  wait = new WebDriverWait(driver, 1000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='iconQrCode']")));
	  Thread.sleep(2000);
  }
  @Test(priority = 3, description = "clicando em QRcode na pagina home")
  public void ClicandoEmQRcodeVerificandoSeAbriuCarregouEVoltaPaginaHome () throws InterruptedException{
	  driver.findElementByXPath("//android.widget.ListView[@resource-id='list']/android.view.View[@index='2']").click();
	  wait = new WebDriverWait(driver, 1000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.uolet.app:id/status_view']")));
	  Thread.sleep(1000);
	  driver.pressKeyCode(AndroidKeyCode.BACK); 
	  Thread.sleep(2000);
  }
  @Test(priority = 4, description = "clicando em Mapa na pagina home")
  public void ClicandoEmMapaVerificandoSeAbriuCarregouEVoltaPaginaHome () throws InterruptedException{
	  driver.findElementByXPath("//android.widget.ListView[@resource-id='list']/android.view.View[@index='0']").click();
	  wait = new WebDriverWait(driver, 1000);
	  //code for wait
	  Thread.sleep(1000);
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  Thread.sleep(3000);
  }
 
	//verificando os elementos
	private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
	
	
	
	
}
