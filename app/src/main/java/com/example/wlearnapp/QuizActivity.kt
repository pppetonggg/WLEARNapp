package com.example.wlearnapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragment_tab.*

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val fragmentAdapter = QuizAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
    }
}


