package com.example.wlearnapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                //create 3 fragments
                FragmentLesson()
            }
            1->{
                FragmentExercise()
            }
            else->{
                return FragmentQuiz()
            }

            //this for tab position
        }
    }

    override fun getCount(): Int {
        return 3
        //this will return 3 tabs
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"Lesson"
            1->"Exercise"
            else->{
                return "Quiz"
            }
            //set tab titles
        }
    }
}