package com.example.petroprice

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.petroprice.gson.citylist.City
import android.view.LayoutInflater
import android.view.View
import com.example.petroprice.global.RecyclerItemClickListener


class CityListAdapter(val arrayCity: ArrayList<City>, val recyclerItemClickListener: RecyclerItemClickListener, val presenter: MainContract.presenter?) : RecyclerView.Adapter<CityListAdapter.CityHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_city, parent, false)
        return CityHolder(view)
    }


    class CityHolder(view: View?) : RecyclerView.ViewHolder(view) {
        val tvCityName = view!!.findViewById<TextView>(R.id.tvCityName)
    }


    override fun getItemCount(): Int {
        return arrayCity.size
    }


    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.tvCityName.text = arrayCity[position].name

        presenter!!.requestDataFromCity(arrayCity[position].id!!)

        holder.itemView.setOnClickListener {
            recyclerItemClickListener.ontemClick(arrayCity[position])
        }
    }
}