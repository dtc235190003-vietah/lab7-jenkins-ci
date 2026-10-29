pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                dir('sample-java-app') {
                    sh 'mvn clean test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('sample-java-app') {
                    sh 'mvn package -DskipTests'
                }
            }
        }

        stage('Deploy to Nexus') {
            steps {
                dir('sample-java-app') {
                    sh 'mvn deploy -DskipTests'
                }
            }
        }
    }
}
