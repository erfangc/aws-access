pipeline {
  agent any
  stages {
    stage('Run Maven Package') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}