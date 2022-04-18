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
                    sh('docker build -t url-shortener .')
                    sh('docker run --name url-shortener --network="host" --detach url-shortener')
                }
            }
        }
        stage('Run test') {
            steps {
                script {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh('docker exec url-shortener ./gradlew test')
                    }
                }
            }
        }
        stage('Clean up.') {
            steps {
                script {
                    sh('docker stop url-shortener')
                    sh('docker rm url-shortener')
                }
            }
        }
    }
}
