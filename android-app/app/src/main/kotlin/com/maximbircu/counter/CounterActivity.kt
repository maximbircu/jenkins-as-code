package com.maximbircu.counter

import android.os.Bundle
import com.maximbircu.counter.mvp.BaseActivity
import com.maximbircu.counter.mvp.View
import kotlinx.android.synthetic.main.activity_main.*

interface CounterView : View {
    fun setCounter(number: Int)
}

class CounterActivity : BaseActivity(), CounterView {
    override val presenter: CounterPresenter = CounterPresenter(this)
    override val contentResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        increment.setOnClickListener(presenter::onIncrement)
        decrement.setOnClickListener(presenter::onDecrement)
    }

    override fun setCounter(number: Int) {
        counter.text = number.toString()
    }
}
