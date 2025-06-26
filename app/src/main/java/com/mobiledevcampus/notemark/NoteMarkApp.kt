package com.mobiledevcampus.notemark

import android.app.Application
import com.mobiledevcampus.notemark.auth.presentation.di.authViewModelModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class NoteMarkApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger()
            androidContext(this@NoteMarkApp)
            modules(
                authViewModelModule,
            )
        }
    }

}