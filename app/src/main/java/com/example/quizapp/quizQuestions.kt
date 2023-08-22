package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class quizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestion:ArrayList<Question>?=null
    private var mSelectedOption:Int=0
    private var mUserName:String?=null
    private var progressBar: ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvquestion:TextView?=null
    private var image:ImageView?=null
    private var option1:TextView?=null
    private var option2:TextView?=null
    private var option3:TextView?=null
    private var option4:TextView?=null
    private var btnSelect:Button?=null
    private var mCorrectAnswers:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.textprogress)
        image=findViewById(R.id.image)
        tvquestion=findViewById(R.id.question)
        option1=findViewById(R.id.optionOne)
        option2=findViewById(R.id.optionTwo)
        option3=findViewById(R.id.optionThree)
        option4=findViewById(R.id.optionFour)
        btnSelect=findViewById(R.id.submitButton)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btnSelect?.setOnClickListener(this)

        mQuestion = Constants.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestion!![mCurrentPosition - 1]
        image?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "${mCurrentPosition} / ${progressBar?.max}"
        tvquestion?.text = question.question
        option1?.text = question.optionOne
        option2?.text = question.optionTwo
        option3?.text = question.optionThree
        option4?.text = question.optionFour

        if(mCurrentPosition==mQuestion!!.size){
            btnSelect?.text="FINISH"
        }else{
            btnSelect?.text="SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        option1?.let{
            options.add(0,it)
        }
        option2?.let{
            options.add(1,it)
        }
        option3?.let{
            options.add(2,it)
        }
        option4?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()

        mSelectedOption=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.select_option_bg
        )
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne ->{
                option1?.let{
                    selectedOptionView(it,1)
                }
            }

            R.id.optionTwo ->{
                option2?.let{
                    selectedOptionView(it,2)
                }
            }

            R.id.optionThree ->{
                option3?.let{
                    selectedOptionView(it,3)
                }
            }

            R.id.optionFour ->{
                option4?.let{
                    selectedOptionView(it,4)
                }
            }

            R.id.submitButton ->{
                if(mSelectedOption==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestion!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            val intent=Intent(this,RESULT::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestion?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question=mQuestion?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOption){
                        answerView(mSelectedOption,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mQuestion!!.size){
                        btnSelect?.text="FINISH"
                    }else{
                        btnSelect?.text="NEXT"
                    }
                    mSelectedOption=0
                }
            }
        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                option1?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                option2?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                option3?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                option4?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

        }
    }
}