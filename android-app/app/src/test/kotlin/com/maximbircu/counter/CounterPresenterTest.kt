package com.maximbircu.counter

import org.junit.Assert.assertEquals
import org.junit.Test

class CounterPresenterTest {
    private val view = CounterViewStub()
    private val presenter = CounterPresenter(view)

    @Test
    fun `resets counter on create`() {
        presenter.onCreate()

        assertEquals(0, view.counter)
    }

    @Test
    fun `increments counter`() {
        presenter.onCreate()

        presenter.onIncrement()

        assertEquals(1, view.counter)
    }

    @Test
    fun `decrements counter`() {
        presenter.onCreate()

        presenter.onDecrement()

        assertEquals(-1, view.counter)
    }
}

class CounterViewStub : CounterView {
    var counter: Int? = null

    override fun setCounter(number: Int) {
        counter = number
    }
}
