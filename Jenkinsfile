pipeline {
   agent any
   stages {
    stage('Checkout') {
      steps {
        script {
            git credentialsId: 'UrlShortener', url: 'https://github.com/o-sokolova/UrlShortener'
         }
       }
    }
    stage('Build') {
          steps {
            script {
                sh('chmod +x gradlew')
                sh('./gradlew --info clean bootJar')
              }
           }
        }
  }
}