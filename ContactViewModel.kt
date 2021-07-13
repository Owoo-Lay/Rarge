package com.example.contact_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ContactViewModel: ViewModel() {
    fun addContactItem(contactItem: Contactdata,
    database: ContactDatabase) {
        database.ContactDAO().addContactItem(contactItem)
    }
    fun getAllContactItems(database: ContactDatabase):
    LiveData<List<Contactdata>>{
    return database.ContactDAO().getAllContactItems()
    }
}