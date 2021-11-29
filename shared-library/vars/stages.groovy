import com.maximbircu.sharedlibrary.PipelineSteps
import com.maximbircu.sharedlibrary.Config

def call(Map params) {
    node('jenkins') {
        checkout([
                $class: 'GitSCM',
                branches: scm.branches,
                doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                extensions: [[$class: 'CloneOption', noTags: false, shallow: false, depth: 0, reference: '']],
                userRemoteConfigs: scm.userRemoteConfigs,
        ])

        def pipelineSteps = new PipelineSteps(this, new Config(params))
        stage('clean') {
            pipelineSteps.clean()
        }
        stage('build') {
            pipelineSteps.build()
        }
        stage('test') {
            pipelineSteps.test()
        }
        stage('clean workspace') {
            pipelineSteps.cleanWorkspace()
        }
    }
}

return this
