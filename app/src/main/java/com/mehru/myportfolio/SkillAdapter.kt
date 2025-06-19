package com.mehru.myportfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class SkillAdapter(private val skills: MutableList<String>) :
    RecyclerView.Adapter<SkillAdapter.SkillViewHolder>() {

    inner class SkillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSkillName: TextView = itemView.findViewById(R.id.tvSkillName)
        val ivDeleteSkill: ImageView = itemView.findViewById(R.id.ivDeleteSkill)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
        return SkillViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.tvSkillName.text = skills[position]
        val context = holder.itemView.context

        holder.ivDeleteSkill.setOnClickListener {
            skills.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, skills.size)

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete Skill")
            builder.setMessage("do you want to delete the skill ?")


        }
    }

    override fun getItemCount(): Int {
        return skills.size
    }

}
