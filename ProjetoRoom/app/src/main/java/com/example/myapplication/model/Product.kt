package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val preco: Double
)
