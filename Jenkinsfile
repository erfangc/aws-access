pipeline {
  agent any
  stages {
    stage('Run Maven Package') {
      steps {
        parallel(
          "Run Maven Package": {
            sh 'mvn clean package'
            
          },
          "No Reason": {
            listAWSAccounts()
            
          }
        )
      }
    }
    stage('Upload to S3') {
      steps {
        s3Upload(file: 'target/aws-access-0.0.1-SNAPSHOT.jar', bucket: 'cf-templates-19t957lyn96vi-us-east-1', path: '/')
      }
    }
  }
}