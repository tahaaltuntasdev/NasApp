package com.tahaaltuntas.nasapp.viewModel

import androidx.lifecycle.MutableLiveData
import com.tahaaltuntas.nasapp.data.model.Photo
import com.tahaaltuntas.nasapp.data.remote.NasaApiService

class OpportunityViewModel() : BaseViewModel() {
    private val nasaApiService = NasaApiService()
    val opportunityList = MutableLiveData<ArrayList<Photo>>()

    suspend fun getOpportunityData() {

        val response = nasaApiService.getOpportunity()
        if (response.isSuccessful) {
            val list = arrayListOf<Photo>()
            response.body()?.let {
                val photos = response.body()!!.photos
                for (photo in photos) {
                    list.add(photo)
                    print(photo)
                }
            }
            opportunityList.value = list

        } else {
            println("Error")
        }

    }
}