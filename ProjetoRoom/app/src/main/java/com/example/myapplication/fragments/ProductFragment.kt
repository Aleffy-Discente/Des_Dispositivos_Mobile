package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.AppDatabase
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentProductBinding
import com.example.myapplication.model.Product
import kotlinx.coroutines.launch

class ProdutoFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    private val db by lazy { AppDatabase.getDatabase(requireContext()) }
    private val produtoDao by lazy { db.produtoDao() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductBinding.inflate(inflater, container, false)

        binding.btnSalvarProduto.setOnClickListener {
            salvarProduto()
        }

        listarProdutos()

        return binding.root
    }

    private fun salvarProduto() {
        val nome = binding.etNomeProduto.text.toString()
        val preco = binding.etPrecoProduto.text.toString().toDoubleOrNull() ?: 0.0

        lifecycleScope.launch {
            produtoDao.inserir(Product(nome = nome, preco = preco))
            listarProdutos()
        }
    }

    private fun listarProdutos() {
        lifecycleScope.launch {
            val produtos = produtoDao.listarTodos()
            binding.tvListaProdutos.text =
                produtos.joinToString("\n") { "${it.nome} - R$ ${it.preco}" }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}