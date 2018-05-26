package com.abnormallydriven.paginglibrarytestdrive.common

import com.abnormallydriven.paginglibrarytestdrive.BuildConfig
import com.abnormallydriven.paginglibrarytestdrive.names.NamesApi
import com.abnormallydriven.paginglibrarytestdrive.products.ProductsApi
import com.abnormallydriven.paginglibrarytestdrive.teamlist.DataService
import com.abnormallydriven.paginglibrarytestdrive.sync.FootballApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import javax.inject.Singleton


@Module
class HttpModule {

    @Provides
    @Singleton
    fun provideGson() : Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson : Gson) : GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }


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
    @FootbalHttpClient
    fun provideFootballOkHttpClient(cache: Cache, defaultHeaderInterceptor: Interceptor) : OkHttpClient{
        val builder = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(defaultHeaderInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    @FootballRetrofit
    fun provideFootballRetrofitClient(@FootbalHttpClient okhttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit{
        return Retrofit.Builder()
                .baseUrl("http://www.football-data.org/v1/")
                .client(okhttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache) : OkHttpClient{
        val builder = OkHttpClient.Builder()
                .cache(cache)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(okhttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit{
        return Retrofit.Builder()
                .baseUrl("http://10.0.2.2:4567/")
                .client(okhttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Provides
    @Singleton
    fun provideNamesApi(retrofit: Retrofit): NamesApi {
        return retrofit.create(NamesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsApi(retrofit: Retrofit): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFootballApiService( @FootballRetrofit retrofit : Retrofit) : FootballApi{
        return retrofit.create(FootballApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataService(gsonConverterFactory: GsonConverterFactory) : DataService {

        val okhttpClient = OkHttpClient.Builder()
                .build()


        val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:4567/")
                .client(okhttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()


        return retrofit.create(DataService::class.java)
    }

}
