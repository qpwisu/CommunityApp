package com.hany.communityapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hany.communityapp.MainActivity
import com.hany.communityapp.R
import com.hany.communityapp.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIntroBinding.inflate(layoutInflater);
        setContentView(binding.root);
        auth= Firebase.auth

        binding.loginBtn.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }
        binding.joinBtn.setOnClickListener{
            val intent = Intent(this,JoinActivity::class.java)
            startActivity(intent)
        }
        binding.noCountBtn.setOnClickListener {
            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"비회원 로그인", Toast.LENGTH_LONG).show()
                        val intent= Intent(this, MainActivity::class.java)
                        intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"로그인 실패", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}