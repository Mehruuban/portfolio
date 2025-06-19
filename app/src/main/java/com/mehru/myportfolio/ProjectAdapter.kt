package com.example.portfolio

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mehru.myportfolio.ProjectModel
import com.mehru.myportfolio.R

class ProjectAdapter(
    private val projects: MutableList<ProjectModel>
) : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    inner class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvProjectTitle)
        val description: TextView = itemView.findViewById(R.id.tvProjectDescription)
        val deleteIcon: ImageView = itemView.findViewById(R.id.ivDeleteProject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)
        return ProjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = projects[position]
        holder.title.text = project.title
        holder.description.text = project.description

        holder.deleteIcon.setOnClickListener {
            val context = holder.itemView.context

            AlertDialog.Builder(context)
                .setTitle("Delete Project")
                .setMessage("Do you want to delete this project?")
                .setPositiveButton("Yes") { dialog, _ ->
                    projects.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, projects.size)
                    dialog.dismiss()
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun getItemCount(): Int = projects.size
}
