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
              sh 'sbt clean coverage test'
              sh 'sbt coverageAggregate sonarScan'
            }
          }
        }
      }
    }

    stage('release') {
      when {
        allOf {
          branch 'master'
          expression { return params.RELEASE }
        }
      }
      steps {
        withJdk8 {
          withSbt('v1') {
            sh "git branch --set-upstream-to=origin/${GIT_BRANCH} ${GIT_BRANCH}"
            sh "sbt clean \"release with-defaults\""
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
