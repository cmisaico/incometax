def registry = 'https://demoudemy01.jfrog.io/'

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
                sh 'gradle build -x test'
                sh 'echo "------------------- Building complete the app -------------------"'
            }
        }
        stage("Jar publish") {
                    steps {
                        sh 'echo "------------------- Publishing the app -------------------"'
                        def server = Artifactory.newServer url:registry + "/artifactory", credentialsId: 'artifact-cred'
                        def properties = """{
                           "files": [
                           {
                               "pattern": "build/libs/*.jar",
                               "target": "libs-release-local/",
                               "props": "${properties}",
                               "exclusions": ["*.sha1", "*.md5"]
                        }
                        ]
                    }"""
                    def buildInfo = server.upload(uploadSpec)
                    buildInfo.env.collect()
                    server.publishBuildInfo(buildInfo)
                    echo '< ---------- Jar publish End ---------- >'
                    }
                }

    }
}