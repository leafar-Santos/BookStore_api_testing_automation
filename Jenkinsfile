pipeline {
    agent any

    parameters {
            string(name: 'APP_BASE_URL', description: 'Base URL da API')
    }
    stages {
        stage('Inicio') {
            steps {
                bat 'echo Inicio'
            }
        }
        stage('Testes API com Rest Assured') {
            steps {
                bat 'mvn clean test'
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