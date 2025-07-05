pipeline {
    agent any

    tools {
        maven 'Maven'    // Use your Maven name
        jdk 'JDK17'      // Use your JDK name
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'git@github.com:kedarekruthika/HerokuAppAutomation.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}
