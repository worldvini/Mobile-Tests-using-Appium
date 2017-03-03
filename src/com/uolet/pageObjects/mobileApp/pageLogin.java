package com.uolet.pageObjects.mobileApp;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class pageLogin {
	private AppiumDriver<WebElement> driver;
  
  public pageLogin( AppiumDriver<WebElement> driverOld ) {
	  this.driver = driverOld;
  }
  
  public pageHome LogandoUolet(String Email, String Senha) throws InterruptedException{
	  logando("uolet");
	  driver.findElementByXPath("//android.widget.EditText[@content-desc='Email']").sendKeys(Email);
	  driver.findElementByXPath("//android.webkit.WebView[@content-desc='uolet-mobile']/android.view.View[@index='2']/"
	  		+ "android.view.View[@index='0']/android.view.View[@index='1']/android.widget.EditText[@index='0']").sendKeys(Senha);
	  driver.findElementByXPath("//android.widget.Button[@content-desc='Entrar ']").click();
	  driver.findElementByXPath("//android.widget.Button[@content-desc='Entrar ']").click();
	  
	  return new pageHome(driver);
  }
  public pageHome LogandoRedeSocial(String nomeRedeSocial) throws InterruptedException{
	  
	  logando(nomeRedeSocial);	  
	  return new pageHome(driver);
  }
  
  public void logando(String nRedeSocial) throws InterruptedException{
	  
	  if(nRedeSocial == "facebook")
		driver.findElementByXPath("//android.view.View[@content-desc='Continuar com Facebook']").click();
	  else if(nRedeSocial == "google")
	  	driver.findElementByXPath("//android.view.View[@content-desc='Continuar com Google']").click();
	  else if(nRedeSocial == "uolet")
		driver.findElementByXPath("//android.view.View[@content-desc='Continuar com email']").click();
	  
	  Thread.sleep(3000);	  
  }
  
}
