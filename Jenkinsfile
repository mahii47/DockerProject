pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/mahii47/DockerProject'
            }
        }
        
        stage('Build Docker Image')
        {
			steps{
				sh 'docker build -t selenium-tests .'
			}
		}

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
