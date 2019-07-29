# FIPE
Sistema para calculo da tabela FIPE

## Front-end
Desenvolvido com Angular 8 + Bootstrap 4
- npm install para instalar as dependencias

## Back-end
 Projeto Maven 
 Desenvolvido no Eclipse IDE com RESTEasy Jersey.
 - Java JDK 1.7
  
 As dependencias estão todas no maven através do arquivo 'pom.xml'.
 - Baixar o projeto fipe-rest e rodar o 'update maven' para atualizar as dependencias.
 - Executar no servidor de aplicação.
 - Utilizei o JBoss EAP 6.1 para testar.

## REST
http://localhost:8080/fipe/api/veiculo/


Ex.: 
- http://localhost:8080/fipe/api/veiculos/21 = Lista todos os veiculos de uma determinada marca
- http://localhost:8080/fipe/api/veiculo/marcas = Lista todas as marcas para exibir no combobox.

