pipeline {
  agent any
  stages {
    stage('Run Maven Package') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Upload to S3') {
      steps {
        s3Upload(file: 'target/aws-access-0.0.1-SNAPSHOT.jar', bucket: 'arwm-calc-codebase-299541157397', path: '/')
      }
    }
  }
}