package com.example.receipeapppractice.repository

import com.example.receipeapppractice.model.CategoriesList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

    interface  CategoriesRepository{
        @GET("categories.php")
        suspend fun getCategories():CategoriesList
    }
