
#Testes Mobile Uolet

Utilizei para a criação do Script de testes do aplicativo [ UOLET ](https://uolet.com/) a IDE Eclipse utilizando a linguagem Java.

Para gerar os vários casos de testes é possivel utilizar o JUnit ou o [ TestNG ](http://testng.org/doc/index.html), optei pelo TestNG.

Para acessar as funcionalidades do **APP mobile** utilizei o Framework [ Appium ](http://appium.io/), enviando comandos do selenium com o java.

O teste emgloba vários testes de comportamento e de aceitação visando a qualidade e garantindo que todas as funcionalidades estão se comportando corretamente.

#####Atenção
Necessário para que o teste funcione ter o SDK Android para usar a tools **ADB Devices** e o **Appium** instalado.

No linux necessário adicionar as variaveis do ADB e do APPIUM no $PATH global.

No windown a instalação é feita apartir de .exe e o PATH e adicionado automaticamente. 

Qualquer duvida ler documentação [ Appium - Documentação ](http://appium.io/documentation.html?lang=pt) .


## Guia pratico para executar os testes

1- Altere o nome do device onde quer que o appium rode seus códigos.

```java
/*Setando meu device - Android Uolet*/
cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LGH342c0e8e752"); 
```

Para saber como saber qual o nome do seu device execute o comando **ADB DEVICES** no terminal.

```terminal
[viniciusqa@UOLET testesMobileUolet]$ adb devices
List of devices attached
LGH342c0e8e752	no permissions;
```


**Obs:** Caso o Android não apareça na lista, lembre-se que deve estar com o modo **DESENVOLVEDOR ATIVADO** e deburação liberada para o computador.


2- Inicie o Appium utilizando o comando **appium** no terminal.


```terminal
[viniciusqa@UOLET ~]$ appium
[Appium] Welcome to Appium v1.6.3 (REV 40e40975ebd3593d08c3f83de2546258f9ddf11d)
[Appium] Appium REST http interface listener started on 0.0.0.0:4723

```


3- Vá no case teste ou no xml de teste do testNG e selecione **Run As > Run TestNG Test**


4- Aguarde o fim do teste para obter relatório sobre sucesso e falhas.

======



# Organização dos Testes aplicativo Uolet
======

Os testes vão ser organizados em test cases com a IDE Eclipse, que serão executados pelo TestNG em uma ordem pré determinada.

###### Obs: Em todos os casos de testes o driver **AndroidDriver** vai ter suas **SetCapability** configuradas no inicio da sua execução antes do **TestCase** iniciar e finalizado após os **TestCase** ter sido *completamente* executado.
======

## Suite de teste
======

#### TestCase 1 (completo)

Abrindo aplicativo pela primeira vez

* Aguardando aplicativo ser carregado
* Passando tutorial e indo para tela home
* Clicando em carteira na pagina home sem ter feito cadastro e sendo redirecionado para tela login
* Efetuando login no contexto UOLET (via email)
* Voltando a tela home agora estando logado
* Clicando no botão QrCode, verificando se ele foi carregado e voltando a tela home.
* Clicando no botão Mapa, verificando se ele foi carregado e voltando a tela home.

###### Obs²: Testes de Leitura de QrCode e Testes de GeoLocalização serão feitos manualmente, pois são funcionalidades nativas do android e não são contempladas via Appium.


#### TestCase 2 (em produção)

Verificando Itens do Menu

* Aguardando aplicativo ser carregado e logando com login Uolet
* Clicando no Menu
* Verificando se o nome do usuário Logado está sendo apresentado no menu.
* Verificando se **Minha Uolet** vai para a tela carteira Uolet
* Verificando se **Meus Interesses** vai para a tela meus interesses e se é possivel selecionar um e voltar a tela inicial
* Verificando se **Convidar Amigos** abre as redes sociais do celular
* Verificando se **Ver tutorial** abre o tutorial
* Verificando se **Fale conosco** abre as configurações do Email do usuario
* Verificando se **Termos de Uso** abre os termos de uso do aplicativo Uolet
* Verificando se **Política de privacidade** abre os termos de uso do aplicativo Uolet
* Botão Sair efetua o Logout do sistema


#### TestCase 3 (em produção)

Verificando Campanha

* Aguardando aplicativo ser carregado e logando com login Uolet
* Arrastando campanha para a direita e esquerda para testar a funcionalidad de *Visualização da campanha*
* Clicando em uma campanha
* Arrastando os itens para direita e esquerda para testar a funcionalidade de *Visualização da campanha*
* Verificando a ordem dos itens
* Verificando as informações dos itens e fotos dele
* Verificando se o link do item funciona e volta para o item
* Verificando se o video do item funciona e volta para o item
* Verificando se o item é coletado e exibe mensagem de coleta


#### TestCase 4 (em produção)

Verificando Carteira Uolet

* Aguardando aplicativo ser carregado e logando com login Uolet
* Clicando na carteira e verificando se ela foi carregada
* Verificando se a carteira tem 3 abas, **Disponível**, **Resgatados** e **Vencidos**
* Verificando se na aba **Disponível** está o item coletado no **TestCase 3**
* Verificando se o item coletado é o mesmo item 
* Verificando se ao arrastar o item para a esquerda é exibido o botão deletar
* Verificando se o botão deletar realmente deleta o item
* Verificando se um cupom pode ser resgatado


#### TestCase 5 (em produção)

Verificando Login

* Aguardando aplicativo a ser carregado e indo para tela login
* Logando via facebook usuário existente
* Logando via facebook usuário inválido
* Loganco via google usuário existente
* Logando via google usuário inválido
* Logando via Uolet usuário novo
* Logando via Uolet usuário existente senha correta
* Logando via Uolet usuário existente senha inválida






	