import com.maximbircu.sharedlibrary.PipelineSteps

def call() {
    node('jenkins') {
        def pipelineSteps = new PipelineSteps(this)
        stage('clean') {
            pipelineSteps.clean()
        }
        stage('build') {
            pipelineSteps.build()
        }
        stage('test') {
            pipelineSteps.test()
        }
    }
}

return this
