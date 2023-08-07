package com.example.disneyappob.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.disneyappob.data.local.model.CharacterLocal

@Database(entities = [CharacterLocal::class], version =1)
abstract class DisneyDatabase : RoomDatabase(){

    abstract fun disneyDao(): DisneyDao
}