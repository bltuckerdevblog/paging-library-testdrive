package com.abnormallydriven.paginglibrarytestdrive

import com.abnormallydriven.paginglibrarytestdrive.sync.FootballApi
import dagger.Module
import dagger.Provides
import okhttp3.*
import retrofit2.Retrofit
import java.io.File
import javax.inject.Singleton


@Module
class HttpModule {


    @Provides
    @Singleton
    fun provideOkHttpCache(cacheDirectory : File) : Cache{
        val cacheSize: Long = 10 * 1024 * 1024 // 10 MiB
        return Cache(cacheDirectory, cacheSize)
    }

    @Provides
    @Singleton
    fun provideDefaultHeaderInterceptor() : Interceptor{
        return Interceptor { chain ->
            val updatedRequest = chain!!.request()
                    .newBuilder()
                    .addHeader("X-Auth-Token", BuildConfig.API_KEY)
                    .build()

            chain.proceed(updatedRequest)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, defaultHeaderInterceptor: Interceptor) : OkHttpClient{
        val builder = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(defaultHeaderInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(okhttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
                .baseUrl("http://www.football-data.org/v1/")
                .client(okhttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideFootballApiService(retrofit : Retrofit) : FootballApi{
        return retrofit.create(FootballApi::class.java)
    }

}
