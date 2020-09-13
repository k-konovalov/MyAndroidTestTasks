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
import kotlin.random.Random

class GameFragment : Fragment(R.layout.fragment_game){
    val viewmodel:GameViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfViewPagers = listOf(vpFirstDigit, vpSecondDigit, vpThirdDigit, vpFourthDigit)
        listOfViewPagers.forEach {
            it.adapter = ViewPagerAdapter()
            it.setOnScrollChangeListener { view, i, i2, i3, i4 ->
                viewmodel.checkAnswer(vpFirstDigit.currentItem,vpSecondDigit.currentItem,vpThirdDigit.currentItem,vpFourthDigit.currentItem)
            }
        }

        btnNewValue.setOnClickListener {
            viewmodel.guessInt = Random.nextInt(0, 9999)
        }

        viewmodel.tries.observe(viewLifecycleOwner, Observer {

        })
        viewmodel.gameMsg.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }


}