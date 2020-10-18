package com.android.weatherapp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.weatherapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_weather_details.*
import javax.inject.Inject

@AndroidEntryPoint
class WeatherDetailsFragment : Fragment() {

    private val arguments: WeatherDetailsFragmentArgs by navArgs()

    @Inject
    lateinit var adapter: WeatherDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_weather_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
        backImageView.setOnClickListener { findNavController().navigateUp() }
    }

    private fun setRecycler() {
        recyclerView.adapter = adapter
        adapter.setItems(arguments.details.toList())
    }
}