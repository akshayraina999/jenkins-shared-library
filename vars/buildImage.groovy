// vars/buildImage.groovy
def call(Map config = [:]) {
    // Standard map retrieval syntax with clean default fallbacks
    def imageName  = config.get('imageName')
    def tag        = config.get('tag')
    def context    = config.get('context', '.')
    def dockerfile = config.get('dockerfile', 'Dockerfile')

    // Defensive check to fail fast with a clear message if parameters are missing
    if (!imageName || !tag) {
        error "❌ [buildImage Error] Missing mandatory parameters! 'imageName' and 'tag' are required."
    }

    echo "🏗️  Orchestrating Cloud-Native Kaniko Build Layer..."
    
    sh """
        /kaniko/executor \
          --context=${context} \
          --dockerfile=${dockerfile} \
          --destination=${imageName}:${tag} \
          --skip-tls-verify
    """
}