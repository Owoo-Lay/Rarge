package com.example.contact_app

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =
    arrayOf(Contactdata::class),
    version = 1)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun ContactDAO(): ContactDAO
}