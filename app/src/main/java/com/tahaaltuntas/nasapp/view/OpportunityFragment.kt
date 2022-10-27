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
import com.tahaaltuntas.nasapp.adapter.OpportunityAdapter
import com.tahaaltuntas.nasapp.databinding.FragmentOpportunityBinding

import com.tahaaltuntas.nasapp.viewModel.OpportunityViewModel


class OpportunityFragment : Fragment() {
    val opportunityAdapter = OpportunityAdapter(arrayListOf())
    private var opportunityVM: OpportunityViewModel? = null
    private var _binding : FragmentOpportunityBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOpportunityBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        opportunityVM = ViewModelProvider(this)[OpportunityViewModel::class.java]
        lifecycleScope.launchWhenCreated {

            opportunityVM!!.getOpportunityData()
            binding.rvOpportunity.layoutManager = GridLayoutManager(context, 3)
            binding.rvOpportunity.adapter = opportunityAdapter


        }
        observeLiveData()
    }
    private fun observeLiveData() {
        opportunityVM!!.opportunityList.observe(viewLifecycleOwner, Observer {
            it?.let {
                val photos = it
                for (photo in photos) {
                    opportunityAdapter.photoModelListOp.add(photo)
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