package com.example.mvvm_koin_kotlin.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_koin_kotlin.R
import com.example.mvvm_koin_kotlin.mvvm.MainViewModel
import com.example.mvvm_koin_kotlin.room.DataModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_user.*
import kotlinx.android.synthetic.main.add_user.cancelBtnID
import kotlinx.android.synthetic.main.update_user.*
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), DataAdatptar.OnItemClickListener,
    CoroutineScope by MainScope() {
    private val mainViewModel: MainViewModel by viewModel()
    private var dataAdatptar = DataAdatptar()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewID.adapter = dataAdatptar
        recyclerViewID.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
            )
        )
        recyclerViewID.setHasFixedSize(true)
        mainViewModel.getAllUser().observe(this, Observer {
            dataAdatptar.addUserList(it)
        })

        networkBtnID.setOnClickListener {
            val intent = Intent(this, NetworkActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (R.id.addItem == item.itemId) {
            showDailogBox()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDailogBox() {
        val viewLayout = LayoutInflater.from(this).inflate(R.layout.add_user, null)
        val deleteDialog: AlertDialog = AlertDialog.Builder(this).create()
        deleteDialog.setView(viewLayout)
        deleteDialog.show()
        deleteDialog.addUserBtnID.setOnClickListener {
            val name = deleteDialog.enterNameID.text.toString().trim()
            val designation = deleteDialog.enterDesignationID.text.toString().trim()
            if (name.isNotEmpty() && designation.isNotEmpty()) {
                launch(Dispatchers.IO) {
                    mainViewModel.addUser(
                        DataModel(
                            0,
                            userName = name,
                            userDesignation = designation
                        )
                    )
                }
                deleteDialog.dismiss()
            } else {
                Toast.makeText(this, "Please enter both field", Toast.LENGTH_SHORT).show()
            }
        }
        deleteDialog.cancelBtnID.setOnClickListener {
            deleteDialog.dismiss()
        }
    }


    private fun updateUser(position: Int) {
        val viewLayout = LayoutInflater.from(this).inflate(R.layout.update_user, null)
        val deleteDialog: AlertDialog = AlertDialog.Builder(this).create()
        deleteDialog.setView(viewLayout)
        deleteDialog.show()
        deleteDialog.updateUserBtnID.setOnClickListener {
            val name = deleteDialog.updateNameID.text.toString().trim()
            val designation = deleteDialog.updateDesignationID.text.toString().trim()
            launch(Dispatchers.IO) {
                mainViewModel.updateUser(
                    id = dataAdatptar.dataList[position].userID,
                    updateName = name,
                    updateDesignation = designation
                )
            }
            deleteDialog.dismiss()
        }
        deleteDialog.cancelBtnID.setOnClickListener {
            deleteDialog.show()
        }


    }

    private fun deleteUser(position: Int) {
        launch(Dispatchers.IO) {
            mainViewModel.deleteUser(
                DataModel(
                    userID = dataAdatptar.dataList[position].userID,
                    userName = dataAdatptar.dataList[position].userName,
                    userDesignation = dataAdatptar.dataList[position].userDesignation
                )
            )
        }

    }

    override fun itemClick(view: View, position: Int) {
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.drop_down_menu, popupMenu.menu)
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.updateID -> updateUser(position)
                R.id.deleteID -> deleteUser(position)
                else -> false
            }
            true
        }


    }

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }

}