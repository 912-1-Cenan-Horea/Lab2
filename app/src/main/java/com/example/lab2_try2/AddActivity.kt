package com.example.lab2_try2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        addButton.setOnClickListener {
            val bookTitle = titleEditText.text.toString()
            val bookAuthor = authorEditText.text.toString()
            val bookPrice = priceEditText.text.toString()
            if (bookTitle.isEmpty()) {
                alert("Book title is empty");
            }
            else if (bookAuthor.isEmpty()) {
                alert("Book author is empty");
            }
            else if (bookPrice.isEmpty()) {
                alert("Book price is empty");
            }
            else if(bookPrice.toDoubleOrNull() == null) {
                alert("Book price is not a number");
            }
            else {
                val book = Book(bookAdapter!!.itemCount, bookTitle, bookAuthor, bookPrice.toDouble())
                bookAdapter!!.addBook(book)
                finish()
            }
        }
        exitButton.setOnClickListener {
            finish()
        }
    }

    fun alert(s: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("ERROR")
        builder.setMessage(s)
        builder.setPositiveButton("Ok") { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }
}

