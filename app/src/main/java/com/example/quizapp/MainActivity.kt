package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var start:Button=findViewById(R.id.btnStart)
        var inputText:EditText=findViewById(R.id.et)

        start.setOnClickListener {
            if(inputText.text.isEmpty()){
                Toast.makeText(this,"Enter your name",Toast.LENGTH_LONG).show()
            }else{
                val intent=Intent(this,quizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME,inputText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}