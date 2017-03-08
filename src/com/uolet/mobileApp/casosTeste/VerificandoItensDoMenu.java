package com.uolet.mobileApp.casosTeste;

import static org.testng.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class VerificandoItensDoMenu {
	//AppiumDriver<WebElement> driver;
	AndroidDriver<WebElement> driver;
	WebDriverWait wait;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public void Setup() throws MalformedURLException, InterruptedException {
		com.uolet.mobileApp.funcoesDeInicializacaoTeste.criandoDriverConfigurandoCapability configuracao = new com.uolet.mobileApp.funcoesDeInicializacaoTeste.criandoDriverConfigurandoCapability(driver);
		driver = configuracao.CriandoDriver();
		com.uolet.mobileApp.funcoesDeInicializacaoTeste.logandoAplicativoUolet entrando = new com.uolet.mobileApp.funcoesDeInicializacaoTeste.logandoAplicativoUolet(driver);
	  	entrando.passandoTutorial();
	  	entrando.entrandoCarteiraSemLogin();
	  	com.uolet.mobileApp.pageObjects.pageLogin logar = new com.uolet.mobileApp.pageObjects.pageLogin(driver);
	  	com.uolet.mobileApp.pageObjects.pageHome home = logar.LogandoUolet("rafa@ateste.com", "123456");
		wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='iconQrCode']")));
		Thread.sleep(2000);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	    }
	}
	@BeforeMethod
	public void AbrindoMenu () throws InterruptedException{
		Dimension tamanhoTela = driver.manage().window().getSize();
		int larguraTela = tamanhoTela.getWidth();
		int alturaDoElemento = driver.findElementByXPath("//android.webkit.WebView[@content-desc='uolet-mobile']/android.view.View[@index='0']/"
				+ "android.view.View[@index='0']/android.widget.Image[@index='0']").getLocation().getY();		
		driver.swipe(5, alturaDoElemento, (larguraTela/10)*8, alturaDoElemento, 1000);		
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Minha conta']")));
		Thread.sleep(2000);
	}
	@AfterMethod
	public void FechandoMenu() throws InterruptedException{
		Dimension tamanhoTela = driver.manage().window().getSize();
		int larguraTela = tamanhoTela.getWidth();
		int alturaDoElemento = driver.findElementByXPath("//android.webkit.WebView[@content-desc='uolet-mobile']/android.view.View[@index='0']/"
				+ "android.view.View[@index='0']/android.widget.Image[@index='0']").getLocation().getY();		
		driver.swipe((larguraTela/10)*8, alturaDoElemento, 5, alturaDoElemento, 1000);		
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='iconQrCode']")));
		Thread.sleep(2000);
	}
  @Test(priority = 0, description = "Verificando Minha Uolet Vai realmente para a carteira")
  public void verificandoItemMinhaUoletEncaminhaParaCarteiraUolet() {
	  
  }
  @Test(priority = 1, description = "Verificando se meus interesses vai realmente para a opções de selecionar interesses")
  public void verificandoMeusInteressesEntraTelaInteressesESelecionaOpções(){
	  
  }
  /*
  @Test(priority = 2, description = "Verificando convidar amigos abre as redes sociais do usuário")
  public void verificandoVerTutorialEntraTelaTutorialVisualizandoTutorial (){
	  
  }
  @Test(priority = 3, description = "verificando fale conosco abre um email padrão do usuário")
  public void verificandoFaleConoscoAbreEmailPadrãoUsuário (){
	  
  }
  @Test(priority = 4, description = "verificando termos de uso abre os termos de uso do aplicativo uolet")
  public void verificandoTermosDeUsoEntraEmDocumentacaoTermosDeUsoUolet (){
	  
  }
  @Test(priority = 5, description = "verificando politica de privacidade abre os termos de uso do aplicativo uolet")
  public void verificandoPoliticaPrivacidadeEntraEmDocumentacaoPoliticaPrivacidadeUolet (){
	  
  }
  @Test(priority = 6, description = "verificando botão minha conta vai para minha conta")
  public void verificandoBotaoMinhaContaEntraTelaDeAlteracaoDeDadosUsuario (){
	  
  }
  @Test(priority = 7, description = "verificando se as informações do usário podem ser alteradas com nome de usuário em branco")
  public void verificandoInformacoesUsuarioNaoDevemSerAlteradasComNomeEmBranco (){
	  
  }
  @Test(priority = 8, description = "verificando se as informações do usuário podem ser alteradas com email de usuário em branco")
  public void verificandoInformacoesUsuarioNaoDevemSerAlteradasComEmailEmBranco (){
	  
  }
  @Test(priority = 9, description = "verificando se as informações de usuário são alteradas")
  public void verificandoInformacoesUsuarioSaoAlteradas (){
	  
  }
  @Test(priority = 10, description = "verificando botão sair efetua logout sistema")
  public void verificandoBotaoSairEfetuaLogoutSistema(){
	  
  }*/
}