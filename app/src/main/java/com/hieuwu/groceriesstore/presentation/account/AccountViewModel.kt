package com.hieuwu.groceriesstore.presentation.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hieuwu.groceriesstore.domain.models.UserModel
import com.hieuwu.groceriesstore.domain.repository.UserRepository
import com.hieuwu.groceriesstore.presentation.utils.ObservableViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountViewModel @Inject constructor(private val userRepository: UserRepository) :
    ObservableViewModel() {

    private val _user =
        userRepository.getCurrentUser() as MutableLiveData<UserModel>
    val user: LiveData<UserModel?>
        get() = _user


    fun signOut() {
        viewModelScope.launch {
            userRepository.clearUser()
        }
    }

}