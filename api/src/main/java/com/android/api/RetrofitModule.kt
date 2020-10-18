package com.android.api

import com.android.usecase.Io
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.Scheduler
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class RetrofitModule {
    companion object {

        @Singleton
        @Provides
        internal fun provideRetrofit(
            client: OkHttpClient,
            @Io scheduler: Scheduler,
            gson: Gson
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler))
                .build()
        }

        @Provides
        fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
    }
}