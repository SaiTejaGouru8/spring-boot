node(){
    deleteDir()
    
    stage("git checkout"){
        git url: "https://github.com/SaiTejaGouru8/spring-boot.git"
    }
    
    stage("gradle build"){
        bat"""
       
        gradlew build
        """
        

    }
    
    stage("junit"){
        bat"""
        gradlew test
        """
        junit '**/*.xml'

    }
    
    stage("sonar analysis"){
        bat"""
        gradlew sonarqube -Dsonar.host.url=http://localhost:9000 -Dsonar.login=3ad9534c6ea3a9111fb6ef00d8a1a60b6105b0cb
        """
        

    }
    
    stage("nexus upload"){
        bat """
        gradlew publish
        """
    }
    
    stage("deploy"){
        bat """

         Xcopy "build/libs/spring-boot-${env.BUILD_NUMBER}" "C:\\xampp\\Tomcat\\webapps\\"

        """
    }
    
}