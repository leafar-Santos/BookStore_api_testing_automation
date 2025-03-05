pipeline {
    agent any
    stages {
        stage('Inicio') {
            steps {
                bat 'echo Inicio'
            }
        }
        stage('Testes API com Rest Assured') {
            steps {
                bat 'mvn clean install'
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