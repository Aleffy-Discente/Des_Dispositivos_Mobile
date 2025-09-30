package com.example.myapplication.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.User

@Dao
interface UsuarioDao {
    @Insert
    suspend fun inserir(usuario: User)

    @Query("SELECT * FROM usuarios")
    suspend fun listarTodos(): List<User>
}
