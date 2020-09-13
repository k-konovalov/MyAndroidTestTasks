package com.konovalovk.techno.guessit.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.konovalovk.techno.guessit.R
import com.konovalovk.techno.guessit.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment(R.layout.fragment_game){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vpFirstDigit.adapter = ViewPagerAdapter()
        vpFirstDigit.orientation = ViewPager2.ORIENTATION_VERTICAL
        vpSecondDigit.adapter = ViewPagerAdapter()

        vpThirdDigit.adapter = ViewPagerAdapter()
        vpFourthDigit.adapter = ViewPagerAdapter()
    }
}