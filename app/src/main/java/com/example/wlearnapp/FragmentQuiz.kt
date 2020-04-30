package com.example.wlearnapp


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fragment_quiz.*
import kotlinx.android.synthetic.main.fragment_fragment_quiz.view.*


class FragmentQuiz : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater!!.inflate(R.layout.fragment_quiz_game, container, false)

        view.btn_start.setOnClickListener { view ->
            Log.d("btnStart", "Selected")
        }

        // Return the fragment view/layout
        return view
    }

    companion object {
        fun newInstance(): FragmentQuiz {
            return FragmentQuiz()
        }
    }



}
