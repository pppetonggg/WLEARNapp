package com.example.wlearnapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                //create 3 fragments
                ExerciseOne()
            }
            1->{
                ExerciseTwo()
            }
            else->{
                return ExerciseThree()
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
            0->"Exercise1"
            1->"Exercise2"
            else->{
                return "Exercise3"
            }
            //set tab titles
        }
    }
}