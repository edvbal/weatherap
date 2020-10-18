package com.android.weatherapp.entercity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.weatherapp.R
import com.android.weatherapp.databinding.FragmentEnterCityBinding
import com.android.weatherapp.details.WeatherUiData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterCityFragment : Fragment() {

    private var dataBinding: FragmentEnterCityBinding? = null

    private val viewModel by viewModels<EnterCityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.observeShowDetailsEvent().observe(this, ::showDetails)
    }

    private fun showDetails(details: Array<WeatherUiData>) {
        hideKeyboard()
        val action = EnterCityFragmentDirections.actionWeatherDetailsFragment(details)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutId = R.layout.fragment_enter_city
        dataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        dataBinding?.lifecycleOwner = this.viewLifecycleOwner
        return dataBinding?.root
    }

    override fun onDestroyView() {
        dataBinding?.unbind()
        dataBinding?.lifecycleOwner = null
        dataBinding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding?.viewModel = viewModel
    }

    private fun hideKeyboard() {
        activity?.currentFocus?.let { view ->
            context?.let {
                val inputManager =
                    it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(
                    view.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }
        }
    }
}