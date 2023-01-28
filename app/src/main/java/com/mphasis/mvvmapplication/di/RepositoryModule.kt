package com.mphasis.mvvmapplication.di
import com.mphasis.mvvmapplication.network.apiservice.RoomService
import com.mphasis.mvvmapplication.network.model.room.RoomDtoMapper
import com.mphasis.mvvmapplication.repository.GetRoomDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @ViewModelScoped
    @Provides
    fun provideRoomDetails(
        userService: RoomService,
        roomDtoMapper: RoomDtoMapper
    ): GetRoomDetails {
        return GetRoomDetails(
            roomService = userService,
            roomDtoMapper = roomDtoMapper
        )
    }
}