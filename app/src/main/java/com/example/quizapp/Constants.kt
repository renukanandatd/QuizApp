package com.example.quizapp

object Constants {
    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val que1=Question(
            1,"What country does this flag belong to",
            R.drawable.indiaflag,
            "Argentina","India","Pakistan","China",
            2
        )
        questionList.add(que1)

        val que2=Question(
            1,"What country does this flag belong to",
            R.drawable.srilankaflag,
            "Argentina","India","SriLanka","China",
            3
        )
        questionList.add(que2)

        val que3=Question(
            1,"What country does this flag belong to",
            R.drawable.usaflag,
            "USA","India","Pakistan","China",
            1
        )
        questionList.add(que3)

        val que4=Question(
            1,"What country does this flag belong to",
            R.drawable.maldievesflag,
            "Argentina","India","Pakistan","Maldieves",
            4
        )
        questionList.add(que4)

        val que5=Question(
            1,"What country does this flag belong to",
            R.drawable.russiaflag,
            "Argentina","Russia","Pakistan","China",
            2
        )
        questionList.add(que5)

        return questionList
    }
}