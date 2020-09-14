## Projeto: Gerenciamento de Usuários (Versão 2)
### Esse projeto é uma evolução do projeto [GerenciadorDeUsuarios](https://github.com/ShinoharaHelioAk/GerenciadorDeUsuarios). Foi feito na linguagem Java, utilizando conceitos básicos de JSP e Servlets.

Trata-se de um projeto de Gerenciamento de Usuários, na qual é possível cadastrar um usuário, alterar dados e listar os funcionários cadastrados.

Não foi utilizada nenhuma tecnologia do lado cliente para estilização das telas, pois o foco desse projeto em um primeiro momento foi o desenvolvimento das Servlets, como forma de treinamento com o básico do Java Web.

## Ferramentas utilizadas:
* IDE: Eclipse (2020-06 - 4.16.0)
* SGBD: MySQL 8.0
* Servidor da Aplicação: Apache Tomcat (9.0.37)
* Sistema Operacional: Windows 10 - 64 Bits


## Material de consulta:
* Apostila da Caelum (FJ-21)
* Explicação e exemplos de utilização do ServletContext (https://www.javatpoint.com/servletcontext)
* Explicação e exemplos de utilização da taglib fmt, para formatar campos de data no JSP (https://www.tutorialspoint.com/jsp/jstl_format_formatdate_tag.htm)

## Processo de instalação do projeto:
* Ter as ferramentas acima instaladas na sua máquina.


* Executar esse script de criação da tabela Usuarios:
	* **(Observação: No MySQL, você deve criar um schema para criar a tabela)**

```SQL
USE <SCHEMA_NAME>;
CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    dataNascimento DATE,
    status VARCHAR(20) NOT NULL,
    dataInclusao DATETIME NOT NULL,
    dataModificacao DATETIME,
    motivoAlteracao VARCHAR(500),
    senha VARCHAR(500) NOT NULL,
    perfil VARCHAR(500),
    primary key (id)
);
```
* Inserir um usuário com perfil de administrador para fazer o login na aplicação, usando o comando SQL abaixo como exemplo:
```SQL
USE <SCHEMA_NAME>;
INSERT INTO usuarios (
	`nome`,
	`email`,
	`dataNascimento`,
	`status`,
	`dataInclusao`,
	`dataModificacao`,
	`motivoAlteracao`,
	`senha`,
	`perfil`
) VALUES (
	'usuario',
	'usuario@user.com.br',
	now(),
	'bloqueado',
	now(),
	null,
	null,
	'12345',
	'administrador'
);
```

* Baixar o arquivo .WAR da aplicação, que se encontra no caminho [GUSR_V2/WAR/](https://github.com/ShinoharaHelioAk/GUSR_V2/tree/master/WAR) do repositório do GitHub e importá-lo na sua IDE.


* Adicionar o conector do MySql e a biblioteca do JSTL (arquivos .jar) no build path do projeto.
	* Para isso, expandir as pastas do projeto no caminho **WebContent/WEB-INF/lib** até encontrar os arquivos .jar (conector do MySql e o JSTL);
  * Selecionar ambos os arquivos e clicar com o botão direito do mouse;
  * Ir até a opção **Build Path**, e depois clicar na opção **Add to Build Path**;


- Alterar a String de conexão na classe (br.com.helio.jdbc.ConnectionFactory), de acordo com os dados da conexão que você criou:

```Java
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/<SCHEMA_NAME>?useTimezone=true&serverTimezone=UTC",
					"<SCHEMA_USERNAME>", "<SCHEMA_PASSWORD>");
```

* Rodar a aplicação no servidor da aplicação:
  * Clicar com o botão direito do mouse no nome do projeto;
  * Ir até a opção **Run As**;
  * Clicar na opção **Run on server**;
  * Ao abrir a janela **Run On Server**, clicar no botão **Finish**;
