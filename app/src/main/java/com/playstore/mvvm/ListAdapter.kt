package com.playstore.mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.playstore.mvvm.databinding.ListItemBinding

class ListAdapter (private var userList: List<User>) : RecyclerView.Adapter<ListAdapter.ViewHolder> () {

    fun setUserList(userList1: List<User>){
        userList = userList1
    }

   /* class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title : TextView = view.findViewById(R.id.title)
        val userId : TextView = view.findViewById(R.id.userId)
        val status : TextView = view.findViewById(R.id.status)
    }*/

    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      //  val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        val binding =ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
      //  return ViewHolder(itemView)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       /* holder.title.text = userList.get(position).title
        holder.userId.text = userList.get(position).userId.toString()
        holder.status.text = if (userList.get(position).completed) "yes" else "no"*/

        with(holder){
            with(userList[position]){
                binding.title.text = this.title
                binding.userId.text = this.userId.toString()
                binding.status.text = if (this.completed) "Yes" else "no"
            }
        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}