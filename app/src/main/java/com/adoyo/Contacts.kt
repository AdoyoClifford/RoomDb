package com.adoyo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contacts(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)