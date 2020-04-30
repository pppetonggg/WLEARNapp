package com.example.wlearnapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wlearnapp.databinding.ActivityRecyclerViewTopicBinding
import kotlinx.android.synthetic.main.activity_recycler_view_topic.*

class RecyclerViewTopic : AppCompatActivity(), OnTopicItemClickListener {
    private lateinit var binding: ActivityRecyclerViewTopicBinding
    private lateinit var topiclist: ArrayList<Topic>
    private lateinit var editTextSearch : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_view_topic)
        topiclist = ArrayList()
        addTopic()
        val topSpacing = TopSpacingItemDecoration(30)
        topicRecycler.addItemDecoration(topSpacing)
        topicRecycler.layoutManager = LinearLayoutManager(this)
        topicRecycler.addItemDecoration(DividerItemDecoration(this,1))
        topicRecycler.adapter = RecyclerViewAdapter(topiclist,this)

    }


    fun addTopic(){
        topiclist.add(Topic( "TCP/IP",
            "Internet Protocol(IP)\nTransport Control Protocol/User Datagram Protocol(UDP)\nInternet Control Message Protoccol",
            R.drawable.tcpip1))
        topiclist.add(Topic( "OSI Model",
            "Characteristics of OSI Model\nFunctions of the OSI Layers",
            R.drawable.osimodel2))
        topiclist.add(Topic( "Automatic Repeat Request",
            "Stop-and-Wait ARQ\nGo-Back-N ARQ\nSelective Repeat ARQ/Selective Reject ARQ",
            R.drawable.arq3))
        topiclist.add(Topic( "Routing Protocols",
            "Distance Vector(RIP,IGRP)\nLink State(OSPF,IS-IS)",
            R.drawable.routing4))
        topiclist.add(Topic( "TCP Congestion Control",
            "Window Management\nEvolution of Congestion Control Algorithm",
            R.drawable.last))
    }

    override fun onItemClick(item: Topic, position: Int) {
        //Toast.makeText(this,item.topics, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, FragmentTab::class.java)
        intent.putExtra("CARNAME",item.topics)
        startActivity(intent)
    }
}
