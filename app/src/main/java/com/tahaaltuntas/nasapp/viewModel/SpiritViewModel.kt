package com.tahaaltuntas.nasapp.viewModel

import androidx.lifecycle.MutableLiveData
import com.tahaaltuntas.nasapp.data.model.Photo
import com.tahaaltuntas.nasapp.data.remote.NasaApiService

class SpiritViewModel : BaseViewModel() {
    private val nasaApiService = NasaApiService()
    val spiritList = MutableLiveData<ArrayList<Photo>>()

    suspend fun getSpiritData() {

        val response = nasaApiService.getSpirit()
        if (response.isSuccessful) {
            val list = arrayListOf<Photo>()
            response.body()?.let {
                val photos = response.body()!!.photos
                for (photo in photos) {
                    list.add(photo)
                    print(photo)
                }
            }
            spiritList.value = list

        } else {
            println("Error")
        }

    }
}