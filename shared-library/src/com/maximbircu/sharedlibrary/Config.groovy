package com.maximbircu.sharedlibrary

class Config {
    /**
     * The root directory of the app.
     */
    String androidAppRootDirectory

    Config(Map params) {
        this.androidAppRootDirectory = params.get("androidAppRootDirectory")
    }
}
