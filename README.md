# API Testing Loja de Livro - Allure Reports

## Descrição
Este projeto realiza testes automatizados para uma API de loja de livros, utilizando **JUnit 5**, **Rest Assured** e **Allure Reports** para geração de relatórios de testes.

## Tecnologias Utilizadas
- **Java 21**
- **JUnit 5** (junit-jupiter-api, junit-jupiter-engine)
- **Rest Assured** (para testes de API)
- **Hamcrest** (para asserções)
- **Lombok** (para reduzir boilerplate)
- **Gson** (para manipulação de JSON)
- **Java Faker** (para gerar dados fictícios)
- **Allure Reports** (para geração de relatórios)
- **Maven** (para gerenciamento de dependências e execução dos testes)

## Configuração do Ambiente
1. Certifique-se de ter o **Java 21** e o **Maven** instalados.
2. Clone este repositório:
   ```sh
   git clone https://github.com/leafar-Santos/BookStore_api_testing_automation.git
   ```
3. Acesse o diretório do projeto:
   ```sh
   cd api_testing_loja_de_livro_allure_reports
   ```

## Executando os Testes
Para rodar os testes automatizados, utilize o seguinte comando:
```sh
mvn clean test
```

## Gerando Relatórios com Allure
Após executar os testes, gere o relatório do **Allure** com:
```sh
allure generate
allure open
```
Isso abrirá um servidor local exibindo os resultados dos testes.

## Estrutura do Projeto
```
/api_testing_loja_de_livro_allure_reports
├── src/main/java  # Código principal (se houver)
├── src/test/java  # Testes automatizados
├── pom.xml        # Configuração do Maven e dependências
└── README.md      # Documentação do projeto
```

## Contato
Caso tenha dúvidas ou sugestões, entre em contato por e-mail: leafarccomputacao@gmail.com

