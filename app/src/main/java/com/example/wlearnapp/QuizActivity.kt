package com.example.wlearnapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
=======
import kotlinx.android.synthetic.main.activity_fragment_tab.*
>>>>>>> e4e42cbb1c18717836c2c983652c68355f2cd9aa

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
<<<<<<< HEAD
=======

        val fragmentAdapter = QuizAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
>>>>>>> e4e42cbb1c18717836c2c983652c68355f2cd9aa
    }
}


