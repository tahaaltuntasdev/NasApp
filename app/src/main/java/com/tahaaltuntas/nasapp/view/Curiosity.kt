package com.tahaaltuntas.nasapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.tahaaltuntas.nasapp.CuriosityViewModel
import com.tahaaltuntas.nasapp.adapter.CuriosityAdapter
import com.tahaaltuntas.nasapp.databinding.FragmentCuriosityBinding


class Curiosity : Fragment() {
    val curiosityAdapter = CuriosityAdapter(arrayListOf())
    private var curiosityVM: CuriosityViewModel? = null
    private var _binding: FragmentCuriosityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCuriosityBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        curiosityVM = ViewModelProvider(this)[CuriosityViewModel::class.java]
        lifecycleScope.launchWhenCreated {

            curiosityVM!!.getData()
            binding.rvCuriosity.layoutManager = GridLayoutManager(context, 3)
            binding.rvCuriosity.adapter = curiosityAdapter


        }
        observeLiveData()
    }

    private fun observeLiveData() {
        curiosityVM!!.curiosityList.observe(viewLifecycleOwner, Observer {
            it?.let {
                val photos = it
                for (photo in photos) {
                    curiosityAdapter.photoModelList.add(photo)
                    print(photo)
                }

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}