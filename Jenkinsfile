pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        maven 'maven_3.8.7'
    }
    stages {
        stage('Code Compilation') {
            steps {
                echo 'code compilation is starting'
                sh 'mvn clean compile'
				echo 'code compilation is completed'
            }
        }
        stage('Code Package') {
            steps {
                echo 'code packing is starting'
                sh 'mvn clean package'
				echo 'code packing is completed'
            }
        }
        stage('Code Quality Check') {
            steps {
                echo 'code packing is starting'
                sh 'java --version'
				echo 'code packing is completed'
            }
        }
        stage('Building & Tag Docker Image') {
            steps {
                echo 'Starting Building Docker Image'
                sh 'docker build -t nishi01/demo-ms .'
                sh 'docker build -t demo-ms .'
                echo 'Completed  Building Docker Image'
            }
        }
        stage('Docker Image Scanning') {
            steps {
                echo 'Docker Image Scanning Started'
                sh 'java -version'
                echo 'Docker Image Scanning Started'
            }
        }
        stage(' Docker push to Docker Hub') {
           steps {
              script {
                 withCredentials([string(credentialsId: 'nishi01', variable: 'nishi01')]){
                 sh 'docker login docker.io -u nishi01 -p ${nishi01}'
                 echo "Push Docker Image to DockerHub : In Progress"
                 sh 'docker push nishi01/demo-ms:latest'
                 echo "Push Docker Image to DockerHub : In Progress"
                 sh 'whoami'
                 }
              }
            }
        }
        stage(' Docker Image Push to Amazon ECR') {
           steps {
              script {
                 withDockerRegistry([credentialsId:'ecr:ap-south-1:ecr-credentials', url:"https://552855432033.dkr.ecr.ap-south-1.amazonaws.com"]){
                 sh """
                 echo "List the docker images present in local"
                 docker images
                 echo "Tagging the Docker Image: In Progress"
                 docker tag tata-ms:latest 552855432033.dkr.ecr.ap-south-1.amazonaws.com/tata-ms:latest
                 echo "Tagging the Docker Image: Completed"
                 echo "Push Docker Image to ECR : In Progress"
                 docker push 552855432033.dkr.ecr.ap-south-1.amazonaws.com/tata-ms:latest
                 echo "Push Docker Image to ECR : Completed"
                 """
                 }
              }
           }
        }
        stage('Deploy into Kubernetes') {
            steps {
                echo 'Docker Image Scanning Started'
                sh 'java -version'
                echo 'Docker Image Scanning Started'
            }
        }
    }
}