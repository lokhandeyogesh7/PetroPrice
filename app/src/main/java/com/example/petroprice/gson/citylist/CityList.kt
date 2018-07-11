package com.example.petroprice.gson.citylist

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CityList {

    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("cities")
    @Expose
    var cities: List<City>? = null

}
