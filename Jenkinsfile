pipeline {
    agent {
        node {
            label 'gradle'
        }
    }
    environment {
        PATH = '/opt/gradle-7.3.1/bin:$PATH'
    }

    stages {
        stage('Build') {
            steps {
                sh 'gradle build'
            }
        }
    }
}