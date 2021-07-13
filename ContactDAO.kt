package com.example.contact_app

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Query

@Dao
interface ContactDAO {
    @Insert
    fun addContactItem(contactItem: Contactdata)

    @Query("SELECT * from Contactdata")
    fun getAllContactItems(): LiveData<List<Contactdata>>

    @Delete
    fun delete(contactItem: Contactdata)
}


