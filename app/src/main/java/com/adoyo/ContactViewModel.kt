package com.adoyo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactViewModel(
    private val dao: ContactDao
) : ViewModel() {
    private val _sortType = MutableStateFlow(SortType.FIRST_NAME)
    private val _state = MutableStateFlow(ContactState())

    fun onEvent(event: ContactEvent) {
        when (event) {
            is ContactEvent.DeleteContact -> {
                viewModelScope.launch {
                    dao.deleteContact(event.contacts)
                }
            }

            ContactEvent.HideDialog -> {
                _state.update { it.copy(isAddingContact = false) }
            }

            ContactEvent.SaveContact -> TODO()
            is ContactEvent.SetFirstName -> {
                viewModelScope.launch {
                    _state.update { it.copy(firstName = event.firstName) }
                }
            }

            is ContactEvent.SetLastName -> {
                viewModelScope.launch {
                    _state.update { it.copy(lastName = event.lastname) }
                }
            }

            is ContactEvent.SetPhoneNumber -> {
                viewModelScope.launch {
                    _state.update { it.copy(phoneNumber = event.phoneNumber) }
                }
            }

            ContactEvent.ShowDialog -> {
                _state.update { it.copy(isAddingContact = false) }
            }

            is ContactEvent.SortContact -> {
                _sortType.value = event.sortType
            }
        }
    }
}