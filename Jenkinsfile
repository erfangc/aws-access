pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Deploy') {
      steps {
        sh '/usr/local/bin/eb deploy --staged'
      }
    }
  }
}