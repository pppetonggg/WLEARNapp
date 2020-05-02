package com.example.wlearnapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_fragment_tab.*

class FragmentTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_tab)

        //create adapter class already
        toolBar.setTitle("Exercise")
        setSupportActionBar(toolBar)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        viewPager.setSwipePagingEnabled(false)
        tabLayout.setupWithViewPager(viewPager)
    }
}
