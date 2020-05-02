package com.example.wlearnapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.example.wlearnapp.databinding.ActivityOptionBinding
import kotlinx.android.synthetic.main.activity_option.*

class OptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityOptionBinding
    lateinit var btn : Button
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
        btn = findViewById<Button>(R.id.btn_quiz)
        btn.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }

}
