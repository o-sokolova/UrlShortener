pipeline {
   agent any
   stages {
    stage('Checkout') {
      steps {
        script {
            git url: 'https://github.com/o-sokolova/UrlShortener'
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