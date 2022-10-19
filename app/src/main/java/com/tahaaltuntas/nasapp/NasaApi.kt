package com.tahaaltuntas.nasapp

import com.tahaaltuntas.nasapp.Constants.API_KEY
import com.tahaaltuntas.nasapp.model.NasaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface NasaApi {
    @GET("rovers/curiosity/photos")

   suspend fun getCuriosity (@Header ("api_key") apiKey : String = API_KEY)
    : Response<NasaModel>


}