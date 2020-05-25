package com.malygos.gnemes.ui.fragment.blanck

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malygos.gnemes.data.network.GnemesApiService
import kotlinx.coroutines.launch

class BlankViewModel : ViewModel() {
    fun getMemePosts(){
        viewModelScope.launch { //no need to define Dispatchers, retrofit does that for you

        }
    }
}