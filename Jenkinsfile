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
        uberJar = "${pom.artifactId}-${pom.version}.jar"
        s3Upload(file: "target/${uberJar}", bucket: 'arwm-calc-codebase-299541157397', path: "${uberJar}")
        /*
        update the uberJar as a new version in ElasticBeanstalk
         */
        sh """
aws elasticbeanstalk create-application-version \
    --application-name aws-access \
    --version-label ${pom.version} \
    --source-bundle S3Bucket='arwm-calc-codebase-299541157397',S3Key='${uberJar}'
"""
    }
}