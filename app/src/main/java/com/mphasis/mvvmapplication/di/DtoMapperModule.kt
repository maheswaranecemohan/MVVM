package com.mphasis.mvvmapplication.di

import com.mphasis.mvvmapplication.network.model.people.PeopleDtoMapper
import com.mphasis.mvvmapplication.network.model.room.RoomDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object DtoMapperModule {

    @Singleton
    @Provides
    fun provideRoomDtoMapper(): RoomDtoMapper {
        return RoomDtoMapper()
    }

    @Singleton
    @Provides
    fun providePeopleDtoMapper(): PeopleDtoMapper {
        return PeopleDtoMapper()
    }
}