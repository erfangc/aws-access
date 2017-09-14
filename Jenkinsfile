pipeline {
  agent any
  stages {
    stage('Say Hello') {
      steps {
        parallel(
          "Say Hello": {
            echo 'Hello World!'
            
          },
          "Sleep": {
            sleep 5
            
          }
        )
      }
    }
    stage('Run Maven') {
      steps {
        sh 'mvn clean package -DskipTests=true'
      }
    }
  }
}