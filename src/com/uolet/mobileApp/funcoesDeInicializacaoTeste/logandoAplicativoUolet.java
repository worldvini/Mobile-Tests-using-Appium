package com.uolet.mobileApp.funcoesDeInicializacaoTeste;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class logandoAplicativoUolet {
	private AndroidDriver<WebElement> driver;
	WebDriverWait wait;
	public logandoAplicativoUolet(AndroidDriver<WebElement> oldDriver){
		this.driver = oldDriver;
	}
	
	public void passandoTutorial() throws InterruptedException{
		//Rolando para a esquerda as duas primeiras paginas
		driver.swipe(240, 400, 15, 400, 1500);		
		Thread.sleep(2000);				
		driver.swipe(240, 400, 15, 400, 1500);		
		Thread.sleep(2000);
		/*Descobrindo o tamanho da tela*/
		Dimension tamanhoTela = driver.manage().window().getSize();
		int tamanhoAltura = tamanhoTela.getHeight();
		int tamanhoLargura = tamanhoTela.getWidth();
		/*Verificando se o Tamanho da altura e largura do elemento a ser clicado*/
		System.out.print("Tamanho altura: " + (tamanhoAltura-10) + " e largura: " + tamanhoLargura/2);		
		driver.tap(1, tamanhoLargura / 2 , tamanhoAltura - 10, 1);
		/*Criando a espera, e liberando somente quando o aplicativo estiver sido carregado e pronto para testes*/
		wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='iconQrCode']")));
		Thread.sleep(2000);
	}
	
	public void entrandoCarteiraSemLogin() throws InterruptedException{
		driver.findElementByXPath("//android.widget.ListView[@resource-id='list']/android.view.View[@index='1']").click();
		Thread.sleep(1500);
		wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='UOLET']")));
		//Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='UOLET']")));
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
