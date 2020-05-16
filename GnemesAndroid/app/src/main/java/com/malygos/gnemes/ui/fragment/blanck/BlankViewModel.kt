package com.malygos.gnemes.ui.fragment.blanck

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malygos.gnemes.data.network.GnemesApiService
import kotlinx.coroutines.launch

class BlankViewModel : ViewModel() {
    fun getMemePosts(){
        viewModelScope.launch { //no need to define Dispatchers, retrofit does that for you
            try {
                val response = GnemesApiService.invoke().getMemePostsAsync()
                if (response.isSuccessful) {
                    //basically handle what my Deferred type is holding
                    Log.d("Scope",response.toString())
                } else {
                    //Deal with non successful response.
                    Log.d("ScopeFail", response.toString())
                }
            } catch (e: Exception) {
                //Deal with error.
                e.printStackTrace()
                Log.d("Scope", "Exception")

            }
        }
    }
}