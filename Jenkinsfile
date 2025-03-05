pipeline {
    agent any

    parameters {
        string(name: 'APP_BASE_URL', description: 'Base URL da API')
    }

    stages {
        stage('Inicio') {
            steps {
                echo 'Início teste'
            }
        }

        stage('Testes API com Rest Assured') {
            steps {
                bat "mvn clean test -DAPP_BASE_URL=${params.APP_BASE_URL}"
            }
        }
    }

    post {
        always {
            script {
                try {
                    // Limpar o diretório allure-results antes de gerar o novo relatório
                    bat "del /Q allure-results\\*.*"


                    // Gerando o relatório Allure
                    allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                } catch (Exception e)
                    echo "Falha ao gerar relatório Allure: ${e.message}"
                }
            }
        }
    }
}
