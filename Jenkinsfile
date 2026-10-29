
pipeline {
    agent any

    triggers {
        cron('H 19 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Java and Maven') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Run API Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/TEST-*.xml'
        }

        success {
            echo 'API tests completed successfully.'
        }

        failure {
            echo 'API tests or the build failed. Check Console Output.'
        }
    }
}
