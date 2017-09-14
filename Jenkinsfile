pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Upload to S3') {
      steps {
        s3Upload(file: 'target/aws-access.jar', bucket: 'arwm-calc-codebase-299541157397', path: 'aws-access')
      }
    }
  }
}