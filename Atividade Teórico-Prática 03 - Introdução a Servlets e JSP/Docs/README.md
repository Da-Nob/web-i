<h1> Atividade Teórico-Prática: Arquitetura de Aplicações Web com Servlets e JSPs </h1>


<h3> 3. A arquitetura de uma aplicação Java Web utilizando Servlets e JSPs é baseada no modelo MVC (Model-View-Controller). Explique o papel de cada componente (Model, View e Controller) nessa arquitetura e como eles interagem entre si para processar as requisições dos usuários e gerar as respostas adequadas. </h3>

<p>
O model representa a parte responsável pelos dados e pelas regras da aplicação.
A view representa a resposta para o usuário, no exemplo da atividada no arquivo welcome.jsp que mostra uma mensagem de saudação com o nome do usuário.
E o controller é a entidade responsável pelas repostas e processos e o que será enviado, no exemplo da a tividade de login é a classe LoginServlet que estende o HttpServlet e suas regras de negócio.
O usuário acessa uma página e envia um formulário, arequisição chega ao servlet, que lê e processa aos dados, o servlet encaminha a requisiçao para o JSP que atua como view e o JSP gera o HTML final. 
</p>

<h3>O protocolo HTTP é baseado em um modelo de requisição-resposta. Explique como as requisições HTTP são processadas em uma aplicação Java Web utilizando Servlets, desde o momento em que o usuário envia uma requisição até o momento em que a resposta é gerada e enviada de volta ao cliente. Inclua detalhes sobre o ciclo de vida de um Servlet, como ele lida com os diferentes tipos de requisições (GET, POST, etc.) e como podemos configurar cabeçalhos HTTP, como o Content-Type.
</h3>

<p>
Em uma aplicação web jaav, o protocolo funciona no modelo requisição resposta. Quando um usuário acessa uma página ou envia uma formulário o servidor  cria um requisição HTTP, que pode sre GET ou POST, contendo informações como  a URL, método, para, erros e etc. após o usuário enviar um formulario ou acessar uma página o navegador recebe a requisição e verifica quals ervlet está responsável por tratar aquele caminho. O servlet recebe dois objetos principais o requeste e response, requeste representa  a requisição feita pelo cliente, podendo acessar parâmetros cabeçalhos e etc. Já o response condiz a resposta enviada ao cliente.
</p>

<p>O tom cat atua como um container para o servlet, na inicialização o servlet é carregado, para inicializar conexões. No processamento o container chama o método service identifica o tipo da requisição e encaminha para o método adequado como doGet (Usado para buscar), doPost (usado para enviar), doPut (usado para atualizar) ou doDelete (usado para excluir)</p>

<p>Além de gerar conteúdo HTML, o Servlet também pode configurar cabeçalhos HTTP. Um dos cabeçalhos mais importantes é o Content-Type, que informa ao navegador qual tipo de conteúdo está sendo enviado. Pra configurar cabeçalhos usa-se o setHeader</p>

<h3>Uma das características importantes de uma aplicação Web é a forma como o conteúdo de resposta é gerado e formatado. Com base nisso, no ecosistema de desenvolvimento Java Web (com Servlets e JSPs), responda: </h3>

<h4> a) Explique como arquivos estáticos (como HTML, CSS e JavaScript) e arquivos dinâmicos (como JSPs) são utilizados em uma aplicação Java Web para gerar o conteúdo de resposta.</h4>

<p>Os arquivos estáticos como html, css e imgs, já estão prontos no projeto, o servidor não processa lógica, apenas netrega eles. Já os dados dinâmicos como os JSP podem gerar conteúdo atravez de dados vindos de um servidor, exibindo informções recebidas de um servlet</p>

<h4> b) Qual pasta do projeto é geralmente usada para armazenar arquivos estáticos? Por padrão, os arquivos estáticos, dentro dessa pasta, são acessíveis publicamente?</h4>

<p>Arquivos estáticos é na webpp. Sim por padrão os arquivos dentro dessar pasta webapp ão públicos pelo navegador </p>

<h4>c) Qual pasta do projeto é geralmente usada para armazenar arquivos dinâmicos (JSPs), que representam a camada de visualização? Por padrão, os arquivos JSPs, dentro dessa pasta, são acessíveis publicamente?</h4>

<p> Os JSPs também ficam na pasta webapp, ficando visíveis para serem acessados publicamente pelo navegador.</p>