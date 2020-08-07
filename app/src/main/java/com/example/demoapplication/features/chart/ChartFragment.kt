package com.example.demoapplication.features.chart

import android.view.View
import androidx.lifecycle.Observer
import com.example.core.base.fragment.BaseBindingDaggerViewModelFragment
import com.example.core.extenssions.viewModelProvider
import com.example.demoapplication.R
import com.example.demoapplication.databinding.FragmentChartBinding
import com.example.demoapplication.features.ui.bar_chart.HorizontalBarChartManager
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_chart.*

class ChartFragment : BaseBindingDaggerViewModelFragment<FragmentChartBinding>() {
    override fun getRootLayoutId(): Int = R.layout.fragment_chart
    override fun applyBinding(binding: FragmentChartBinding) {
        binding.viewModel = viewModel
    }

    private val viewModel by lazy { viewModelProvider<ChartViewModel>(viewModelFactory) }


    override fun initView(rootView: View) {
        viewModel.init()
        prepareBarChart()
        viewModel.averageRating.observe(this, Observer {
            rating_value.text = it.toString()
        })

    }

    private fun prepareBarChart() {
        val horizontalBarChartManager = HorizontalBarChartManager(bar_chart)
        viewModel.chartLiveData.observe(this, Observer {
            bar_chart.clear()
            bar_chart.clearFocus()
            horizontalBarChartManager.initView()
            val barEntries = ArrayList<BarEntry>()
            val xAxisValues = ArrayList<String?>()
            it.forEach {
                barEntries.addAll(it.keys)
                xAxisValues.addAll(it.values)
            }

            val barColor = context?.resources?.getColor(R.color.bar_color)
            horizontalBarChartManager.setXAxisValues(xAxisValues)
            horizontalBarChartManager.setDataWithColor(barEntries,barColor)
        })
    }
}