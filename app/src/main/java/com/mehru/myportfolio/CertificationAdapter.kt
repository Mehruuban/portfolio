package com.mehru.myportfolio

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CertificationAdapter(
    private val certifications: MutableList<CertificationModel>
) : RecyclerView.Adapter<CertificationAdapter.CertificationViewHolder>() {

    inner class CertificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvCertificateTitle)
        val issuer: TextView = itemView.findViewById(R.id.tvCertificateIssuer)
        val deleteIcon: ImageView = itemView.findViewById(R.id.ivDeleteCertificate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CertificationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_certification, parent, false)
        return CertificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: CertificationViewHolder, position: Int) {
        val item = certifications[position]
        holder.title.text = item.title
        holder.issuer.text = item.issuer

        holder.deleteIcon.setOnClickListener {
            val context = holder.itemView.context
            AlertDialog.Builder(context)
                .setTitle("Delete Certification")
                .setMessage("Do you want to delete this certification?")
                .setPositiveButton("Yes") { dialog, _ ->
                    certifications.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, certifications.size)
                    dialog.dismiss()
                }
                .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun getItemCount(): Int = certifications.size
}
