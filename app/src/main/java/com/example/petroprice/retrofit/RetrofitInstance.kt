package com.example.petroprice.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



open class RetrofitInstance {

    var retrofit :Retrofit? = null
    val baseUrl = "https://dreamsoft-indhan-daily-fuel-price-india-v1.p.mashape.com/v1/"


   open fun getRetrofitInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit as Retrofit
    }

}