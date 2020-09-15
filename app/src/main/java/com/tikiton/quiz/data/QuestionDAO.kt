package com.tikiton.quiz.data

import com.tikiton.quiz.R
import com.tikiton.quiz.models.Question

object QuestionDAO {
    fun getQuestions() : ArrayList<Question> {
        val questions = arrayListOf(
            Question(
                0,
                R.drawable.apple,
                1,
                "Quel est le nom de la marque représentée par ce logo?",
                arrayListOf("SAMSUNG", "APPLE", "HUAWE", "SONY")
            ),
            Question(
                1,
                R.drawable.chrome,
                3,
                "Quel est le nom du navigateur internet représentée par ce logo?",
                arrayListOf("OPERA", "FIREFOX", "EXPLORER", "CHROME")
            ),
            Question(
                2,
                R.drawable.firefox,
                0,
                "Quel est le nom du navigateur internet représentée par ce logo?",
                arrayListOf("FIREFOX", "UC BROWSER", "CHROMIUM", "TOR BROWSER")
            ),
            Question(
                3,
                R.drawable.hedgehog,
                2,
                "Quel est le nom de l'animal sur cette image?",
                arrayListOf("PORC", "POISSON", "HERISSON", "ELEPHANT")
            ),
            Question(
                4,
                R.drawable.lamborghini,
                3,
                "Quel est le nom de la marque du véhicule en image?",
                arrayListOf("TOYOTA", "RENAULT", "PORCHE", "LAMGORGHINI")
            ),
            Question(
                5,
                R.drawable.mercedess,
                1,
                "Quel est le nom de la marque du véhicule en image?",
                arrayListOf("FORD", "MERCEDESS", "LAMGORGHINI", "AUDI")
            ),
            Question(
                6,
                R.drawable.mi,
                0,
                "Quel est le nom de la marque représentée par ce logo?",
                arrayListOf("XIAOMI", "PIXEL", "APPLE", "MOTOROLA")
            ),
            Question(
                7,
                R.drawable.rabbit,
                3,
                "Quel est le nom de l'animal sur cette image??",
                arrayListOf("SERPENT", "TIGRE", "SOURIS", "LAPIN")
            )
        )

        questions.shuffle()
        return questions
    }
}