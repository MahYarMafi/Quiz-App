package com.mahyar.quizapp

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
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var progressBar: ProgressBar? = null
    private var txtProgress: TextView? = null
    private var txtQuestion: TextView? = null
    private var imgCountry: ImageView? = null
    private var txtOptionOne: TextView? = null
    private var txtOptionTwo: TextView? = null
    private var txtOptionThree: TextView? = null
    private var txtOptionFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        txtProgress = findViewById(R.id.txtProgress)
        txtQuestion = findViewById(R.id.txtQuestion)
        imgCountry = findViewById(R.id.imgCountry)
        txtOptionOne = findViewById(R.id.txtOptionOne)
        txtOptionOne?.setOnClickListener(this)

        txtOptionTwo = findViewById(R.id.txtOptionTwo)
        txtOptionTwo?.setOnClickListener(this)

        txtOptionThree = findViewById(R.id.txtOptionThree)
        txtOptionThree?.setOnClickListener(this)

        txtOptionFour = findViewById(R.id.txtOptionFour)
        txtOptionFour?.setOnClickListener(this)

        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestion()
        defaultOptionsView()
    }

    private fun setQuestion() {

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        imgCountry?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        txtProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        txtQuestion?.text = question.question
        txtOptionOne?.text = question.optionOne
        txtOptionTwo?.text = question.optionTwo
        txtOptionThree?.text = question.optionThree
        txtOptionFour?.text = question.optionFour

        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        txtOptionOne?.let {
            options.add(0, it)
        }
        txtOptionTwo?.let {
            options.add(1, it)
        }
        txtOptionThree?.let {
            options.add(2, it)
        }
        txtOptionFour?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.txtOptionOne -> {
                txtOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.txtOptionTwo -> {
                txtOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.txtOptionThree -> {
                txtOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.txtOptionFour -> {
                txtOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit ->{

            }
        }
    }
}