package com.tikiton.quiz.models


data class Question (
    var id: Int,
    var image: Int,
    var answer: Int,
    var question: String,
    var choices: ArrayList<String>
)