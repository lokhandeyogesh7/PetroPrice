package com.example.petroprice.global

import com.example.petroprice.gson.citylist.City

interface RecyclerItemClickListener {
    fun ontemClick(city: City)
}