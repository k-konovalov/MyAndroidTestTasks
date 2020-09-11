package com.konovalovk.techno.guessit.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.konovalovk.techno.guessit.MainViewModel
import com.konovalovk.techno.guessit.R

class MainFragment : Fragment(R.layout.main_fragment) {
    private val viewModel: MainViewModel by viewModels()
}
