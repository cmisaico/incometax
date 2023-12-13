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
    }
}