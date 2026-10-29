pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {
        stage('Checkout code from Git') {
            steps {
                checkout scm
            }
        }

        stage('Build application') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run unit tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Publish artifact to Nexus') {
            steps {
                sh 'mvn package -DskipTests'
                nexusArtifactUploader(
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    nexusUrl: 'nexus:8081',
                    groupId: 'com.devops.lab7',
                    version: '1.0.0',
                    repository: 'maven-releases',
                    credentialsId: 'nexus-credentials',
                    artifacts: [[
                        artifactId: 'sample-java-app',
                        classifier: '',
                        file: 'target/sample-java-app-1.0.0.jar',
                        type: 'jar'
                    ]]
                )
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        always {
            cleanWs()
        }
    }
}
