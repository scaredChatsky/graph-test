package com.buchatskij.graphtest.main.data

import com.buchatskij.graphtest.response.Response
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PointsApi {

    @FormUrlEncoded
    @POST("pointsList")
    fun getPoints(@Field("count") count: Int): Single<Response<PointsResponse>>
}