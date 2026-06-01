// vars/buildImage.groovy
def call(Map config = [:]) {
    def imageName = config.required('imageName')
    def tag       = config.required('tag')
    def context   = config.get('context', '.')
    def dockerfile = config.get('dockerfile', 'Dockerfile')

    echo "🏗️  Orchestrating Cloud-Native Kaniko Build Layer..."
    
    // Kaniko uses standard build flags instead of subcommands
    sh """
        /kaniko/executor \
          --context=${context} \
          --dockerfile=${dockerfile} \
          --destination=${imageName}:${tag} \
          --skip-tls-verify
    """
}