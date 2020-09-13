package com.konovalovk.techno.guessit.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.konovalovk.techno.guessit.R
import com.konovalovk.techno.guessit.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment(R.layout.fragment_game){
    private val viewmodel: GameViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfViewPagers = listOf(vpFirstDigit, vpSecondDigit, vpThirdDigit, vpFourthDigit)
        listOfViewPagers.forEach {
            it.adapter = ViewPagerAdapter()
        }

        btnNewValue.setOnClickListener { viewmodel.resetCurrentGuessValue() }

        viewmodel.attempts.observe(viewLifecycleOwner, Observer { txtAttemptsCount.text = it.toString() })
        viewmodel.gameMsg.observe(viewLifecycleOwner, Observer { if(it.isNotEmpty()) Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show() })
        btnGuess.setOnClickListener {
            viewmodel.checkAnswer(vpFirstDigit.currentItem,vpSecondDigit.currentItem,vpThirdDigit.currentItem,vpFourthDigit.currentItem)
        }
    }
}