package com.uolet.mobileApp.casosTeste;

import static org.testng.Assert.fail;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
	}	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	    }
	}
  
  @Test(priority = 0, description = "Verifica convidar amigos abre as redes sociais do usuário")
  public void verificaConvidarAmigosAbreTelaAndroidRedesSociaisMobile (){
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Convidar amigos']");
	  localizacao.confirmaAlertaAndroidInvocado();
	  driver.pressKeyCode(AndroidKeyCode.BACK); 
	  localizacao.confirmaTelaInicial();	 
  }
  @Test(priority = 1, description = "Verifica se o ver tutorial abre o tutorial")
  public void verificaVerTutorialEntraTelaTutorialVisualizandoTutorial () throws InterruptedException{
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Ver tutorial']");
	  Thread.sleep(2000);
	  navegar.passaTutorial();
	  localizacao.confirmaTelaInicial();
  }
  @Test(priority = 2, description = "verifica fale conosco abre um email padrão do usuário")
  public void verificandoFaleConoscoAbreEmailPadrãoUsuário (){
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.solucaoMomentaneaFaleConosco("//android.view.View[@content-desc='Fale conosco']", "FaleConosco");
	  localizacao.confirmaAlertaAndroidInvocado();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  localizacao.confirmaTelaMenu();
	  navegar.fechaeMenu();
	  localizacao.confirmaTelaInicial();
  }
  @Test(priority = 3, description = "verifica termos de uso abre os termos de uso do aplicativo uolet")
  public void verificandoTermosDeUsoEntraEmDocumentacaoTermosDeUsoUolet (){
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Termos de Uso']");
	  localizacao.confirmaTelaTermosUso();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  localizacao.confirmaTelaMenu();
	  navegar.fechaeMenu();
	  localizacao.confirmaTelaInicial();	  
  }
  @Test(priority = 4, description = "verifica politica de privacidade abre os termos de uso do aplicativo uolet")
  public void verificandoPoliticaPrivacidadeEntraEmDocumentacaoPoliticaPrivacidadeUolet (){
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Política de privacidade']");
	  localizacao.confirmaTelaPoliticaPrivacidade();
	  driver.pressKeyCode(AndroidKeyCode.BACK);
	  localizacao.confirmaTelaMenu();
	  navegar.fechaeMenu();
	  localizacao.confirmaTelaInicial();
  }
  @Test(priority = 5, description = "verifica se o botão limpar cache funcionalidade cancelar funciona")
  public void verificaLimparCacheCancelar() throws InterruptedException{
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.solucaoMomentaneaFaleConosco("//android.view.View[@content-desc='Limpar Cache']","Cache");
  Thread.sleep(2000);
  Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='LIMPAR CACHE']")));
  driver.findElementByXPath("//android.widget.Button[@content-desc='Cancelar ']").click();
	  localizacao.confirmaTelaInicial();	  
  }
  @Test(priority = 6, description = "verifica se o botão limpar cache funcionalidade excluir funciona")
  public void verificaLimparCacheExcluir() throws InterruptedException{
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.solucaoMomentaneaFaleConosco("//android.view.View[@content-desc='Limpar Cache']","Cache");
  Thread.sleep(2000);
  Assert.assertTrue(isElementPresent(By.xpath("//android.view.View[@content-desc='LIMPAR CACHE']")));
  driver.findElementByXPath("//android.widget.Button[@content-desc='Excluir ']").click();
	  localizacao.confirmaTelaInicial();	  
  }
	@Test(priority = 7 , description ="verifica minha uolet deslogado encaminha tela login")
	public void verificaMinhaUoletDeslogadoEntraTelaLogin(){
		navegar.abreMenu();
		localizacao.confirmaTelaMenu();
		navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Minha Uolet']");
		localizacao.confirmaTelaLogin();
		navegar.clicaBotaoSuperiorOrInferiorEsquerdo("superior");
		localizacao.confirmaTelaInicial();		
	}
	@Test(priority = 8 , description ="verifica criar conta deslogado encaminha tela login")
	public void verificaCriarContaDeslogadoEntraTelaLogin(){
		navegar.abreMenu();
		localizacao.confirmaTelaMenu();
		navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Criar Conta']");
		localizacao.confirmaTelaLogin();
		navegar.clicaBotaoSuperiorOrInferiorEsquerdo("superior");
		localizacao.confirmaTelaInicial();		
	}
	@Test(priority = 9 , description ="verifica meus interesses deslogado encaminha tela login")
	public void verificaMeusInteressesDeslogadoEntraTelaLogin(){
		navegar.abreMenu();
		localizacao.confirmaTelaMenu();
		navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Meus interesses']");
		localizacao.confirmaTelaLogin();
		navegar.clicaBotaoSuperiorOrInferiorEsquerdo("superior");
		localizacao.confirmaTelaInicial();		
	}
  @Test(priority = 10, description = "Verifica Minha Uolet Vai realmente para a carteira apos logado")
  public void verificaItemMinhaUoletEncaminhaParaCarteiraUolet() throws InterruptedException {
	  navegar.clicaCarteiraUoletTelaHome();
	  com.uolet.mobileApp.pageObjects.pageLogin logar = new com.uolet.mobileApp.pageObjects.pageLogin(driver);
	  logar.LogandoUolet("rafa@ateste.com", "123456");	  	
	  localizacao.confirmaTelaInicial();
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Minha Uolet']");
	  localizacao.confirmaTelaCarteira();
	  navegar.clicaBotaoSuperiorOrInferiorEsquerdo("superior");
	  localizacao.confirmaTelaInicial();	  
  }
  @Test(priority = 11, description = "Verifica se meus interesses vai realmente para a opções de selecionar interesses")
  public void verificaMeusInteressesEntraTelaInteresses() throws InterruptedException{
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.localizaPosicaoItemMenuEClica("//android.view.View[@content-desc='Meus interesses']");
	  localizacao.confirmaTelaMeusInteresses();	  
  }
  @Test(priority = 12, description = "verifica se meus interesses SÓ podem ser salvos com alguma opcao selecionada")
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
  @Test(priority = 7, description = "verifica botão minha conta vai para minha conta")
  public void verificandoBotaoMinhaContaEntraTelaDeAlteracaoDeDadosUsuario (){
	  
  }
  @Test(priority = 8, description = "verifica se as informações do usário podem ser alteradas com nome de usuário em branco")
  public void verificandoInformacoesUsuarioNaoDevemSerAlteradasComNomeEmBranco (){
	  
  }
  @Test(priority = 9, description = "verifica se as informações do usuário podem ser alteradas com email de usuário em branco")
  public void verificandoInformacoesUsuarioNaoDevemSerAlteradasComEmailEmBranco (){
	  
  }
  @Test(priority = 10, description = "verifica se as informações de usuário são alteradas")
  public void verificandoInformacoesUsuarioSaoAlteradas (){
	  
  }
  @Test(priority = 13, description = "verifica botão sair efetua logout sistema")
  public void verificandoBotaoSairEfetuaLogoutSistema(){
	  navegar.abreMenu();
	  localizacao.confirmaTelaMenu();
	  navegar.clicaBotaoSuperiorOrInferiorEsquerdo("inferior");
	  localizacao.confirmaTelaLogin();	  
  }
  
	private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
