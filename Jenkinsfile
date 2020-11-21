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
                    sh('docker run --name url-shortener -p 8888:8888 --detach url-shortener --network="host"')
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

        stage('Report results') {
                    steps {
                        script {
                            sh('docker exec url-shortener curl -v -T build/test-results/test/TEST-com.example.UrlShortener.UrlShortenerApplicationTests.xml "http://localhost:18080/seam/resource/rest/importer?config=P00002&env=ENV00001&sut=SUT00001&type=junit&createTestSuiteResults=true&buildJobId=test2&buildId=4&username=admin&password=admin"')
                        }
                    }
                }
    }
}