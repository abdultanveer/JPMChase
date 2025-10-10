package com.example.jpmchase.di

import com.example.jpmchase.FirebaseRepository
import com.example.jpmchase.SqlRepository
import com.example.jpmchase.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

@InstallIn(ActivityComponent::class)
@Module
class UserModule {

    @Provides
    @FirebaseQualifier
    fun providesFirebaseRepository():UserRepository{
        return FirebaseRepository()
    }

    @Named("sql")
    @Provides
    fun providesSqlRepository():UserRepository{
        return SqlRepository()
    }
}