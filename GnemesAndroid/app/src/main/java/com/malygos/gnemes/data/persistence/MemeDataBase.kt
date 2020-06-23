package com.malygos.gnemes.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.malygos.gnemes.data.entity.MemePost

@Database(entities = [MemePost::class], version = 2, exportSchema = true)
abstract class MemeDataBase : RoomDatabase() {
    abstract fun posterDao(): MemeDao

    companion object {
        lateinit var dataBase: MemeDataBase
        fun getMemeDataBase(): MemeDataBase {
            return dataBase
        }

        fun initMemeDataBase(context: Context) {
            dataBase = Room.databaseBuilder(
                context, MemeDataBase::class.java,
                "MemePost.db"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}