package com.example.demoapplication.features.ui.bar_chart

import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


class HorizontalBarChartManager (private val mChart: HorizontalBarChart) {
    fun initView() {
        mChart.setDrawBarShadow(false)
        mChart.setDrawValueAboveBar(true)
        mChart.description.isEnabled = false
        mChart.setPinchZoom(false)
        mChart.setDrawGridBackground(false)
        mChart.legend.isEnabled = false
        mChart.description.isEnabled = false
        mChart.setScaleEnabled(false)

        val xl: XAxis = mChart.xAxis
        xl.position = XAxis.XAxisPosition.BOTTOM
        xl.setDrawAxisLine(false)
        xl.setDrawGridLines(false)

        val yl: YAxis = mChart.axisLeft
        yl.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
        yl.setDrawGridLines(false)
        yl.setDrawAxisLine(false)
        yl.setDrawZeroLine(false)
        yl.setDrawLabels(false)
        yl.isEnabled = false
        yl.axisMinimum = 0f

        val yr: YAxis = mChart.axisRight
        yr.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
        yr.setDrawGridLines(false)
        yr.setDrawAxisLine(false)
        yr.setDrawZeroLine(false)
        yr.setDrawLabels(false)
        yr.axisMinimum = 0f

    }

    fun setDataWithColor(
        barEntries: List<BarEntry?>?,
        barColor: Int?
    ) {
        val barDataSet = BarDataSet(barEntries, "")
        barDataSet.valueFormatter = DefaultValueFormatter(0)
        barDataSet.valueTextSize = 10F
        barDataSet.color = barColor!!
        barDataSet.isHighlightEnabled = false
        val data = BarData(barDataSet)
        data.barWidth = 0.4F
        mChart.data = data
    }


    fun setXAxisValues(values: List<String?>?) {
        val xAxis = mChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(values)
        xAxis.granularity = 1F
    }

}
