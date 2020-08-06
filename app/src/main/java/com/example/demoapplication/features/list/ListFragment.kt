package com.example.demoapplication.features.list

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.base.fragment.BaseBindingDaggerViewModelFragment
import com.example.core.extenssions.viewModelProvider
import com.example.demoapplication.R
import com.example.demoapplication.BR
import com.example.demoapplication.databinding.FragmentListBinding
import com.example.demoapplication.databinding.RecyclerviewBrowserItemBinding
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import com.example.demoapplication.features.ui.recyclerview.BrowserItem
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : BaseBindingDaggerViewModelFragment<FragmentListBinding>() {
    override fun getRootLayoutId(): Int = R.layout.fragment_list
    private val viewModel by lazy { viewModelProvider<ListFragmentViewModel>(viewModelFactory) }

    private val typeRegular =
        Type<RecyclerviewBrowserItemBinding>(R.layout.recyclerview_browser_item)

    override fun applyBinding(binding: FragmentListBinding) {
        binding.viewModel = viewModel
    }

    override fun initView(rootView: View) {
        viewModel.init(lifecycle)
        viewModel.itemsLiveData.observe(this, Observer { it ->
            updateRecyclerView(
                it.map {
                    BrowserItem(
                        browser = it?.getBrowser()?.getAppCodeName(),
                        version = it?.getBrowser()?.getAppVersion(),
                        geoLocation = "${it?.getGeo()?.getLat()} , ${it?.getGeo()?.getLon()}",
                        platform = it?.getBrowser()?.getPlatform(),
                        rating = it?.getRating().toString(),
                        labels = it?.getLabels()?.joinToString()
                    )
                }
            )
        })
    }

    private fun updateRecyclerView(items: List<BrowserItem>) {
        recyclerview.layoutManager = LinearLayoutManager(activity)
        LastAdapter(items, BR.browser_item)
            .map<BrowserItem>(typeRegular)
            .into(recyclerview)
    }
}