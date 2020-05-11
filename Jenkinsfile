// https://jenkins.io/doc/book/pipeline/syntax/
pipeline {
  agent {
    label "jdk8"
  }

  parameters {
    booleanParam(name: 'RELEASE', defaultValue: false, description: 'Release ?')
  }

  stages {
    stage('test') {
      when {
        allOf {
          not { expression { return params.RELEASE } }
        }
      }
      steps {
        withSonarQubeEnv('default') {
          withJdk8 {
            withSbt('v1') {
              sh 'sbt clean test'
            }
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
