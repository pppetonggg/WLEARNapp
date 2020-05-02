package com.example.wlearnapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class QuizAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                //create 3 fragments
                QuizFragment()
            }
            1->{
                QuizGameFragment()
            }
            3->{
                QuizLostFragment()
            }
            else->{
                return QuizWonFragment()
            }

            //this for tab position
        }
    }

    override fun getCount(): Int {
        return 4
    }

}