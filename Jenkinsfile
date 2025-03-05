pipeline {
    agent any

    parameters {
        string(name: 'APP_BASE_URL', description: 'Base URL do aplicativo')
    }

    stages {
        stage('Inicio') {
            steps {
                echo 'Inicio'
            }
        }

        stage('Testes API com Rest Assured') {
            steps {
                bat 'mvn clean install'
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