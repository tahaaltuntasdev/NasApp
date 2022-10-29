package com.tahaaltuntas.nasapp.data.remote

import com.tahaaltuntas.nasapp.util.Constants.BASE_URL
import com.tahaaltuntas.nasapp.data.model.NasaModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NasaApiService {
    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
    }.build()

    private val nasaApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(NasaApi::class.java)

    suspend fun getCuriosity(): Response<NasaModel> {
        return nasaApi.getCuriosity()
    }
    suspend fun getOpportunity(): Response<NasaModel> {
        return nasaApi.getOpportunity()
    }
    suspend fun getSpirit(): Response<NasaModel> {
        return nasaApi.getSpirit()
    }

}