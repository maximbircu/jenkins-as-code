package com.maximbircu.sharedlibrary

import groovy.mock.interceptor.MockFor
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse

class PipelineStepsTest {
    private def scriptMock = new MockFor(MockPipelineScript)

    @Test
    void "runs the clean gradle task"() {
        scriptMock.demand.getEnv { [WORKSPACE: ""] }
        scriptMock.demand.dir { path, function ->
            assertEquals("/android-app", path.toString())
            function()
        }

        assertBashCommandExecuted("./gradlew clean")

        def config = new Config([projectRootDirectory: "android-app"])

        def instance = scriptMock.proxyInstance()
        new AndroidAppPipelineSteps(instance, config).clean()
        scriptMock.verify(instance)
    }

    @Test
    void "runs the test gradle task"() {
        scriptMock.demand.getEnv { [WORKSPACE: ""] }
        scriptMock.demand.dir { path, function ->
            assertEquals("/android-app", path.toString())
            function()
        }

        assertBashCommandExecuted("./gradlew test")

        def config = new Config([projectRootDirectory: "android-app"])

        def instance = scriptMock.proxyInstance()
        new AndroidAppPipelineSteps(instance, config).test()
        scriptMock.verify(instance)
    }

    @Test
    void "runs the assemble gradle task"() {
        scriptMock.demand.getEnv { [WORKSPACE: ""] }
        scriptMock.demand.dir { path, function ->
            assertEquals("/android-app", path.toString())
            function()
        }

        assertBashCommandExecuted("./gradlew assembleDebug")

        def config = new Config([projectRootDirectory: "android-app"])

        def instance = scriptMock.proxyInstance()
        new AndroidAppPipelineSteps(instance, config).assemble()
        scriptMock.verify(instance)
    }

    @Test
    void "cleans the workspace"() {
        scriptMock.demand.cleanWs { args -> assertFalse(args.cleanWhenFailure) }

        def config = new Config([projectRootDirectory: "android-app"])

        def instance = scriptMock.proxyInstance()
        new AndroidAppPipelineSteps(instance, config).cleanWorkspace()
        scriptMock.verify(instance)
    }

    private void assertBashCommandExecuted(String expectedCommand) {
        scriptMock.demand.sh { actualCommand ->
            assertEquals(expectedCommand, actualCommand.toString())
        }
    }
}

class MockPipelineScript extends Script {
    @Override
    Object run() {
        return null
    }
}
