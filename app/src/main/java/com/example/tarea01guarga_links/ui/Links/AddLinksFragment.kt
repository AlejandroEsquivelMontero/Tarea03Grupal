package com.example.tarea01guarga_links.ui.Links

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tarea01guarga_links.R
import com.example.tarea01guarga_links.databinding.FragmentAddMascotasBinding
import com.example.tarea01guarga_links.databinding.FragmentMascotasBinding
import com.example.tarea01guarga_links.model.Links
import com.example.tarea01guarga_links.ui.viewmodel.LinksViewModel

class AddLinksFragment : Fragment() {

    private lateinit var linksViewModel: LinksViewModel
    private var _binding: FragmentAddMascotasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        linksViewModel = ViewModelProvider(this)[LinksViewModel::class.java]
        _binding = FragmentAddMascotasBinding.inflate(inflater, container, false)

        binding.btAgregar.setOnClickListener {
            insertarLink()
        }

        return binding.root
        }

    private fun insertarLink() {
        val nombre = binding.etNombre.text.toString()
        val url = binding.etURL.text.toString()
        val link = Links(0,nombre,url,"")
        linksViewModel.addLinks(link)
        Toast.makeText(requireContext(),getString(R.string.msg_agregar),Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addLinksFragment_to_nav_link)
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}