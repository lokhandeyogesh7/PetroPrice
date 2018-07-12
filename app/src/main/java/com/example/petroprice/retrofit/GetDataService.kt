package com.example.petroprice.retrofit

import com.example.petroprice.gson.citylist.CityList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface GetDataService {

    @Headers("X-Mashape-Key:uA0OsrCFH0mshnRprl3Wrn6NaKSVp1VbfQ7jsn7YxJyCuygzTG"
            , "Accept:application/json")
    @GET("city/all")
    fun getCityList(): Call<Any>


    @Headers("X-Mashape-Key:uA0OsrCFH0mshnRprl3Wrn6NaKSVp1VbfQ7jsn7YxJyCuygzTG"
            , "Accept:application/json")
    @GET("fuel/city/{id}")
    fun getCityData(@Path("id") cityId: Int): Call<Any>
}
