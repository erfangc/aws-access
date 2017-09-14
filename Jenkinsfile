pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        parallel(
          "Build": {
            sh 'mvn clean package'
            
          },
          "Misc": {
            sh 'env'
            
          }
        )
      }
    }
    stage('Upload to S3') {
      steps {
        s3Upload(file: 'target/aws-access.jar', bucket: 'arwm-calc-codebase-299541157397', path: 'aws-access.jar')
      }
    }
  }
}