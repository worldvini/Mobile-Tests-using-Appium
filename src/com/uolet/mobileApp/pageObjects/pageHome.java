package com.uolet.mobileApp.pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class pageHome {
	private AppiumDriver<WebElement> driver;
  
  public pageHome(AppiumDriver<WebElement> driverOld) {
	  this.driver = driverOld;
  }
  
  public pageLogin LogandoUsuario (String x){	  
	  
	  return new pageLogin(driver);	  
  }
}
