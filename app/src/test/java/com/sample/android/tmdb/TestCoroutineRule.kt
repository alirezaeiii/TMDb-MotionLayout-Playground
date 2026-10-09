package com.sample.android.tmdb

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@OptIn(ExperimentalCoroutinesApi::class)
class TestCoroutineRule : TestRule {
    override fun apply(base: Statement, description: Description?) = object : Statement() {
        override fun evaluate() {
            Dispatchers.setMain(Dispatchers.Unconfined)

            base.evaluate()

            Dispatchers.resetMain()
        }
    }
}