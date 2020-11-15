pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    sh('chmod +x gradlew')
                    sh('./gradlew --info clean bootJar')
                }
            }
        }

        stage('Run app into docker container') {
            steps {
                script {
                    sh('docker ps')
                    sh('docker build -t url-shortener .')
                    sh('docker run --name url-shortener -p 8888:8888 --detach url-shortener')
                }
            }
        }

        stage('Run test') {
            steps {
                script {
                    sh('docker exec url-shortener ./gradlew test')
                }
            }
        }
    }
}