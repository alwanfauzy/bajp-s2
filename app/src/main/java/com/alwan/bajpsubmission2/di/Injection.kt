package com.alwan.bajpsubmission2.di

import com.alwan.bajpsubmission2.data.CatalogueRepository
import com.alwan.bajpsubmission2.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): CatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogueRepository.getInstance(remoteDataSource)
    }
}