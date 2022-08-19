package com.example.tabling.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tabling.local.model.ShopEntity


@Database(
    entities = [
        ShopEntity::class
    ],
    version = 1
)
abstract class ShopDataBase : RoomDatabase() {

    abstract fun shops(): ShopDao
}