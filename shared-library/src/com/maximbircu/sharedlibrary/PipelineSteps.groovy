package com.maximbircu.sharedlibrary

class PipelineSteps {
    private Script script

    PipelineSteps(Script script) {
        this.script = script
    }

    void clean() {
        script.sh "${script.env.WORKSPACE}/gradlew clean"
    }

    void build() {
        script.sh "${script.env.WORKSPACE}/gradlew assembleDebug"
    }

    void test() {
        script.sh "${script.env.WORKSPACE}/gradlew test"
    }
}
