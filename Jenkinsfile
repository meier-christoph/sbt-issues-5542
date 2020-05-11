// https://jenkins.io/doc/book/pipeline/syntax/
pipeline {
  agent {
    label "jdk8"
  }

  stages {
    stage('test') {
      steps {
        withJdk8 {
          withSbt('v1') {
            sh 'sbt clean test'
          }
        }
      }
    }
  }

  post {
    always {
      deleteDir()
    }
  }
}
