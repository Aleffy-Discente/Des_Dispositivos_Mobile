package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.AppDatabase
import com.example.myapplication.databinding.FragmentUserBinding
import com.example.myapplication.model.User
import kotlinx.coroutines.launch

class UsuarioFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val db by lazy { AppDatabase.getDatabase(requireContext()) }
    private val usuarioDao by lazy { db.usuarioDao() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)

        binding.btnSalvarUsuario.setOnClickListener {
            salvarUsuario()
        }

        listarUsuarios()

        return binding.root
    }

    private fun salvarUsuario() {
        val nome = binding.etNomeUsuario.text.toString()
        val email = binding.etEmailUsuario.text.toString()

        lifecycleScope.launch {
            usuarioDao.inserir(User(nome = nome, email = email))
            listarUsuarios()
        }
    }

    private fun listarUsuarios() {
        lifecycleScope.launch {
            val usuarios = usuarioDao.listarTodos()
            binding.tvListaUsuarios.text =
                usuarios.joinToString("\n") { "${it.nome} - ${it.email}" }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
