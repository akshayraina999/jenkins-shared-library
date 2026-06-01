// vars/sonarScan.groovy
def call(Map config = [:]) {
    def stageName = config.get('stageName', 'Static Code Analysis')
    
    stage(stageName) {
        // Utilizing the official Jenkins SonarQube plugin environment block
        withSonarQubeEnv('SonarQube-Local') {
            echo "🚀 Initiating SonarQube Quality Scanner Analysis..."
            
            // Execute the Maven sonar goal against our local cluster engine
            sh "./mvnw clean verify sonar:sonar \
                -Dsonar.projectKey=${config.projectKey} \
                -Dsonar.projectName=${config.projectName} \
                -Dsonar.host.url=http://sonarqube-sonarqube.devops-tools.svc.cluster.local:9000"
        }
    }
}