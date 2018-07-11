package com.example.petroprice.retrofit

import com.example.petroprice.gson.citylist.CityList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GetDataService {

   @Headers("X-Mashape-Key:uA0OsrCFH0mshnRprl3Wrn6NaKSVp1VbfQ7jsn7YxJyCuygzTG"
   ,"Accept:application/json")
    @GET("city/all")
    fun getNoticeData(): Call<CityList>
}