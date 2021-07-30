package com.example.superhero.retrofit

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private val  BASE_URL = "https://www.reddit.com/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("r/php/search.json?q=oop&limit=5")            //INDICA A RETROFIT QUE ES UNA SOLICITUD GET
    suspend fun getItems():String
}

object Api{
    val retrofitService:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
    }
