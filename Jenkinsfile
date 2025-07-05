pipeline {
    agent any

    tools {
        maven 'Maven-3.9.10' // use exactly the name you configured in Jenkins → Global Tool Configuration
    }

    environment {
        // Example: load your config property if needed
        // CONFIG = credentials('my-config') // if you stored config in Jenkins credentials
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/your/repo.git',
                    credentialsId: 'github-token'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
