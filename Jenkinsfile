pipeline {
    agent any

    tools {
        maven 'Maven'          // Use the Maven name you configured in Jenkins (check in Manage Jenkins → Global Tool Configuration)
        jdk 'JDK17'            // Use the JDK name you configured (e.g., JDK17)
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
