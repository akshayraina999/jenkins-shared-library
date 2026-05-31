// jenkins-shared-library/vars/buildImage.groovy
def call(Map config) {
    echo "🏗️ Building Docker Image: ${config.imageName}:${config.tag}"
    sh "docker build -t ${config.imageName}:${config.tag} ."
}