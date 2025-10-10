package com.example.jpmchase.di

import com.example.jpmchase.FirebaseRepository
import com.example.jpmchase.SqlRepository
import com.example.jpmchase.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
//for classes present in other libraries to which you cant add @inject besides the constructor
@InstallIn(FragmentComponent::class)
@Module
abstract class UserModule {

//    @Provides
//    fun providesUserRepository(sqlRepository: SqlRepository):UserRepository{
//        return sqlRepository
//    }
    @Binds
abstract  fun providesUserRepository(sqlRepository: SqlRepository):UserRepository
}