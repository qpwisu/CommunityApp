package com.hany.communityapp.contentsList

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hany.communityapp.R
import com.hany.communityapp.databinding.ActivityContentListBinding
import com.hany.communityapp.databinding.ActivityLoginBinding
import com.hany.communityapp.databinding.ContentRvItemBinding
import com.hany.communityapp.utils.FBRef
import java.text.FieldPosition


class ContentListActivity : AppCompatActivity() {
    lateinit var myRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items =ArrayList<ContentModel>()
        val itemKeyList = ArrayList<String>()
        val rvAdapter= ContentRVAdapter(baseContext ,items,itemKeyList)

        val database = Firebase.database("https://communityapp-6183c-default-rtdb.asia-southeast1.firebasedatabase.app/") //realtime db의 서버 위치가 미국이 아니면 뒤에 이거 추

        val category = intent.getStringExtra("category")


        if(category =="category1"){
            myRef = database.getReference("contents")
        }
        else if(category =="category2"){
            myRef = database.getReference("contents2")
        }

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataModel in dataSnapshot.children){
                    val item =dataModel.getValue(ContentModel::class.java)
                    items.add(item!!)
                    itemKeyList.add(dataModel.key.toString())

                }
                rvAdapter.notifyDataSetChanged() //읽어오는게 비동기처리되어 리사이클러뷰는 빈칸으로 나오기때문에 다시 리사이클러뷰를 불러와서 바꿔줘여한다
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ㅇㄴ", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)

        //데이터 읽기

//        //데이터 넣
//        myRef2.push().setValue(ContentModel("title1","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FblYPPY%2Fbtq66v0S4wu%2FRmuhpkXUO4FOcrlOmVG4G1%2Fimg.png","https://philosopher-chan.tistory.com/1237?category=941578"))
//        myRef2.push().setValue(ContentModel("title2","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F123LP%2Fbtq65qy4hAd%2F6dgpC13wgrdsnHigepoVT1%2Fimg.png","https://philosopher-chan.tistory.com/1244?category=941578"))
//        myRef2.push().setValue(ContentModel("title3","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmBh5u%2Fbtq651yYxop%2FX3idRXeJ0VQEoT1d6Hln30%2Fimg.png","https://philosopher-chan.tistory.com/1241?category=941578"))
//        myRef2.push().setValue(ContentModel("title4","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fekn5wI%2Fbtq66UlN4bC%2F8NEzlyot7HT4PcjbdYAINk%2Fimg.png","https://philosopher-chan.tistory.com/1240?category=941578"))

        val rv : RecyclerView = binding.rv

        rv.adapter= rvAdapter
        rv.layoutManager = GridLayoutManager(this,2)

    }
    private fun getBookmarkData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataModel in dataSnapshot.children){


                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ㅇㄴ", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.bookmarkRef.addValueEventListener(postListener)
    }

}