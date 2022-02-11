package com.hany.communityapp.contentsList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hany.communityapp.R
import com.hany.communityapp.utils.FBAuth
import com.hany.communityapp.utils.FBRef

class ContentRVAdapter(val context: Context, val items:ArrayList<ContentModel>, val keyList:ArrayList<String>): RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item,parent,false)
        return Viewholder((v))
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {

        holder.bindItems(items[position],keyList[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bindItems(item:ContentModel,key:String){
            itemView.setOnClickListener {
                val intent = Intent(context,ContentShowActivity::class.java)
                intent.putExtra("url",item.webUrl)
                itemView.context.startActivity(intent)
            }

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

            bookmarkArea.setOnClickListener {
                FBRef.bookmarkRef.child(FBAuth.getUid()).child(key).setValue("good")
            }

            contentTitle.text= item.title

            //glide를 통 웹에서 이미지 가져오는
            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)
        }
    }
}