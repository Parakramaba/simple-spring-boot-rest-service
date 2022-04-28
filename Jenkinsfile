pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sonarq1') {
                    bat './mvnw.cmd clean sonar:sonar'
                }
            }
        }
    }
}