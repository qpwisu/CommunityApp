package com.hany.communityapp.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hany.communityapp.R
import com.hany.communityapp.databinding.ActivityContentListBinding
import com.hany.communityapp.databinding.ActivityLoginBinding

class ContentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rv : RecyclerView = binding.rv
        val items =ArrayList<ContentModel>()
        items.add(ContentModel("imageurl1","title1"))
        items.add(ContentModel("imageurl1","title1"))
        items.add(ContentModel("imageurl1","title1"))

        val rvAdapter= ContentRVAdapter(items)
        rv.adapter= rvAdapter
        rv.layoutManager = GridLayoutManager(this,2)
    }
}