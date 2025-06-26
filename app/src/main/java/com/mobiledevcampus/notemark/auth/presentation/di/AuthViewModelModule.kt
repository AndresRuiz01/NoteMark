package com.mobiledevcampus.notemark.auth.presentation.di

import com.mobiledevcampus.notemark.auth.presentation.registration.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegistrationViewModel)
}