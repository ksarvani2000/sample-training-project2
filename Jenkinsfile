pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                git "https://github.com/ksarvani2000/sample-training-project2.git"
            }
        }
        stage("compile"){
            steps{
            sh "mvn clean compile"
            }
        }
        
         stage("package"){
            steps{
            sh "mvn package"
            }
        }
        
        stage("docker_build"){
            steps{
            sh "docker build -t arunasarvani/myorderapp:$BUILD_NUMBER ."
            }
        }
      
    }
   
}