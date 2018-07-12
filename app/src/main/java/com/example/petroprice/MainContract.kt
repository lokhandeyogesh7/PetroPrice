package com.example.petroprice

import com.example.petroprice.gson.citylist.CityList

interface MainContract {

    interface presenter {

        fun onDestroy()

        fun requestDatafromServer()

        fun requestDataFromCity(cityId: Int)
    }


    interface MainView {

        fun showProgress()

        fun hideProgress()

        fun setDataToRecyclerView(responseCity: CityList?)

        //fun setDatatoDetails(responseCity: City)

        fun onResponseFailure(throwable: Throwable)

    }


    interface getCityInteractor {

        interface onFinishedListener {
            fun onFinished(url: String?, response: Any?)

            fun onFailure(t: Throwable)
        }

        fun getCityArraylist(mOnFinishedListener: onFinishedListener)

        fun getDataForCity(mOnFinishListener: onFinishedListener)
    }

    interface getDataInteractor {
        interface onFinishedListener {
            fun onFinished(cityId: Int)

            fun onFailure(t: Throwable)
        }



    }

}