package com.maximbircu.sharedlibrary

class PipelineSteps {
    private Script script
    private Config config

    PipelineSteps(Script script, Config config) {
        this.script = script
        this.config = config

    }

    void clean() {
        gradlew "clean"
    }

    void build() {
        gradlew "assembleDebug"
    }

    void test() {
        gradlew "test"
    }

    void cleanWorkspace() {
        script.cleanWs cleanWhenFailure: false
    }

    private void gradlew(String command) {
        script.dir("${script.env.WORKSPACE}/${config.androidAppRootDirectory}") { script.sh "./gradlew $command" }
    }
}
