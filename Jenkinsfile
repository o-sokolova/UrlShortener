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
                    sh('sudo docker build -t url-shortener .')
                    sh('sudo docker run --name url-shortener -p 8888:8888 --detach url-shortener')
                }
            }
        }
    }
}