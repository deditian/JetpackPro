package com.dedi.myapplication.feature.tvshow

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.dedi.myapplication.R
import com.dedi.myapplication.testing.SingleFragmentActivity
import com.dedi.myapplication.utils.EspressoIdlingResource
import com.dedi.myapplication.utils.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvShowFragmentTest {

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private val tvShowFragment = TvShowFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(tvShowFragment)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource)
    }

    @Test
    fun getData() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_tv_show)).check(RecyclerViewItemCountAssertion(10))
    }
}