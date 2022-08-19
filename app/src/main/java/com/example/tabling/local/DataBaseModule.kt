package com.example.tabling.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideShopDataBase(@ApplicationContext context: Context): ShopDataBase {
        return Room.databaseBuilder(context, ShopDataBase::class.java, SHOP_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideShopDao(database: ShopDataBase): ShopDao {
        return database.shops()
    }

    companion object {
        private const val SHOP_DATABASE_NAME = "shop_data_base"
    }
}