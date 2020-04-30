package com.example.wlearnapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil


/**
 * A simple [Fragment] subclass.
 */
class QuizGame : Fragment() {
    //lateinit var binding: FragmentQuizGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz_game,container,false)
        //return binding.root
        return inflater.inflate(R.layout.fragment_quiz_game, container, false)
    }


}
