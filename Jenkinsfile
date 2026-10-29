
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
        script {
            // Generate the HTML test report
            sh 'mvn surefire-report:report-only || true'

            // Publish TestNG/Surefire results in Jenkins
            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/TEST-*.xml'

            // Send an email after every build
            emailext(
                to: 'recipient@gmail.com',
                subject: "API Automation - ${currentBuild.currentResult} - Build #${BUILD_NUMBER}",
                mimeType: 'text/html',
                body: """
                    <h2>API Automation Build Report</h2>

                    <p><b>Project:</b> ${JOB_NAME}</p>
                    <p><b>Build Number:</b> ${BUILD_NUMBER}</p>
                    <p><b>Build Status:</b> ${currentBuild.currentResult}</p>

                    <p>
                        <b>Build Details:</b>
                        <a href="${BUILD_URL}">Open Jenkins Build</a>
                    </p>

                    <p>
                        <b>Test Results:</b>
                        <a href="${BUILD_URL}testReport/">View Test Report</a>
                    </p>
                """,
                attachmentsPattern: 'target/site/surefire-report.html'
            )
        }
    }
}

}
