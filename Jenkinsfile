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

        // first we delete existing snapshots if the current build is a snapshot build
        if (pom.version.endsWith("SNAPSHOT")) {
            sh """
aws elasticbeanstalk delete-application-version \
    --application-name ${pom.artifactId} \
    --version-label ${pom.version} \
    --region us-east-1
"""
        }

        sh """
aws elasticbeanstalk create-application-version \
    --application-name ${pom.artifactId} \
    --version-label ${pom.version} \
    --region us-east-1 \
    --source-bundle S3Bucket='arwm-calc-codebase-299541157397',S3Key='${uberJar}'
"""
    }
    stage('Deploy') {
        echo "Deploying to DEV ..."
    }
}