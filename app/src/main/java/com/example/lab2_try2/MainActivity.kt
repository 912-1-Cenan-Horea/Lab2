package com.example.lab2_try2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.book_list_item.*

var bookAdapter: BookAdapter? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bookAdapter = BookAdapter(mutableListOf())
        recyclerView.adapter = bookAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        bookAdapter!!.initDummyData()
        addBookButton.setOnClickListener {
            // fire a new activity
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
    }


}
