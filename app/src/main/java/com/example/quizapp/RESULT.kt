package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RESULT : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView= findViewById(R.id.tvname)
        val tvScore:TextView= findViewById(R.id.tv_score)
        val tvFinish:Button= findViewById(R.id.btn_finish)

        tvName.text=intent.getStringExtra(Constants.USER_NAME)

        val total= intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer= intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.text="Your score is $correctAnswer out of $total"
        tvFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}