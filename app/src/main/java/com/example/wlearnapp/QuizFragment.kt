package com.example.simplequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.wlearnapp.R
import com.example.wlearnapp.databinding.FragmentQuizBinding


/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment() {
    lateinit var binding:FragmentQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz,container,false)
        binding.btnPlay.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quizFragment_to_quizGameFragment)
        }

        return binding.root
    }
}

