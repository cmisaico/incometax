def registry = 'https://demoudemy01.jfrog.io/'
def imageName = 'demoudemy01.jfrog.io/misaico-docker-docker-local/incommex-docker'
        def version = '1.0.0'

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
                        def server = Artifactory.newServer url:registry + "/artifactory", credentialsId: "artifact-cred"
                        def properties = "buildid=${env.BUILD_ID},commitid=${GIT_COMMIT}";
                        def uploadSpec = """{
                           "files": [
                           {
                               "pattern": "build/libs/(*)",
                               "target": "demoudemy-gradle-release-local/{1}",
                               "flat": "false",
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


        stage("Docker build") {
            steps {
                script {
                echo "------------------- Building the docker image -------------------"
                app = docker.build(imageName + ":" + version)
                echo "------------------- Building complete the docker image -------------------"
                }
            }
        }
        stage("Docker publish") {
            steps {
                script {
                    echo "------------------- Publishing the docker image -------------------"
                    docker.withRegistry(registry, 'artifact-cred') {
                        app.push()
                    }
                    echo "------------------- Publishing complete the docker image -------------------"
                }
            }
        }
        stage ("Package helm"){
            steps {
                script {
                    echo "------------------- Packaging the helm chart -------------------"
                    sh 'helm create k8s/incometax'
                    echo "------------------- Removing templates -------------------"
                    sh 'rm -rf k8s/incometax/templates/*'
                    echo "------------------- Copy templates -------------------"
                    sh 'cp k8s/*.yaml k8s/incometax/templates/'
                    echo "------------------- Helm chart package complete -------------------"
                    sh 'helm package k8s/incometax'
                    echo "------------------- Installing the helm chart -------------------"
                    sh 'helm install incometax incometax-0.1.0.tgz'
                }
            }
        }



    }
}