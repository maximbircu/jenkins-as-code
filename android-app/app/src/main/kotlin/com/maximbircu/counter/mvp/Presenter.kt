package com.maximbircu.counter.mvp

abstract class Presenter<V>(protected val view: V) {
    open fun onCreate() {}

    open fun onStart() {}

    open fun onPause() {}

    open fun onResume() {}

    open fun onStop() {}

    open fun onDestroy() {}
}
