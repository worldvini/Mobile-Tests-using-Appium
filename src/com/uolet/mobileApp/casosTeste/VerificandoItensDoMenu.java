package com.uolet.mobileApp.casosTeste;

import static org.testng.Assert.fail;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
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

public class VerificandoItensDoMenu {
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
		navegar.passaTutorial();
		localizacao.confirmaTelaInicial();
		navegar.clicaCarteiraUoletTelaHome();		
	  	com.uolet.mobileApp.pageObjects.pageLogin logar = new com.uolet.mobileApp.pageObjects.pageLogin(driver);
	  	logar.LogandoUolet("rafa@ateste.com", "123456");	  	
	  	localizacao.confirmaTelaInicial();
	}	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	    }
	}
	
  @Test(priority = 0, description = "Verificando Minha Uolet Vai realmente para a carteira")
  public void verificaItemMinhaUoletEncaminhaParaCarteiraUolet() throws InterruptedException {
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Minha Uolet']");
	  localizacao.confirmaTelaCarteira();
	  navegar.clicaBotaoVoltarSuperiorEsquerdo();
	  localizacao.confirmaTelaInicial();	  
  }
  @Test(priority = 1, description = "Verificando se meus interesses vai realmente para a opções de selecionar interesses")
  public void verificaMeusInteressesEntraTelaInteresses() throws InterruptedException{
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Meus interesses']");
	  localizacao.confirmaTelaMeusInteresses();	  
  }
  @Test(priority = 2, description = "verificando se meus interesses SÓ podem ser salvos com alguma opcao selecionada")
  public void verificaMeusInteressesNaoPodemSerSalvoSemSelecionarOpcao () throws InterruptedException{
	  localizacao.confirmaTelaMeusInteresses();
	  Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='Automotivo']")));  
	  driver.findElementByXPath("//android.view.View[@content-desc='Automotivo']").click();
	  Thread.sleep(1000);
	  driver.findElementByXPath("//android.widget.Button[@content-desc='OK ']").click();
	  Thread.sleep(2000);
	  Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='OPS']")));
	  driver.findElementByXPath("//android.widget.Button[@content-desc='Ok ']").click();
	  localizacao.confirmaTelaMeusInteresses();
	  driver.findElementByXPath("//android.view.View[@content-desc='Automotivo']").click();
	  Thread.sleep(1000);
	  driver.findElementByXPath("//android.widget.Button[@content-desc='OK ']").click();
	  localizacao.confirmaTelaInicial();	  
  }
  @Test(priority = 3, description = "Verificando convidar amigos abre as redes sociais do usuário")
  public void verificandoVerTutorialEntraTelaTutorialVisualizandoTutorial (){
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Convidar amigos']");
	  WebDriverWait wait = new WebDriverWait(driver, 1000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("android.widget.TextView[@resource-id='android:id/alertTitle']")));
	  Assert.assertTrue(isElementPresent(By.xpath("android.widget.TextView[@resource-id='android:id/alertTitle']")));
	  driver.pressKeyCode(AndroidKeyCode.BACK); 
	  localizacao.confirmaTelaInicial();	 
  }
  /*
  @Test(priority = 4, description = "verificando fale conosco abre um email padrão do usuário")
  public void verificandoFaleConoscoAbreEmailPadrãoUsuário (){
	  
  }
  @Test(priority = 5, description = "verificando termos de uso abre os termos de uso do aplicativo uolet")
  public void verificandoTermosDeUsoEntraEmDocumentacaoTermosDeUsoUolet (){
	  
  }
  @Test(priority = 6, description = "verificando politica de privacidade abre os termos de uso do aplicativo uolet")
  public void verificandoPoliticaPrivacidadeEntraEmDocumentacaoPoliticaPrivacidadeUolet (){
	  
  }
  @Test(priority = 7, description = "verificando botão minha conta vai para minha conta")
  public void verificandoBotaoMinhaContaEntraTelaDeAlteracaoDeDadosUsuario (){
	  
  }
  @Test(priority = 8, description = "verificando se as informações do usário podem ser alteradas com nome de usuário em branco")
  public void verificandoInformacoesUsuarioNaoDevemSerAlteradasComNomeEmBranco (){
	  
  }
  @Test(priority = 9, description = "verificando se as informações do usuário podem ser alteradas com email de usuário em branco")
  public void verificandoInformacoesUsuarioNaoDevemSerAlteradasComEmailEmBranco (){
	  
  }
  @Test(priority = 10, description = "verificando se as informações de usuário são alteradas")
  public void verificandoInformacoesUsuarioSaoAlteradas (){
	  
  }
  @Test(priority = 11, description = "verificando botão sair efetua logout sistema")
  public void verificandoBotaoSairEfetuaLogoutSistema(){
	  
  } */
  
	private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
