package com.hany.communityapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.hany.communityapp.R
import com.hany.communityapp.contentsList.ContentListActivity
import com.hany.communityapp.databinding.ContentRvItemBinding
import com.hany.communityapp.databinding.FragmentTalkBinding
import com.hany.communityapp.databinding.FragmentTipBinding

class TipFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTipBinding.inflate(inflater, container, false)

        binding.catagory1.setOnClickListener{
            val intent= Intent(context,ContentListActivity::class.java)
            startActivity(intent)
        }
        binding.hometap.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_homeFragment)
        }
        binding.bookmark.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_keepFragment)
        }
        binding.store.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_storeFragment2)
        }
        binding.hometap.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_homeFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}