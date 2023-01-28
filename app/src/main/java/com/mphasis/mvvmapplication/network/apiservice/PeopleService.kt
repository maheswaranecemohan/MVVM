package com.mphasis.mvvmapplication.network.apiservice
import com.mphasis.mvvmapplication.network.model.people.PeopleDto
import retrofit2.http.GET
interface PeopleService {
    @GET("people")
    suspend fun getPeople(): List<PeopleDto>
}