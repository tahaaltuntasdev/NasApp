package com.tahaaltuntas.nasapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.tahaaltuntas.nasapp.adapter.SpiritAdapter
import com.tahaaltuntas.nasapp.databinding.FragmentSpiritBinding
import com.tahaaltuntas.nasapp.viewModel.SpiritViewModel


class SpiritFragment : Fragment() {
    val spiritAdapter = SpiritAdapter(arrayListOf())
    private var spiritVM: SpiritViewModel? = null
    private var _binding: FragmentSpiritBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpiritBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        spiritVM = ViewModelProvider(this)[SpiritViewModel::class.java]
        lifecycleScope.launchWhenCreated {

            spiritVM!!.getSpiritData()
            binding.rvSpirit.layoutManager = GridLayoutManager(context, 3)
            binding.rvSpirit.adapter = spiritAdapter


        }
        observeLiveData()
    }

    private fun observeLiveData() {
        spiritVM!!.spiritList.observe(viewLifecycleOwner, Observer {
            it?.let {
                val photos = it
                for (photo in photos) {
                    spiritAdapter.photoModelListSp.add(photo)
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