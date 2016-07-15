Procedimento de execução do Chat


* Baixar e instalar jdk1.8.0_40.
* Baixar e instalar Play Framework.
* Baixar e instalar Xampp ou servidor de aplicação de preferencia.
* Abrir diretório do serviço(“../serviceCode/ChatPixeonService”) no prompt de comando. Executar o comando “play”, após carregar, executar comando run <PORT>(parâmetro da porta de preferencia).
* Editar os arquivos de controller(signInController.js e chatController.js) alterando os end-points de requisição do serviço para http://localhost:<PORT>(parametro de porta do serviço).
* Copiar arquivos do diretorio front-end(../front-end) para pasta de deploy do servidor escolhido(no caso do xampp “htdocs”) e executar o server(no caso do xampp “xampp_start.exe”).
* Acessar http://localhost:80 , logar na aplicação e usar :)