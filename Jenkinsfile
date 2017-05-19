
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo "This is the deploy stage. It is broken on purpose."'
                    retry(3) {

                        sh 'echo "Three retries. It may only do it once if successful."'
                    }
            }
        }
        stage('Health Checks') {
            steps {
                timeout(time: 2, unit: 'SECONDS') {
                    sh 'echo "This will time out and fail if it does not complete in 2 seconds."'
                    sh 'chmod +x ./health-check.sh'
                    sh './health-check.sh bananas injected'
                }
            }
        }
    }

    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }

}