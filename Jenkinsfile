pipeline {
  environment {
    imagename = "mmtfarooqui/customer-profile-service"
	registryCredential = 'dockerRegistryCredential'
    dockerImage = ''	
		
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git([url: 'https://github.com/mdfarooqui/customer-profile-service.git', branch: 'main', credentialsId: 'git-access'])

      }
    }
   
    stage('Maven Build') {
        steps {
            script {
                def mvnHome = tool name: 'maven-3.3.9', type: 'maven'
                def mvnCMD = "${mvnHome}/bin/mvn"
                sh "${mvnCMD} clean -DskipTests install"
            }
        }
    }
    
    stage('Building Docker Image') {
      steps{
        script {
          dockerImage = docker.build imagename
        }
      }
    }
    stage('Publish Image to Docker Hub') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push("$BUILD_NUMBER")
             dockerImage.push('latest')

          }
        }
      }
    }
    stage('Remove Unused Docker Image') {
      steps{
        sh "docker rmi $imagename:$BUILD_NUMBER"
         sh "docker rmi $imagename:latest"
      }
    }
	
	stage('Deploy Docker Image on ec2') {
      steps{
        sh "docker run -p 8081:8081 -d $imagename:$BUILD_NUMBER"
      }
    }
  }
}