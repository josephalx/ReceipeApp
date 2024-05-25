package com.example.receipeapppractice.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("idCategory")
    val id:String,
    @SerializedName("strCategory")
    val categoryName: String,
    @SerializedName("strCategoryThumb")
    val thumbNail: String,
    @SerializedName("strCategoryDescription")
    val description: String
)
data class  CategoriesList(
    @SerializedName("categories")
    val categoriesList: List<Categories>
)
