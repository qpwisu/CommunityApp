package com.hany.communityapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.hany.communityapp.R
import com.hany.communityapp.databinding.FragmentHomeBinding
import com.hany.communityapp.databinding.FragmentStoreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoreFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStoreBinding.inflate(inflater, container, false)
        binding.goodtip.setOnClickListener{
            it.findNavController().navigate(R.id.action_storeFragment_to_tipFragment)
        }
        binding.bookmark.setOnClickListener{
            it.findNavController().navigate(R.id.action_storeFragment_to_keepFragment)
        }
        binding.hometap.setOnClickListener{
            it.findNavController().navigate(R.id.action_storeFragment_to_homeFragment)
        }
        binding.talk.setOnClickListener{
            it.findNavController().navigate(R.id.action_storeFragment_to_talkFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}