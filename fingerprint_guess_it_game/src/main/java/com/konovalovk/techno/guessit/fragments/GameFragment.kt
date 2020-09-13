package com.konovalovk.techno.guessit.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.konovalovk.techno.guessit.R
import com.konovalovk.techno.guessit.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random

class GameFragment : Fragment(R.layout.fragment_game){
    var guessInt = Random.nextInt(0, 9999)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfViewPagers = listOf(vpFirstDigit, vpSecondDigit, vpThirdDigit, vpFourthDigit)
        listOfViewPagers.forEach {
            it.adapter = ViewPagerAdapter()
            it.setOnScrollChangeListener { view, i, i2, i3, i4 ->
                checkAnswer()
            }
        }

        btnNewValue.setOnClickListener {
            guessInt = Random.nextInt(0, 9999)
        }
    }

    private fun checkAnswer(){
        val userAnswer = "${vpFirstDigit.currentItem}${vpSecondDigit.currentItem}${vpThirdDigit.currentItem}${vpFourthDigit.currentItem}".toInt()
        var msg = "Answer is "
        msg += when {
            userAnswer > guessInt -> "greater than stored value"
            userAnswer < guessInt -> "less than stored value"
            else -> "you're right!"
        }

        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}