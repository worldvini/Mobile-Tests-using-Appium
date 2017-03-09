package com.uolet.mobileApp.funcoesUtilitarias;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class configuracaoDriverMobileAppium {
	AndroidDriver<WebElement> driver;
	public configuracaoDriverMobileAppium (AndroidDriver<WebElement> driverCriacao){
		this.driver = driverCriacao;
	}
	
	public AndroidDriver<WebElement> CriandoDriver () throws MalformedURLException, InterruptedException{
		/*Definindo um endereço fisico do APK para instalação no android*/
		//File diretorioAplicacao = new File("/home/viniciusqa/workspace/apk_uolet/");
		//File arquivoAplicacao = new File(diretorioAplicacao , "com.uolet.app.real4.apk"); 
		  
		/*Criando e setando as capacidades do driver*/
		DesiredCapabilities cap = new DesiredCapabilities();
		
		/*Setando o sistema operacional*/
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		
		/*Setando meu device - Android Uolet*/
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH342c0e8e752"); 
		
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
		
		return driver;
	}
}
