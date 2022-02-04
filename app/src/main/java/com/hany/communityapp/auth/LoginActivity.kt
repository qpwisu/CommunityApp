package com.hany.communityapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TokenWatcher
import android.view.LayoutInflater
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hany.communityapp.MainActivity
import com.hany.communityapp.R
import com.hany.communityapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener {
            val email = binding.loginEmail.text.toString()
            val password = binding.loginPsw.text.toString()
            if(!email.isEmpty() and !password.isEmpty()){
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,"로그인 성공",Toast.LENGTH_LONG).show()
                            val intent= Intent(this,MainActivity::class.java)
                            intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)
                        } else {
                            Toast.makeText(this,"로그인 실패",Toast.LENGTH_LONG).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"이메일과 비밀번호를 입력해주세요",Toast.LENGTH_LONG).show()

            }

        }


    }
}