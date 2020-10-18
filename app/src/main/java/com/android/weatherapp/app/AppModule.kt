package com.android.weatherapp.app

import com.android.usecase.Computation
import com.android.usecase.Io
import com.android.usecase.Ui
import com.android.weatherapp.GlideImageLoader
import com.android.weatherapp.ImageLoader
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InstallIn(ApplicationComponent::class)
@Module
abstract class AppModule {

    @Binds
    abstract fun bindImageLoader(loader: GlideImageLoader): ImageLoader

    companion object {

        @Provides
        @Io
        fun provideIoScheduler(): Scheduler = Schedulers.io()

        @Provides
        @Computation
        fun provideComputationScheduler(): Scheduler = Schedulers.computation()

        @Provides
        @Ui
        fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()
    }
}
