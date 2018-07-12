package com.example.petroprice

import android.util.Log
import com.example.petroprice.retrofit.GetDataService
import com.example.petroprice.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetCityIntractorImpl : MainContract.getCityInteractor {

    override fun getDataForCity(mOnFinishListener: MainContract.getCityInteractor.onFinishedListener) {
       /* val service = RetrofitInstance().getRetrofitInstance().create(GetDataService::class.java)

        val call = service.getCityData()

        Log.d("URL called >>", call.request().url().toString())

        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>?, t: Throwable?) {
                Log.d("onFailure status >> ", t.toString())
                mOnFinishListener.onFailure(t!!)
            }

            override fun onResponse(call: Call<Any>?, response: Response<Any>?) {
                Log.d("success status >> ",response!!.body().toString())
                mOnFinishListener.onFinished(call!!.request().url().encodedPath().toString(),response!!.body())
            }
        })*/
    }

    override fun getCityArraylist(mOnFinishedListener: MainContract.getCityInteractor.onFinishedListener) {

        val service = RetrofitInstance().getRetrofitInstance().create(GetDataService::class.java)

        val call = service.getCityList()

        Log.d("URL called >>", call.request().url().toString())

        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>?, t: Throwable?) {
                Log.d("onFailure status >> ", t.toString())
                mOnFinishedListener.onFailure(t!!)
            }

            override fun onResponse(call: Call<Any>?, response: Response<Any>?) {
                Log.d("success status >> ", call!!.request().url().encodedPath())
                mOnFinishedListener.onFinished(call!!.request().url().encodedPath().toString(),response!!.body())
            }
        })
    }
}