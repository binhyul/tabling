package com.example.tabling.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tabling.local.model.ShopEntity


@Dao
interface ShopDao {

    @Insert
    fun insertShop(shop: ShopEntity)

    @Query("SELECT * FROM shop")
    fun getShopList(): List<ShopEntity>

    @Query("DELETE FROM shop WHERE id = :id")
    fun deleteShop(id: Int)

    @Query("DELETE FROM shop")
    fun clear()

}