pipeline {
    agent {
        node {
            label 'gradle'
        }
    }
    stages {
        stage('Clone-code'){
            steps {
                git branch: 'main', url: 'https://github.com/cmisaico/incometax-service.git'
            }
        }
    }
}