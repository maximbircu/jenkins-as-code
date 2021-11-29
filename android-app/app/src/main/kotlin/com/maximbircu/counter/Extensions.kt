package com.maximbircu.counter

import android.view.View

fun View.setOnClickListener(listener: () -> Unit) {
    setOnClickListener { listener() }
}
