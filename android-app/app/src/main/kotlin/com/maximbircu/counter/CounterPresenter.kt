package com.maximbircu.counter

import com.maximbircu.counter.mvp.Presenter

class CounterPresenter(view: CounterView) : Presenter<CounterView>(view) {
    private var count: Int = 0

    override fun onCreate() {
        view.setCounter(count)
    }

    fun onIncrement() {
        count++
        view.setCounter(count)
    }

    fun onDecrement() {
        count--
        view.setCounter(count)
    }
}
