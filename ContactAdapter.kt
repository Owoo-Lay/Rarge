package com.example.contact_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact_app.databinding.ContactDesignBinding

class ContactAdapter(val contactItems: List<Contactdata>,
    val clickerFnx: (Contactdata) -> Unit):
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
       inner class ViewHolder(val binding: ContactDesignBinding):
            RecyclerView.ViewHolder(binding.root){
              fun bind(contactItem:Contactdata){
                binding.contactLogo.setImageResource(R.drawable.ic_lumb)
                  binding.contactName.text=contactItem.contactName
                  binding.mobileNumber.text=contactItem.mobileNumber

                  binding.root.setOnClickListener{
                      clickerFnx(contactItem)
                  }
              }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactDesignBinding =
            ContactDesignBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contactItem = contactItems.get(position)
        holder.bind(contactItem)
    }

    override fun getItemCount(): Int {
        return contactItems.size
    }

}