package com.tahaaltuntas.nasapp

import com.google.gson.Gson
import com.tahaaltuntas.nasapp.Constants.BASE_URL
import com.tahaaltuntas.nasapp.model.NasaModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NasaApiService {
    private val nasaApi = Retrofit.Builder ()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NasaApi::class.java)

   suspend fun getCuriosity() : Response<NasaModel>{
        return nasaApi.getCuriosity()
    }
}