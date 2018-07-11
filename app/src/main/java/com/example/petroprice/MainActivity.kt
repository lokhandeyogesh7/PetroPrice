package com.example.petroprice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.petroprice.gson.citylist.City
import com.example.petroprice.gson.citylist.CityList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {

    var presenter: MainContract.presenter? = null
    var recyclerItemClickListener: RecyclerItemClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenterImpl(this, GetCityIntractorImpl())
        presenter!!.requestDatafromServer()

        recyclerItemClickListener = object : RecyclerItemClickListener {
            override fun ontemClick(city: City) {
                Toast.makeText(this@MainActivity, "Clicked ${city.name}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE

    }

    override fun setDataToRecyclerView(responseCity: CityList?) {

        rvCityList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adapter = CityListAdapter(responseCity!!.cities as ArrayList<City>, recyclerItemClickListener!!)
        rvCityList.adapter = adapter

    }

    override fun onResponseFailure(throwable: Throwable) {

    }


}
