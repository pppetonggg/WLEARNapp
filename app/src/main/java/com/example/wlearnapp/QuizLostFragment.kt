package com.example.wlearnapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.wlearnapp.databinding.FragmentQuizLostBinding


/**
 * A simple [Fragment] subclass.
 */
class QuizLostFragment : Fragment() {
    lateinit var binding:FragmentQuizLostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz_lost, container, false)
        binding.btnTryAgain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quizLostFragment_to_quizFragment)
        }
        return binding.root
    }
}