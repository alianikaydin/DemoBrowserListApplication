package com.example.demoapplication.features.chart

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.core.base.viewmodel.BaseViewModel
import com.example.core.di.scope.ApplicationContext
import com.example.demoapplication.model.Example
import com.github.mikephil.charting.data.BarEntry
import com.google.gson.Gson
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap
import kotlin.collections.component1
import kotlin.collections.component2

class ChartViewModel @Inject constructor(@ApplicationContext var context: Context) :
    BaseViewModel() {

    private val fileName = "apidemo.json"
    val chartLiveData: MutableLiveData<ArrayList<HashMap<BarEntry, String?>>> = MutableLiveData()
    val averageRating: MutableLiveData<Float> = MutableLiveData()

    override fun init() {
        val entries = getBarEntriesFromJson()
        chartLiveData.postValue(entries)
    }

    private fun getBarEntriesFromJson(): ArrayList<HashMap<BarEntry, String?>> {
        val jsonString = context.assets.open(fileName).bufferedReader().use { reader ->
            reader.readText()
        }

        val gson = Gson()
        val example: Example = gson.fromJson(jsonString, Example::class.java)
        val itemList = example.getItems()
        val occurrenceHashMap = HashMap<String?, Int?>()
        itemList?.map { item ->
            val key = item?.getRating().toString()
            if (occurrenceHashMap.containsKey(key)) {
                occurrenceHashMap.put(key, occurrenceHashMap[key]?.plus(1))
            } else {
                occurrenceHashMap.put(key, 1)
            }
        }

        val barEntries: ArrayList<HashMap<BarEntry, String?>> = ArrayList()
        var index = 0
        var totalRating = 0
        var totalPerson = 0
        occurrenceHashMap.forEach { (key, value) ->

            totalRating = totalRating.plus(value!! * key!!.toInt())
            totalPerson += value

            val barData = BarEntry(index.toFloat(), value.toString().toFloat(), key)
            val hashMap = HashMap<BarEntry, String?>()
            hashMap[barData] = key
            barEntries.add(hashMap)
            index++
        }
        if(totalPerson != 0)
            averageRating.postValue(totalRating.toFloat()/totalPerson.toFloat())
        return barEntries
    }
}