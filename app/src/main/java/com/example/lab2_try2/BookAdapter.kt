package com.example.lab2_try2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookAdapter(
    private val books: MutableList<Book>
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    class BookViewHolder(itemView: View, bookAdapter: BookAdapter) : RecyclerView.ViewHolder(itemView)
    {
        init {
            itemView.deleteButton.setOnClickListener {
                bookAdapter.deleteBook(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.book_list_item,
                parent,
                false
            ),this
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.itemView.apply {
            bookTitle.text = book.title
            bookAuthor.text = book.author
            bookPrice.text = book.price.toString()

        }
    }

    override fun getItemCount(): Int {
        return books.size
    }

    fun addBook(book: Book) {
        books.add(book)
        notifyItemInserted(books.size - 1)
    }

    fun deleteBook(position: Int) {
        books.removeAt(position)
        notifyItemRemoved(position)
    }

    fun initDummyData() {
        books.apply {
            add(Book(0, "Guardians of the Galaxy", "Brian Michael Bendis", 9.99))
            add(Book(1, "Avengers: Infinity War", "Jim Starlin", 4.99))
            add(Book(2, "Thor: Ragnorok", "Jason Aaron", 14.99))
        }
        notifyDataSetChanged()
    }

}