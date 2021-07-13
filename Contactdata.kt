package com.example.contact_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contactdata(
    val contactName: String,
    val mobileNumber: String,
    val contactLogo: Int,
    @PrimaryKey(autoGenerate = true)
val uid: Int = 0


)
