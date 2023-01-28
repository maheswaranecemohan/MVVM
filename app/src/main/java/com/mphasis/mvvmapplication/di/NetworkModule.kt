package com.mphasis.mvvmapplication.di
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

@Singleton
@Provides
fun provideRetrofit():Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://61e947967bc0550017bc61bf.mockapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
    }

    //@Singleton
    //@Provides
}