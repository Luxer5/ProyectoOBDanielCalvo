package com.example.disneyappob.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.disneyappob.data.local.model.CharacterLocal

interface DisneyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFav(character: CharacterLocal)

    @Delete
    suspend fun deleteFav(character: CharacterLocal)


}