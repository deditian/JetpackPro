package com.dedi.myapplication.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.dedi.myapplication.R
import com.dedi.myapplication.testing.SingleFragmentActivity
import com.dedi.myapplication.utils.EspressoIdlingResource
import com.dedi.myapplication.utils.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java)
    private val moviesFragment = MovieFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(moviesFragment)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource)
    }

    @Test
    fun getData() {
        onView(withId(R.id.rv_movies))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).check(RecyclerViewItemCountAssertion(10))
    }
}