package com.example.petroprice

import com.example.petroprice.gson.citylist.CityList

class MainPresenterImpl(var mainView: MainContract.MainView, val getCityInteractor: MainContract.getCityInteractor) : MainContract.presenter, MainContract.getCityInteractor.onFinishedListener {

   /* var mainView: MainContract.MainView? = mainView
    var getCityInteractor: MainContract.getCityInteractor? = getCityInteractor*/


    override fun onDestroy() {

        //mainView =null

    }

    override fun requestDatafromServer() {
        mainView.showProgress()
        getCityInteractor.getCityArraylist(this)
    }

    override fun onFinished(responseCity: CityList?) {
        if(mainView != null){
            mainView.setDataToRecyclerView(responseCity)
            mainView.hideProgress()
        }

    }

    override fun onFailure(t: Throwable) {
        if(mainView != null){
            mainView.onResponseFailure(t)
            mainView.hideProgress();
        }

    }


}