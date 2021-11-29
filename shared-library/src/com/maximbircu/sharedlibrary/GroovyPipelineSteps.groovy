package com.maximbircu.sharedlibrary

/**
 * Android application pipeline steps.
 */
class GroovyPipelineSteps {
    private final Script script
    private final Config config

    GroovyPipelineSteps(Script script, Config config) {
        this.script = script
        this.config = config
    }

    void clean() {
        gradlew "clean"
    }

    void test() {
        gradlew "test"
    }

    void codenarc() {
        gradlew "codenarcAllSources"
    }

    void cleanWorkspace() {
        script.cleanWs cleanWhenFailure: false
    }

    private void gradlew(String command) {
        script.dir("${script.env.WORKSPACE}/${config.projectRootDirectory}") { script.sh "./gradlew $command" }
    }
}
