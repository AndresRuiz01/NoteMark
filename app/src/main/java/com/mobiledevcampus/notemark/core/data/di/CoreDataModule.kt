package com.mobiledevcampus.notemark.core.data.di

import com.mobiledevcampus.notemark.core.data.auth.EncryptedSessionStorage
import com.mobiledevcampus.notemark.core.data.networking.HttpClientFactory
import com.mobiledevcampus.notemark.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    single { HttpClientFactory(get()).build() }
}