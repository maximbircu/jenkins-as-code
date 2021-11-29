package com.maximbircu.sharedlibrary

/**
 * The pipeline config
 */
class Config {
    /**
     * The root directory of the project.
     */
    String projectRootDirectory

    Config(Map params) {
        this.projectRootDirectory = params.get("projectRootDirectory")
    }
}
