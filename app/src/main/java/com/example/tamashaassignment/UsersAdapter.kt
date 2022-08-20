package com.example.tamashaassignment

import android.content.Context
import android.transition.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tamashaassignment.model.Data
import kotlinx.android.synthetic.main.user_item.view.*

class UsersAdapter(private val context:Context,private var usersResponse: ArrayList<Data>) :RecyclerView.Adapter<UsersAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item,parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user = usersResponse[position]

        holder.title.text = user.employee_name
        holder.id.text= user.id.toString()
        holder.salary.text = user.employee_salary.toString()

        holder.cardView.setOnClickListener {
            holder.salary.visibility = View.VISIBLE
        }

    }

    override fun getItemCount(): Int {
      return usersResponse.size
    }

    fun setUserData(postList: ArrayList<Data>) {
        this.usersResponse = postList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.txtName)
        val id:TextView = itemView.findViewById(R.id.txtSubject)
        val salary:TextView = itemView.findViewById(R.id.salary)
        val cardView:CardView = itemView.findViewById(R.id.card_view)


    }
}