package com.example.wlearnapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.wlearnapp.databinding.ActivityOptionBinding
import kotlinx.android.synthetic.main.activity_option.*

class OptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_option)

        topic_name.text = getIntent().getStringExtra("TOPICNAME")
        topic_description.text = getIntent().getStringExtra("TOPICDES")

        //Linking
        btn_lesson.setOnClickListener{
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
        }
        btn_exercise.setOnClickListener{
            val intent = Intent(this, FragmentTab::class.java)
            startActivity(intent)
        }
        btn_quiz.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

    }

}
