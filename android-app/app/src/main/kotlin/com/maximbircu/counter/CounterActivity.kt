package com.maximbircu.counter

import android.os.Bundle
import android.widget.TextView
import com.maximbircu.counter.mvp.BaseActivity
import com.maximbircu.counter.mvp.View

interface CounterView : View {
    fun setCounter(number: Int)
}

class CounterActivity : BaseActivity(), CounterView {
    override val presenter: CounterPresenter = CounterPresenter(this)
    override val contentResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<TextView>(R.id.increment).setOnClickListener(presenter::onIncrement)
        findViewById<TextView>(R.id.decrement).setOnClickListener(presenter::onDecrement)
    }

    override fun setCounter(number: Int) {
        findViewById<TextView>(R.id.counter).text = number.toString()
    }
}
