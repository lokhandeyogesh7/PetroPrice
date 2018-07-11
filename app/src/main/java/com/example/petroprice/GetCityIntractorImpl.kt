package com.example.petroprice

import android.util.Log
import com.example.petroprice.gson.citylist.CityList
import com.example.petroprice.retrofit.GetDataService
import com.example.petroprice.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetCityIntractorImpl : MainContract.getCityInteractor {


    override fun getCityArraylist(mOnFinishedListener: MainContract.getCityInteractor.onFinishedListener) {

        val service = RetrofitInstance().getRetrofitInstance().create(GetDataService::class.java)

        val call = service.getNoticeData()


        Log.d("URL called >>", call.request().url().toString())

        call.enqueue(object : Callback<CityList> {
            override fun onFailure(call: Call<CityList>?, t: Throwable?) {
                Log.d("onFailure status >> ", t.toString())
                mOnFinishedListener.onFailure(t!!)


            }

            override fun onResponse(call: Call<CityList>?, response: Response<CityList>?) {
                Log.d("success status >> ", response!!.body().toString())
                mOnFinishedListener.onFinished(response.body())

            }

        })

    }

}