package com.example.myapplication.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.Product

@Dao
interface ProdutoDao {
    @Insert
    suspend fun inserir(produto: Product)

    @Query("SELECT * FROM produtos")
    suspend fun listarTodos(): List<Product>
}
