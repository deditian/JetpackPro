package com.dedi.movies.testing

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class SingleFragmentActivity : AppCompatActivity() {

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val content = FrameLayout(this)
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT,
            Gravity.CENTER
        )
        content.layoutParams = params
//        content.id = R.id.viewPager

        setContentView(content)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
//            .add(R.id.viewPager, fragment, "TEST")
            .commit()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
//            .add(R.id.viewPager, fragment)
            .commit()
    }
}