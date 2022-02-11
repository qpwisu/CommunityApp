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
import com.hany.communityapp.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        binding.joinB.setOnClickListener {
            val email = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()
            val checkP = binding.pCheckText.text.toString()
            var goJoin = true

            if(email.isEmpty()){
                Toast.makeText(this,"이메일을 입력해주세요 ",Toast.LENGTH_LONG).show()
                goJoin = false
            }
            else if(password.isEmpty()){
                Toast.makeText(this,"비밀번호를 입력해주세요 ",Toast.LENGTH_LONG).show()
                goJoin = false
            }
            else if(checkP.isEmpty()){
                Toast.makeText(this,"비밀번호 확인을 입력해주세요 ",Toast.LENGTH_LONG).show()
                goJoin = false
            }
            else if(password.length <6){
                Toast.makeText(this,"비밀번호를 6자 이상 입력 해주세요",Toast.LENGTH_LONG).show()
                goJoin = false
            }
            else if(!checkP.equals(password)){
                Toast.makeText(this,"비밀번호가 다릅니다",Toast.LENGTH_LONG).show()
                goJoin = false
            }

            if (goJoin){
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,"가입 완료 ",Toast.LENGTH_LONG).show()
                            val intent = Intent(this,MainActivity::class.java)
                            intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)
                            //화면이 전환되어서 뒤로 돌아갈때 이 페이지로 돌아가지 않게 한다
                        } else {
                            Toast.makeText(this,"가입 실패 ",Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}