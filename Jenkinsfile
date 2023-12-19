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
                    script {
                        sh 'echo "------------------- Publishing the app -------------------"'
                        def server = Artifactory.newServer url:registry + "/artifactory", credentialsId: 'artifact-cred'
                        sh 'echo "------------------- 1 -------------------"'
                        def properties = "buildid=${env.BUILD_ID},commitId=${env.GIT_COMMIT}";
                        sh 'echo "------------------- 2 -------------------"'
                        def uploadSpec = """{
                           "files": [
                           {
                               "pattern": "build/libs/*.jar",
                               "target": "libs-release-local/",
                               "props": "${properties}",
                               "exclusions": ["*.sha1", "*.md5"]
                        }
                        ]
                    }"""
                    sh 'echo "-------------------3 -------------------"'
                    def buildInfo = server.upload(uploadSpec)
                    sh 'echo "-------------------4 -------------------"'
                    buildInfo.env.collect()
                    sh 'echo "-------------------5 -------------------"'
                    server.publishBuildInfo(buildInfo)
                    sh 'echo "------------------- 6 -------------------"'
                    echo '< ---------- Jar publish End ---------- >'
                    }
                    }
                }

    }
}