pipeline {
    agent any
//     options {
//         buildDiscarder(logRotator(numToKeepStr: '5'))
//     }
    stages {
        stage('Scan') {
            steps {
                withSonarQubeEnv('sonarq1') {
                    bat 'mvn clean package sonar:sonar'
                }
                bat 'mvn pmd:pmd'
                bat 'mvn checkstyle:checkstyle'
                bat 'mvn site'
            }
        }
    }
}

// pipeline {
//     agent any
//     environment {
//         DB_CREDENTIALS = credentials('mysql-db-credentials')
//     }
//     options {
//         buildDiscarder(logRotator(numToKeepStr: '5'))
//     }
//     stages {
//         stage('Get Code') {
//             steps {
//                 git 'https://github.com/Parakramaba/simple-spring-boot-rest-service.git'
//             }
//         }
//         stage('Build') {
//             steps {
//                 // bat 'mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081,--spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver,--spring.datasource.url=jdbc:mysql://localhost:3306/simple_spring_boot_db?createDatabaseIfNotExist=true,--spring.datasource.username=$DB_CREDENTIALS_USR,--spring.datasource.password=$DB_CREDENTIALS_PSW"'
//                 withSonarQubeEnv('sonarq1') {
//                     bat 'mvn clean package sonar:sonar'
//                 }
//             }
//         }
// //         stage('Test') {
// //             steps {
// //
// //             }
// //         }
//     }
// }