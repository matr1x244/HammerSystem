package com.example.hammersystem.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hammersystem.databinding.FragmentDetailFoodBinding
import com.example.hammersystem.domain.model.data.DataFood

class DetailFragment : Fragment() {

    companion object {
        const val ARGS_KEY = "ARGS_KEY"
        fun newInstance(entityFood: DataFood?) = DetailFragment().apply {
            arguments = Bundle()
            arguments?.putParcelable(ARGS_KEY, entityFood)
        }
    }

    private var _binding: FragmentDetailFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailFood()
    }

    private fun detailFood() {
        val about = detailFoodArguments()
//        val behavior = ButtonBehavior(requireContext())

//        Glide.with(binding.avatar)
//            .load(about?.avatar)
//            .into(binding.avatar)

        binding.titleFoodTextview.text = about?.title
    }

    private fun detailFoodArguments(): DataFood? {
        return arguments?.getParcelable(ARGS_KEY)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}