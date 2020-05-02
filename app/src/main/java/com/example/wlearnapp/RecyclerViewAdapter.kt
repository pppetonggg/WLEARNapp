package com.example.wlearnapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*

class RecyclerViewAdapter (var items : ArrayList<Topic>, var clickListener: OnTopicItemClickListener): RecyclerView.Adapter<TopicViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        lateinit var  topicViewHolder : TopicViewHolder
        topicViewHolder = TopicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent,false))
        return topicViewHolder
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        /*holder.topicName?.text = items.get(position).topics
        holder.topicDescription?.text = items.get(position).description
        holder.topicImage.setImageResource(items.get(position).image)*/
        holder.initialize(items.get(position),clickListener)
    }

}

class TopicViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    var topicName = itemView.topicname
    var topicDescription = itemView.topicdescription
    var topicImage = itemView.topicimage

    fun initialize(item: Topic, action: OnTopicItemClickListener){
        topicName.text = item.topics
        topicDescription.text = item.description
        topicImage.setImageResource(item.image)

        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnTopicItemClickListener{
    fun onItemClick(item: Topic, position: Int)
}