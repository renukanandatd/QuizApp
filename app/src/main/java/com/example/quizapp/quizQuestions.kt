package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class quizQuestions : AppCompatActivity() {
    private var progressBar: ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvquestion:TextView?=null
    private var image:ImageView?=null
    private var option1:TextView?=null
    private var option2:TextView?=null
    private var option3:TextView?=null
    private var option4:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.textprogress)
        image=findViewById(R.id.image)
        tvquestion=findViewById(R.id.question)
        option1=findViewById(R.id.optionOne)
        option2=findViewById(R.id.optionTwo)
        option3=findViewById(R.id.optionThree)
        option4=findViewById(R.id.optionFour)

        val questionsList=Constants.getQuestions()
        for(i in questionsList){
            Log.e("Questions",i.question)
        }
        var currentPosition=1
        val question:Question=questionsList[currentPosition-1]
        image?.setImageResource(question.image)
        progressBar?.progress=currentPosition
        tvProgress?.text="${currentPosition} / ${progressBar?.max}"
        tvquestion?.text = question.question
        option1?.text=question.optionOne
        option2?.text=question.optionTwo
        option3?.text=question.optionThree
        option4?.text=question.optionFour
    }
}