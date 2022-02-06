package com.hany.communityapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.hany.communityapp.R
import com.hany.communityapp.databinding.FragmentHomeBinding
import com.hany.communityapp.databinding.FragmentTalkBinding


class TalkFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTalkBinding.inflate(inflater, container, false)
        binding.goodtip.setOnClickListener{
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment2)
        }
        binding.bookmark.setOnClickListener{
            it.findNavController().navigate(R.id.action_talkFragment_to_keepFragment)
        }
        binding.store.setOnClickListener{
            it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }
        binding.hometap.setOnClickListener{
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}