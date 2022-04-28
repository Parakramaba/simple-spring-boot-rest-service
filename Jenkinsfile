pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('Scan') {
            steps {
                withSonarQubeEnv('sonarq1') {
                    bat 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}