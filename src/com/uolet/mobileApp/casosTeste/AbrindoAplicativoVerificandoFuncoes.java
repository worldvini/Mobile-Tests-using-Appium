package com.uolet.mobileApp.casosTeste;

import static org.testng.Assert.fail;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AbrindoAplicativoVerificandoFuncoes {
	//AppiumDriver<WebElement> driver;
	AndroidDriver<WebElement> driver;
	WebDriverWait wait;
	com.uolet.mobileApp.funcoesUtilitarias.funcoesLocalizacao localizacao;
	com.uolet.mobileApp.funcoesUtilitarias.funcoesNavegacao navegar;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public void Setup() throws MalformedURLException, InterruptedException {
		com.uolet.mobileApp.funcoesUtilitarias.configuracaoDriverMobileAppium configuracao = new com.uolet.mobileApp.funcoesUtilitarias.configuracaoDriverMobileAppium(driver);
		driver = configuracao.CriandoDriver();
		localizacao = new com.uolet.mobileApp.funcoesUtilitarias.funcoesLocalizacao(driver);
		navegar = new com.uolet.mobileApp.funcoesUtilitarias.funcoesNavegacao(driver);
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
	
  @Test(priority = 0, description = "Abrindo aplicativo pela primeira vez e passando o tutorial")
  public void AbrindoAplicativoEPassandoTutorial() throws MalformedURLException, InterruptedException {	  	
		navegar.passaTutorial();	
		localizacao.confirmaTelaInicial();
  }
  @Test(priority = 1, description = "Clicando em carteira sem login encaminha a pagina login")
  public void ClicandoEmCarteiraSemEstarLogadoAbrirTelaLogin () throws InterruptedException{
	  	navegar.clicaCarteiraUoletTelaHome();
	  	localizacao.confirmaTelaLogin();
  }
  @Test(priority = 2, description = "Efetuando login via UOLET contexto")
  public void LogandoComLoginUolet () throws InterruptedException{
	  com.uolet.mobileApp.pageObjects.pageLogin logar = new com.uolet.mobileApp.pageObjects.pageLogin(driver);
	  logar.LogandoUolet("rafa@ateste.com", "123456");
	  localizacao.confirmaTelaInicial();
  }
  @Test(priority = 3, description = "clicando em QRcode na pagina home")
  public void ClicandoEmQRcodeVerificandoSeAbriuCarregouEVoltaPaginaHome () throws InterruptedException{
	  driver.findElementByXPath("//android.widget.ListView[@resource-id='list']/android.view.View[@index='2']").click();
	  localizacao.confirmaTelaQrCode();
	  driver.pressKeyCode(AndroidKeyCode.BACK); 
	  Thread.sleep(1500);
  }
  @Test(priority = 4, description = "clicando em Mapa na pagina home")
  public void ClicandoEmMapaVerificandoSeAbriuCarregouEVoltaPaginaHome () throws InterruptedException{
	  driver.findElementByXPath("//android.widget.ListView[@resource-id='list']/android.view.View[@index='0']").click();
	  wait = new WebDriverWait(driver, 1000);
	  localizacao.confirmaTelaMapa();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  Thread.sleep(1500);
  }
  @Test(priority = 5, description = "clicando na carteira agora estando logado e ser encaminhado a tela carteira Uolet")
  public void ClicandoEmCarteiraSemEstarLogadoAbrirTelaCarteiraUolet() throws InterruptedException{
	 navegar.clicaCarteiraUoletTelaHome();
	 localizacao.confirmaTelaCarteira();
	 navegar.clicaBotaoSuperiorOrInferiorEsquerdo("superior");
	 localizacao.confirmaTelaInicial();
  }
}
