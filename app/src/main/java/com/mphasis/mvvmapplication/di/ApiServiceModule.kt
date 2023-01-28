package com.mphasis.mvvmapplication.di

import com.mphasis.mvvmapplication.network.apiservice.PeopleService
import com.mphasis.mvvmapplication.network.apiservice.RoomService
import com.vm.smacompose.domain.model.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Singleton
    @Provides
    fun provideRoomService(retrofit :Retrofit):RoomService{
        return retrofit.create(RoomService::class.java)
    }

    @Singleton
    @Provides
    fun providePeopleService(retrofit: Retrofit):PeopleService{
        return retrofit.create(PeopleService::class.java)
    }

}