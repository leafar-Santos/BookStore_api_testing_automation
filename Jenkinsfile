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
                // Passando o parâmetro APP_BASE_URL para o Maven
                bat "mvn clean test -DAPP_BASE_URL=${params.APP_BASE_URL}"
            }
        }
    }

    post {
        always {
            script {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
}
