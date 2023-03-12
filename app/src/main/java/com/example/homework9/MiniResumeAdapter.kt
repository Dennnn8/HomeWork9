package com.example.homework9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MiniResumeAdapter : RecyclerView.Adapter<MiniResumeAdapter.ContactsViewHolder>() {

    private var MiniResumeList = emptyList<MiniResume>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.resume_view_holder, parent, false)
        return ContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val currentItem = MiniResumeList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = MiniResumeList.size

    class ContactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.findViewById<TextView>(R.id.item_title)
        private val detail = view.findViewById<TextView>(R.id.item_detail)

        fun bind(contact: MiniResume) {
            title.text = contact.title
            detail.text = contact.detail.toString()

        }
    }

    fun setData(contactsList: List<MiniResume>) {
        this.MiniResumeList = contactsList
        notifyDataSetChanged()
    }
}