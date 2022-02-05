package com.hany.communityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hany.communityapp.auth.IntroActivity
import com.hany.communityapp.databinding.ActivityMainBinding
import com.hany.communityapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= Firebase.auth
        Handler().postDelayed({
            startActivity(Intent(this,IntroActivity::class.java))
            finish()
        },3000)
//        if(auth.currentUser?.uid==null){
//            Handler().postDelayed({
//                startActivity(Intent(this,IntroActivity::class.java))
//                finish()
//            },3000)
//        }
//        else{
//            Handler().postDelayed({
//                startActivity(Intent(this,MainActivity::class.java))
//                finish()
//            },3000)
//        }


    }
}