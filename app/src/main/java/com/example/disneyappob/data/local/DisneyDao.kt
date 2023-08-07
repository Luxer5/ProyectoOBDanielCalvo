package com.example.disneyappob.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.disneyappob.data.local.model.CharacterLocal

@Dao
interface DisneyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFav(character: CharacterLocal)

    @Delete
    suspend fun deleteFav(character: CharacterLocal)

    @Query("SELECT * FROM DisneyFavoriteTable")
    suspend fun getAll() : List<CharacterLocal>


}