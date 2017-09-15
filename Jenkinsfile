#! groovy
node {
    stage('Build') {
        parallel(
                "Build": {
                    sh 'mvn clean package'

                },
                "Misc": {
                    sh 'env'

                }
        )
    }
    stage('Upload to S3') {
        def pom = readMavenPom file: 'pom.xml'
        echo "${pom.version}"
        s3Upload(file: 'target/aws-access.jar', bucket: 'arwm-calc-codebase-299541157397', path: 'aws-access.jar')
    }
}