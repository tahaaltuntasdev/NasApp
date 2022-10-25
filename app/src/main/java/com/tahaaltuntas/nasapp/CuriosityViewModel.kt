package com.tahaaltuntas.nasapp

import androidx.lifecycle.MutableLiveData
import com.tahaaltuntas.nasapp.data.model.Photo
import com.tahaaltuntas.nasapp.data.remote.NasaApiService


class CuriosityViewModel() : BaseViewModel() {
    private val nasaApiService = NasaApiService()
    val curiosityList = MutableLiveData<ArrayList<Photo>>()

    suspend fun getData() {

        val response = nasaApiService.getCuriosity()
        if (response.isSuccessful) {
            val list = arrayListOf<Photo>()
            response.body()?.let {
                val photos = response.body()!!.photos
                for (photo in photos) {
                    list.add(photo)
                    print(photo)
                }
            }
            curiosityList.value = list

        } else {
            println("Error")
        }

    }
}