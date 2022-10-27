package com.tahaaltuntas.nasapp.data.remote

import com.tahaaltuntas.nasapp.util.Constants.API_KEY
import com.tahaaltuntas.nasapp.data.model.NasaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("rovers/curiosity/photos?sol=1000")
    suspend fun getCuriosity(
        @Query("api_key") api_key: String = API_KEY
    ): Response<NasaModel>

    @GET("rovers/opportunity/photos?sol=1000")
    suspend fun getOpportunity(
        @Query("api_key") api_key: String = API_KEY
    ): Response<NasaModel>

}