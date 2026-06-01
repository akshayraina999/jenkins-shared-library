// vars/sonarScan.groovy
def call(Map config = [:]) {
    def projectKey = config.get('projectKey', 'java-knative-app')
    def projectName = config.get('projectName', 'Java Knative App')
    
    stage('Static Code Analysis') {
        withSonarQubeEnv('SonarQube-Local') { // Enforce your synchronized name string
            echo "🔍 Initiating SonarQube Quality Scanner..."
            
            // Switch from ./mvnw to global mvn
            sh """
                mvn clean verify sonar:sonar \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.projectName=${projectName}
            """
        }
    }
}