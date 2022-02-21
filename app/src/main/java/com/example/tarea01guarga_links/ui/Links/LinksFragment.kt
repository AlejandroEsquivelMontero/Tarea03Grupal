package com.example.tarea01guarga_links.ui.Links

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea01guarga_links.R
import com.example.tarea01guarga_links.adapter.LinksAdapter
import com.example.tarea01guarga_links.databinding.FragmentLinksBinding
import com.example.tarea01guarga_links.model.Links
import com.example.tarea01guarga_links.ui.viewmodel.LinksViewModel

class LinksFragment : Fragment() {

    private lateinit var linksViewModel: LinksViewModel
    private var _binding: FragmentLinksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        linksViewModel = ViewModelProvider(this)[LinksViewModel::class.java]

        _binding = FragmentLinksBinding.inflate(inflater, container, false)

        binding.btAgregarLinks.setOnClickListener{
            findNavController().navigate(R.id.action_nav_link_to_addLinksFragment)
        }

        //activar reciclador
        val linckAdapter=LinksAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = linckAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        linksViewModel = ViewModelProvider(this)[LinksViewModel::class.java]

        linksViewModel.getAllData.observe(viewLifecycleOwner) { link -> linckAdapter.setData(link)}

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}