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
                sh 'echo "Building the app"'
                sh 'gradle clean'
                sh 'gradle build -x test'
            }
        }
        stage("SonarQube analysis v1") {
            environment {
                scannerHome = tool 'cmisacio-sonar-scanner'
            }
            step{
                withSonarQubeEnv('cmisaico-sonarqube-server') { // If you have configured more than one global server connection, you can specify its name
                sh "${scannerHome}/bin/sonar-scanner"
            }
            }
        }
    }
}