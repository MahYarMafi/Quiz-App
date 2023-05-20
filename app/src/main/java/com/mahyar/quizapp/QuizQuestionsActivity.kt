package com.mahyar.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    private var progressBar: ProgressBar? = null
    private var txtProgress: TextView? = null
    private var txtQuestion: TextView? = null
    private var imgCountry: ImageView? = null
    private var txtOptionOne: TextView? = null
    private var txtOptionTwo: TextView? = null
    private var txtOptionThree: TextView? = null
    private var txtOptionFour: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        txtProgress = findViewById(R.id.txtProgress)
        txtQuestion = findViewById(R.id.txtQuestion)
        imgCountry = findViewById(R.id.imgCountry)
        txtOptionOne = findViewById(R.id.txtOptionOne)
        txtOptionTwo = findViewById(R.id.txtOptionTwo)
        txtOptionThree = findViewById(R.id.txtOptionThree)
        txtOptionFour = findViewById(R.id.txtOptionFour)


        val questionList = Constants.getQuestions()
        Log.i("test", "Question list size is ${questionList.size}")

        for (i in questionList) {
            Log.i("questions", i.question)
        }
        var currentPosition = 1
        val question: Question = questionList[currentPosition - 1]
        imgCountry?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        txtProgress?.text = "$currentPosition / ${progressBar?.max}"
        txtQuestion?.text = question.question
        txtOptionOne?.text = question.optionOne
        txtOptionTwo?.text = question.optionTwo
        txtOptionThree?.text = question.optionThree
        txtOptionFour?.text = question.optionFour

    }
}