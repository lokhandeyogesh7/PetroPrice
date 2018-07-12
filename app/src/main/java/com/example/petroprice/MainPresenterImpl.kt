package com.example.petroprice

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.petroprice.gson.citylist.City
import com.example.petroprice.gson.citylist.CityList
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.StringReader

class MainPresenterImpl(var mainView: MainContract.MainView, val getCityInteractor: MainContract.getCityInteractor) : MainContract.presenter, MainContract.getCityInteractor.onFinishedListener {


    override fun onFinished(url: String?, response: Any?) {

        val gson = Gson()
        val reader = JsonReader(StringReader(response.toString()))
        reader.setLenient(true)

        if (true) {
            when {
                ("city/all" in url!!) -> {
                    mainView.setDataToRecyclerView(Gson().fromJson(reader,CityList::class.java))
                    mainView.hideProgress()
                }
            }

        }
    }

    override fun onDestroy() {
    }

    override fun requestDatafromServer() {
        mainView.showProgress()
        getCityInteractor.getCityArraylist(this)
    }

    override fun requestDataFromCity(cityId: Int) {

    }

    override fun onFailure(t: Throwable) {
        if (true) {
            mainView.onResponseFailure(t)
            mainView.hideProgress()
        }

    }
}