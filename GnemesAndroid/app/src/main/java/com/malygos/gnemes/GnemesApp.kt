package com.malygos.gnemes

import android.app.Application
import androidx.room.Room
import com.malygos.gnemes.data.persistence.MemeDataBase
import com.malygos.gnemes.data.persistence.MemeDataBase.Companion.initMemeDataBase

class GnemesApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initMemeDataBase(this)
    }

}