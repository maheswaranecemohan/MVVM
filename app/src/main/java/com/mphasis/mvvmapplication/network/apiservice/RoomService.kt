package com.mphasis.mvvmapplication.network.apiservice
import com.mphasis.mvvmapplication.network.model.room.RoomDto
import retrofit2.http.GET
interface RoomService {
    @GET("rooms")
    suspend fun getRooms():List<RoomDto>
}