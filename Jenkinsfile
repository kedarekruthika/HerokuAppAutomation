pipeline {
    agent any

    tools {
        maven 'Maven-3.9.10'  // replace with your configured Maven name
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'git@github.com:kedarekruthika/HerokuAppAutomation.git'
                // optionally add credentialsId: 'github-ssh' if you created it
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', reportBuildPolicy: 'ALWAYS', results: [[path: 'target/allure-results']]
        }
    }
}
