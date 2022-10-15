package com.example.hammersystem.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hammersystem.databinding.FragmentMainBinding
import com.example.hammersystem.domain.ControllerOpenFragment
import com.example.hammersystem.ui.main.recycler.RecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()
    private val controller by lazy { activity as ControllerOpenFragment }

    private val adapter = RecyclerViewAdapter {
        controller.detailOpenFragment(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initIncomingEvents()
    }

    private fun initViews() {
        viewModel.onShowList()
        recyclerView()
    }

    private fun recyclerView() {
        binding.recyclerViewFood.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFood.adapter = adapter
    }

    private fun initIncomingEvents() {
        viewModel.repos.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}