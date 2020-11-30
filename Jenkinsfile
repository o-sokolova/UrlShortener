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

        stage('Report result') {
            steps {
                script {
                    sh('docker exec url-shortener curl -v -T build/test-results/test/TEST-com.example.UrlShortener.UrlShortenerApplicationTests.xml "http://localhost:18080/seam/resource/rest/importer?config=P00003&env=ENV00001&sut=SUT00001&type=junit&createTestSuiteResults=true&username=admin&password=admin"')
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
