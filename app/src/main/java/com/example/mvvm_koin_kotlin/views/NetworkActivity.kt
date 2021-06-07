package com.example.mvvm_koin_kotlin.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_koin_kotlin.mvvm.MainViewModel
import com.example.mvvm_koin_kotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_network.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class NetworkActivity : AppCompatActivity(),NetworkAdapter.OnItemClickListener,CoroutineScope by MainScope(){
    private val mainViewModel: MainViewModel by viewModel()
    private var newtworkAdapter = NetworkAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        networkRVID.adapter = newtworkAdapter
        networkRVID.addItemDecoration(
            DividerItemDecoration(
                this@NetworkActivity,
                LinearLayoutManager.VERTICAL
            )
        )
        networkRVID.setHasFixedSize(true)
        newtworkAdapter.addUserList(mainViewModel.getAllPost())
    }

    override fun itemClick(view: View, position: Int) {

    }
}