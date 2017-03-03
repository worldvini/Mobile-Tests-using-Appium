package com.uolet.casos.teste.mobileApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AbrindoAppPelaPrimeiraVez {
	private StringBuffer verificationErrors = new StringBuffer();
	AppiumDriver<WebElement> driver;
	@BeforeClass
	public void Setup() throws MalformedURLException, InterruptedException {
	 File diretorioAplicacao = new File("/home/viniciusqa/workspace/apk_uolet/");
		File arquivoAplicacao = new File(diretorioAplicacao , "com.uolet.app.real3.apk"); /*Definindo um endereço fisico do APK para instalação no android*/
		  
		/*Criando e setando as capacidades do driver*/
		DesiredCapabilities cap = new DesiredCapabilities();
		
		/*Setando o sistema operacional*/
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		
		/*Setando meu device - Android Uolet*/
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH342c0e8e752"); 
		
		/*Setando meu device - Meu Android*/
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "T099707JJF"); 
		
		/*Instalar o APK apartir de um endereço fisico*/
		//cap.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		
		/*Setando o Nome do pacote do aplicativo a ser testado*/
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.uolet.app");
		
		/*Setando a Atividade principal do aplicativo a ser testado*/
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.uolet.app.MainActivity");
		
		/*finalizando o driver Appium com todas as capacidades e endereço do hub appium*/
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		/*Criando a espera, e liberando somente quando o aplicativo estiver sido carregado e pronto para testes*/
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View")));		
		Thread.sleep(3000);				
	}
	
  @Test(priority =  0, description = "Abrindo aplicativo pela primeira vez e passando o tutorial")
  public void AbrindoAplicativoEPassandoTutorial() throws MalformedURLException, InterruptedException {	   
		
		driver.swipe(240, 400, 15, 400, 1500);		
		Thread.sleep(3000);				
		driver.swipe(240, 400, 15, 400, 1500);		
		Thread.sleep(3000);
		driver.tap(1, 350, 1130, 1);		
		Thread.sleep(3000);		  
  }
  @Test(priority = 1, description = "Abrindo Menu")
  public void ClicandoEmCarteiraSemEstarLogado () throws InterruptedException{
	  driver.findElementByXPath("//android.widget.ListView[@resource-id='list']/android.view.View[@index='0']").click();
	  Thread.sleep(1500);
	  Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='UOLET']")));
  }
 
	private WebDriverWait WebDriverWait(AndroidDriver<WebElement> driver2, int i) {
		// TODO Auto-generated method stub
		return null;
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