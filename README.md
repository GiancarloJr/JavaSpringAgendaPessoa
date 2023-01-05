# JavaSpringAgendaPessoa

GIANCARLO SENA MARTINS JUNIOR

EMAIL: giancarlo456@hotmail.com

LINKEDIN: [Giancarlo Sena Martins Júnior | LinkedIn](https://www.linkedin.com/in/giancarlosmj/)


Avaliação Desenvolvedor Back-end Attornatus

O objetivo deste documento é identificar seus conhecimentos quanto às tecnologias utilizadas no cotidiano de desenvolvimento da equipe de Back-end na Attornatus Procuradoria Digital.

Esta análise propõe avaliar os seguintes temas: 

	Qualidade de código

	Java, Spring boot

	API REST

	Testes


A entrega deverá ser feita da seguinte forma:

	O prazo para entrega da avaliação será de até 7 dias após envio da mesma

	Encaminhar este documento com as perguntas respondidas e com o link do código público em sua conta do GitHub

	Opcionalmente, caso você consiga fazer o build da aplicação, poderá também informar o link de acesso


Qualidade de código

1.	Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

Reposta: Durante a implementação de uma funcionalidade nova, deve ser analisado a solicitação e objetivo, posteriormente deve ser feito analise e estrutura do software atual e se é possível fazer de acordo com o solicitado e verificando se interfere em outros métodos já em produção. Sendo feita todas as validações, é implementado o método, feito teste no ambiente e sendo funcional, sobe para produção. Se possível podem ser feito teste de integração e estrutura contribuindo para um resultado esperado.

2.	Em qual etapa da implementação você considera a qualidade de software?

Resposta: A qualidade de um software pode ser bem analisada quando necessita de manutenção, pois se é um software de fácil compreensão, o problema será encontrado com mais facilidade, assim trazendo praticidade e benefícios para a empresa.

Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  

•	Criar uma pessoa

•	Editar uma pessoa

•	Consultar uma pessoa

•	Listar pessoas

•	Criar endereço para pessoa

•	Listar endereços da pessoa

•	Poder informar qual endereço é o principal da pessoa  

Uma Pessoa deve ter os seguintes campos:  

•	Nome

•	Data de nascimento

•	Endereço:

o	Logradouro

o	CEP

o	Número

o	Cidade

Requisitos  
•	Todas as respostas da API devem ser JSON  - OK

•	Banco de dados H2 - OK

Diferencial
•	Testes – TESTES DE SERVIÇOS EXECUTADOS

•	Clean Code - OK
 
Será levado em avaliação 

•	Estrutura, arquitetura e organização do projeto- OK  

•	Boas práticas de programação  - OK

•	Alcance dos objetivos propostos.- OK

INFORMAÇÕES PARA ACESSO DE API

LINK GITHUB: 

GiancarloJr/JavaSpringAgendaPessoa (github.com)

LINK DE ACESSO DOCUMENTAÇÃO SWAGGER:

Swagger UI

CONTAINER DOCKER:

docker run -p 5434:5432 --name apiagenda -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=APIAGENDA postgres:12-alpine

SCRIPT BANCOS: 


CREATE TABLE IF NOT EXISTS PESSOAS (

                                       PES_ID SERIAL PRIMARY KEY NOT NULL,
				       
                                       PES_NAME VARCHAR(100) NOT NULL,
				       
                                       PES_DATA_NASCIMENTO DATE NOT NULL
				       
);


CREATE TABLE IF NOT EXISTS ENDERECOS(

                                       END_ID SERIAL PRIMARY KEY NOT NULL,
				       
                                       END_LOGRADOURO VARCHAR(100) NOT NULL,
				       
                                       END_CEP INT NOT NULL,
				       
                                       END_NUMERO INT NOT NULL,
				       
                                       END_CIDADE VARCHAR(50) NOT NULL,
				       
		                       END_PRINCIPAL BOOLEAN,
			  
                                       PESSOA_ID INT NOT NULL,
				       
                                       FOREIGN KEY (PESSOA_ID) REFERENCES PESSOAS (PES_ID)
				       
);


