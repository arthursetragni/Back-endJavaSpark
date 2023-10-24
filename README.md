# Back-endJavaSpark
---

# Sistema de Denúncias

O Sistema de Denúncias é uma plataforma que permite aos usuários reportarem incidentes e compartilharem informações relevantes com outros usuários. Por exemplo, um usuário pode relatar a queda de um poste, alertando outros a evitarem a área.

## Configuração do Ambiente

O projeto utiliza o Maven para gerenciamento de dependências. Certifique-se de ter o Maven instalado. O arquivo `pom.xml` está completo e pronto para uso.

Além disso, é necessário ter o PostgreSQL instalado. Certifique-se de criar um banco de dados chamado "denuncias" e configurar as credenciais no arquivo `denunciaDAO.java`. Por padrão, o PostgreSQL roda na porta 6000; ajuste conforme necessário.

## Estrutura do Projeto

O back-end está localizado na pasta `src/main/java` e é dividido nas seguintes classes:

- **Aplicacao:** Realiza requisições para o back-end.
- **Service:** Comunica-se com o back-end e processa as respostas.
- **DAO:** Estabelece a conexão direta com o banco de dados.
- **Model:** Contém as funções da classe Denuncia.
- **Os arquivos do front-end estão na pasta src/main/resources/templates. Para iniciar os testes, recomendamos começar com o arquivo index.html**.

## Inicialização Local

1. Crie um servidor PostgreSQL chamado "denuncias" com as configurações adequadas.
2. Ajuste a porta do PostgreSQL no arquivo `denunciaDAO.java`, se necessário.
3. Execute o arquivo `Aplicacao.java` para iniciar o servidor localmente.

## Suporte

Para relatar problemas, obter suporte ou fazer perguntas, entre em contato através do arthursetragni@gmail.com.

---
