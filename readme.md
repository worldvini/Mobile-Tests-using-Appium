# Organização dos Testes aplicativo Uolet
======

Os testes vão ser organizados em test cases com a IDE Eclipse, que serão executados pelo TestNg em uma ordem pré determinada.

###### Obs: Em todos os casos de testes o driver do Appium (AndroidDriver) vão ser carregados no inicio da sua execução e finalizado antes de iniciar o próximo caso de teste.
======

## Suite de teste
======

#### TestCase 1

Abrindo aplicativo pela primeira vez


* Aguardando aplicativo ser carregado
* Passando tutorial e indo para tela home
* Clicando em carteira na pagina home sem ter feito cadastro e sendo redirecionado para tela login
* Efetuando login no contexto UOLET (via email)
* Voltando a tela home agora estando logado
* Clicando no botão QrCode, verificando se ele foi carregado e voltando a tela home.
* Clicando no botão Mapa, verificando se ele foi carregado e voltando a tela home.
	