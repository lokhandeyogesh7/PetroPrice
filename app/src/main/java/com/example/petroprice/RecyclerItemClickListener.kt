package com.example.petroprice

import com.example.petroprice.gson.citylist.City

interface RecyclerItemClickListener {

    fun ontemClick(city: City)
}