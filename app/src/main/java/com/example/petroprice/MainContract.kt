package com.example.petroprice

import com.example.petroprice.gson.citylist.CityList

interface MainContract {

    interface presenter {

        fun onDestroy()

        fun requestDatafromServer()
    }


    interface MainView {

        fun showProgress()

        fun hideProgress()

        fun setDataToRecyclerView(responseCity: CityList?)

        fun onResponseFailure(throwable: Throwable)

    }


    interface getCityInteractor {

        interface onFinishedListener {
            fun onFinished(responseCity: CityList?)

            fun onFailure(t: Throwable)
        }

        fun getCityArraylist(mOnFinishedListener: onFinishedListener)

    }

}