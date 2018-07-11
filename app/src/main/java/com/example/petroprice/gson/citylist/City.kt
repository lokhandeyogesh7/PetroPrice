package com.example.petroprice.gson.citylist

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class City {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("state_id")
    @Expose
    var stateId: Int? = null

}
