package com.tour_it.sources.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tour_it.sources.room.entities.EventEntity
import com.tour_it.sources.room.entities.HotelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HotelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(hotel: HotelEntity)

    @Query("DELETE FROM hotels")
    suspend fun deleteAllHotels()

    @Query("SELECT * FROM hotels")
    fun getAllHotels(): Flow<List<HotelEntity>>
}