package com.example.contact_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.contact_app.databinding.ActivityMainBinding
import com.example.contact_app.databinding.ContactDesignBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactList: MutableList<Contactdata>
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        myContactList = mutableListOf()

        myContactAdapter = ContactAdapter(myContactList)
        binding.recyclerView2.adapter = myContactAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()

        myContactAdapter= ContactAdapter(myContactList){

            val intent: Intent = Intent(this, ContactProfile::class.java)
            intent.putExtra("name" , it.contactName)
            intent.putExtra("number" , it.mobileNumber)

            startActivity(intent)
        }
        binding.recyclerView2.adapter = myContactAdapter

        viewModel.getAllContactItems(db).observe(this, {
            myContactAdapter = ContactAdapter(it)
            binding.recyclerView2.adapter = myContactAdapter
            myContactAdapter.notifyDataSetChanged()
        })

        binding.Save.setOnClickListener {
            val contactName : String = binding.contactName.text.toString()
            val mobileName : String = binding.mobileNumber.text.toString()
             binding.contactLogo.setImageResource(R.drawable.ic_lumb)

            val contactItem = Contactdata(it)
            viewModel.addContactItem(contactItem, db)

            myContactAdapter.notifyDataSetChanged()
            viewModel.addContactItem(contactItem, db)

            myContactAdapter.notifyDataSetChanged()
        }



    }
}