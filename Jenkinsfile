pipeline {
    agent {
        node {
            label 'gradle'
        }
    }
    environment {
        PATH = "/opt/gradle-8.5/bin:$PATH"
    }

    stages {
        stage("Build") {
            steps {
                sh 'echo "------------------- Building the app -------------------"'
                sh 'gradle clean'
                sh 'gradle --refresh-dependencies'
                sh 'gradle build -x test'
                sh 'echo "------------------- Building complete the app -------------------"'
            }
        }
        stage("Test") {
            steps {
                sh 'echo "------------------- Testing started the app -------------------"'
                sh 'gradle allureReport'
                sh 'echo "------------------- Testing ended the app -------------------"'
            }
        }
        stage("SonarQube analysis v1") {
            environment {
                scannerHome = tool 'cmisaico-sonar-scanner'
            }
            steps{
                withSonarQubeEnv('cmisaico-sonarqube-server') { // If you have configured more than one global server connection, you can specify its name
                sh "${scannerHome}/bin/sonar-scanner"
            }
            }
        }
    }
}