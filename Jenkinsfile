pipeline {
  agent any
  stages {
    stage('Pre-Build') {
      steps {
        parallel(
          "Pre-Build": {
            echo 'Hello I am about to Build Something!'
            
          },
          "Approve": {
            input(message: 'Please Approve!', id: 'approve-run')
            
          }
        )
      }
    }
    stage('Run Maven Package') {
      steps {
        sh 'mvn clean package --DskipTests=true'
      }
    }
  }
}