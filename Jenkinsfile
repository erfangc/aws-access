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
        sh '/usr/local/bin/eb init aws-access --region us-east-1 --platform java8'
        sh '/usr/local/bin/eb deploy --staged'
      }
    }
  }
}