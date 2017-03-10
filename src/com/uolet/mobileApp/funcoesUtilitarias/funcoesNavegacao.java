package com.uolet.mobileApp.funcoesUtilitarias;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class funcoesNavegacao {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	private Dimension tamanhoTelaDispositivo;
	public funcoesNavegacao (AndroidDriver<WebElement> oldDriver){
		this.driver = oldDriver;
		wait = new WebDriverWait(driver, 1000);
	}
	/*passando tutorial*/
	public void passaTutorial() throws InterruptedException{
		//Rolando para a esquerda as duas primeiras paginas
		driver.swipe(240, 400, 15, 400, 1500);		
		Thread.sleep(2000);				
		driver.swipe(240, 400, 15, 400, 1500);		
		Thread.sleep(2000);
		/*Localizando botao de acordo com a sua posicao e tamanho de tela*/
		Dimension tamanhoTela = driver.manage().window().getSize();
		int tamanhoAltura = tamanhoTela.getHeight();
		int tamanhoLargura = tamanhoTela.getWidth();	
		driver.tap(1, tamanhoLargura / 2 , tamanhoAltura - 10, 1);		
	}
	/*Elementos clicaveis reutilizaveis*/
	public void clicaCarteiraUoletTelaHome() {
		driver.findElementByXPath("//android.widget.ListView[@resource-id='list']/android.view.View[@index='1']").click();		
	}
	private int alturaElemento(String nomeElemento){
		return driver.findElementByXPath(nomeElemento).getLocation().getY();
	}
	public void abreMenu () {
		tamanhoTelaDispositivo = driver.manage().window().getSize();
		int larguraTela = tamanhoTelaDispositivo.getWidth();
		int alturaElemento = alturaElemento("//android.webkit.WebView[@content-desc='uolet-mobile']/android.view.View[@index='0']/android.view.View[@index='0']/android.widget.Image[@index='0']");		
		driver.swipe(5, alturaElemento, (larguraTela/10)*8, alturaElemento, 1000);
	}
	public void fechaeMenu (){
		tamanhoTelaDispositivo = driver.manage().window().getSize();
		int larguraTela = tamanhoTelaDispositivo.getWidth();
		int alturaElemento = alturaElemento("//android.webkit.WebView[@content-desc='uolet-mobile']/android.view.View[@index='0']/android.view.View[@index='0']/android.widget.Image[@index='0']");		
		driver.swipe((larguraTela/10)*8, alturaElemento, 5, alturaElemento, 1000);
	}
	public void clicaBotaoSuperiorOrInferiorEsquerdo(String posicaoBotao){
		tamanhoTelaDispositivo = driver.manage().window().getSize();
		int larguraTela10Porcento = tamanhoTelaDispositivo.getWidth()/10;
		int alturaTela = tamanhoTelaDispositivo.getHeight();
		if(posicaoBotao == "superior")
			driver.tap(1, larguraTela10Porcento, (alturaTela/100)*8, 1);
		else
			driver.tap(1, larguraTela10Porcento, (alturaTela/100)*95, 1);

		System.out.println("altura da tela: " + alturaTela + " -tentativa de conta: " + (alturaTela/100)*98);
	}
	public void localizaPosicaoItemMenuEClica (String nomeElemento){
		tamanhoTelaDispositivo = driver.manage().window().getSize();
		int larguraTela = tamanhoTelaDispositivo.getWidth();
		int alturaElemento = alturaElemento(nomeElemento);		
		driver.tap(1, larguraTela/4, alturaElemento, 1);		
	}
	/* o -3 na altura do elemento é uma soluçao provisória, até o programador resolver um problema no click do elemento*/
	public void solucaoMomentaneaFaleConosco (String nomeElemento, String CacheSair){
		tamanhoTelaDispositivo = driver.manage().window().getSize();
		int larguraTela = tamanhoTelaDispositivo.getWidth();
		int alturaElemento = alturaElemento(nomeElemento);
		if(CacheSair == "FaleConosco")
			driver.tap(1, larguraTela/4, alturaElemento -10, 1);
		else
			driver.tap(1, larguraTela/4, alturaElemento +15, 1);
	}
}
