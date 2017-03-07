package com.uolet.casos.teste.mobileApp;

import static org.testng.Assert.fail;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AbrindoAppPelaPrimeiraVez {
	//AppiumDriver<WebElement> driver;
	AndroidDriver<WebElement> driver;
	WebDriverWait wait;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public void Setup() throws MalformedURLException, InterruptedException {
		//File diretorioAplicacao = new File("/home/viniciusqa/workspace/apk_uolet/");
		//File arquivoAplicacao = new File(diretorioAplicacao , "com.uolet.app.real4.apk"); /*Definindo um endereço fisico do APK para instalação no android*/
		  
		/*Criando e setando as capacidades do driver*/
		DesiredCapabilities cap = new DesiredCapabilities();
		
		/*Setando o sistema operacional*/
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		
		/*Setando meu device - Android Uolet*/
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH342c0e8e752"); 
		
		/*Setando meu device - Meu Android*/
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "T099707JJF"); 
		
		/*Instalar o APK apartir de um endereço fisico*/
		//cap.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		
		/*Setando o Nome do pacote do aplicativo a ser testado*/
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.uolet.app");
		
		/*Setando a Atividade principal do aplicativo a ser testado*/
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.uolet.app.MainActivity");
		
		/*finalizando o driver Appium com todas as capacidades e endereço do hub appium*/
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		/*Criando a espera, e liberando somente quando o aplicativo estiver sido carregado e pronto para testes*/
		wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View")));		
		Thread.sleep(3000);				
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	    }
	}
	
  @Test(priority =  0, description = "Abrindo aplicativo pela primeira vez e passando o tutorial")
  public void AbrindoAplicativoEPassandoTutorial() throws MalformedURLException, InterruptedException {	   
		
		driver.swipe(240, 400, 15, 400, 1000);		
		Thread.sleep(2000);				
		driver.swipe(240, 400, 15, 400, 1000);		
		Thread.sleep(2000);
		/*Descobrindo o tamanho da tela*/
		Dimension tamanhoTela = driver.manage().window().getSize();
		int tamanhoAltura = tamanhoTela.getHeight();
		int tamanhoLargura = tamanhoTela.getWidth();
		/*Verificando se o Tamanho da altura e largura do elemento a ser clicado*/
		System.out.print("Tamanho altura: " + (tamanhoAltura-10) + " e largura: " + tamanhoLargura/2);		
		driver.tap(1, tamanhoLargura / 2 , tamanhoAltura - 10, 1);
		Thread.sleep(5000);
  }
  @Test(priority = 1, description = "Clicando em carteira sem login")
  public void ClicandoEmCarteiraSemEstarLogado () throws InterruptedException{
	  driver.findElementByXPath("//android.widget.ListView[@resource-id='list']/android.view.View[@index='1']").click();
	  Thread.sleep(1500);
	  Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='UOLET']")));
  }
  @Test(priority = 2, description = "Efetuando login via UOLET contexto")
  public void LogandoComLoginUolet () throws InterruptedException{
	  com.uolet.pageObjects.mobileApp.pageLogin logar = new com.uolet.pageObjects.mobileApp.pageLogin(driver);
	  com.uolet.pageObjects.mobileApp.pageHome home = logar.LogandoUolet("rafa@ateste.com", "123456");
	  Thread.sleep(10000);
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
