import com.maximbircu.sharedlibrary.PipelineSteps
import com.maximbircu.sharedlibrary.Config

def call(Map params) {
    node('jenkins') {
        checkout([
                $class                           : 'GitSCM',
                branches                         : scm.branches,
                doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                extensions                       : [[$class: 'CloneOption', noTags: false, shallow: false, depth: 0, reference: '']],
                userRemoteConfigs                : scm.userRemoteConfigs,
        ])

        PipelineSteps steps = new PipelineSteps(this, new Config(params))
        stage('clean') {
            steps.clean()
        }
        stage('build') {
            steps.build()
        }
        stage('test') {
            steps.test()
        }
        stage('clean workspace') {
            steps.cleanWorkspace()
        }
    }
}

return this
