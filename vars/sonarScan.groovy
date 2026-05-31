// jenkins-shared-library/vars/sonarScan.groovy
def call(Map config) {
    echo "🔍 Triggering SonarQube Static Code Analysis..."
    // Expects a SonarQube environment setup in Jenkins Global Configurations
    withSonarQubeEnv('LocalSonarQube') {
        sh "./gradlew sonar" // Assuming Gradle/Java build engine
    }
}