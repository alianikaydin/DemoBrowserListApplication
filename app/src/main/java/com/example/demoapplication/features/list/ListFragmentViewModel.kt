package com.example.demoapplication.features.list

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.base.viewmodel.BaseViewModel
import com.example.core.di.scope.ApplicationContext
import com.example.demoapplication.model.Example
import com.example.demoapplication.model.Item
import com.google.gson.Gson
import org.json.JSONObject
import javax.inject.Inject

class ListFragmentViewModel @Inject constructor(@ApplicationContext var context: Context) :
    BaseViewModel() {

    private val fileName = "apidemo.json"
    val itemsLiveData: MutableLiveData<List<Item?>> = MutableLiveData()


    override fun init() {
    }

    fun init(lifecycle: Lifecycle) {
        val items = getItemsFromJson()
        itemsLiveData.postValue(items)
    }

    private fun getItemsFromJson(): List<Item?>? {
        val jsonString = context.assets.open(fileName).bufferedReader().use { reader ->
            reader.readText()
        }

        val gson = Gson()
        val example: Example = gson.fromJson(jsonString, Example::class.java)
        return example.getItems()
    }


}
