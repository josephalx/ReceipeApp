package com.example.receipeapppractice.service

import com.example.receipeapppractice.repository.CategoriesRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit = Retrofit
    .Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val CategoriesService: CategoriesRepository = retrofit.create(CategoriesRepository::class.java)