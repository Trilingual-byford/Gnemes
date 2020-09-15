package com.malygos.gnemes

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.malygos.gnemes.data.persistence.MemeDataBase
import com.malygos.gnemes.data.persistence.MemeDataBase.Companion.initMemeDataBase
import com.malygos.gnemes.data.persistence.MmkvService
import com.tencent.mmkv.MMKV
import com.tencent.mmkv.MMKV.defaultMMKV
import timber.log.Timber
import kotlin.lazy

class GnemesApp : Application() {
    companion object{
        val mmkvService: MmkvService by lazy {
            val mmkv = defaultMMKV()
            MmkvService(mmkv, Gson())
        }
    }
    override fun onCreate() {
        super.onCreate()
        initMemeDataBase(this)
        MMKV.initialize(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}