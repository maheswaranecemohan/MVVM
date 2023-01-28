package com.mphasis.mvvmapplication.di
import android.content.Context
import com.mphasis.mvvmapplication.application.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplicaiton(@ApplicationContext app :Context): BaseApplication{
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideAuthToken():String{
        return "Auth Token"
    }
}

