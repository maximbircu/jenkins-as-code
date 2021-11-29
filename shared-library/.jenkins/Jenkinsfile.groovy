@Library('shared-library') _

import com.maximbircu.sharedlibrary.GroovyPipelineSteps
import com.maximbircu.sharedlibrary.Config

node('jenkins') {
    Config config = new Config([projectRootDirectory: "shared-library"])
    GroovyPipelineSteps steps = new GroovyPipelineSteps(this, config)

    stage("scm") {
        checkout scm
    }

    stage('clean') {
        steps.clean()
    }

    stage('codenarc') {
        steps.codenarc()
    }

    stage('test') {
        steps.test()
    }

    stage('clean workspace') {
        steps.cleanWorkspace()
    }
}
