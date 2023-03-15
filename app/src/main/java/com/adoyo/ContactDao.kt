package com.adoyo

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface ContactDao {

    @Upsert
    suspend fun upsertContact(contacts: Contacts)

    @Delete
    suspend fun deleteContact(contacts: Contacts)

    @Query("SELECT * FROM Contacts ORDER BY firstName")
    fun getContactsOrderedByFirstName(): Flow<List<Contacts>>

    @Query("SELECT * FROM Contacts ORDER BY lastName")
    fun getContactsOrderedByLastName(): Flow<List<Contacts>>

    @Query("SELECT * FROM Contacts ORDER BY phoneNumber")
    fun getContactsOrderedByPhoneNumber(): Flow<List<Contacts>>

}