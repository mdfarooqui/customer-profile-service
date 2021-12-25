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
		stage('Building image') {
			steps{
				script {
					dockerImage = docker.build imagename
				}
			}
		}
		stage('Deploy Image') {
			steps{
				script {
					docker.withRegistry( '', registryCredential ) {
					dockerImage.push("$BUILD_NUMBER")
					dockerImage.push('latest')
					}
				}
			}
		}
		
		stage('Deploy Docker Image on ec2') {
			steps{
				sh "docker run -p 8081:8081 -d $imagename:$BUILD_NUMBER"
			}
		}
	}
}