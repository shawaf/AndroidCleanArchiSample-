package com.elshawaf.androidcleanarchsample.presentation.authors_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elshawaf.androidcleanarchsample.databinding.ItemAuthorBinding
import com.elshawaf.androidcleanarchsample.domain.model.AuthorModel

class AuthorsListAdapter(
    var itemClick: (AuthorModel) -> Unit
) : RecyclerView.Adapter<AuthorsListAdapter.AuthorsViewHolder>() {
    private var authorsList = emptyList<AuthorModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorsViewHolder {

        val binding = ItemAuthorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AuthorsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthorsViewHolder, position: Int) {

        holder.bind(authorsList[position], itemClick)

    }

    override fun getItemCount() = authorsList.size

    class AuthorsViewHolder(private val binding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(authorModel: AuthorModel, itemClick: (AuthorModel) -> Unit) {
            binding.author = authorModel
            binding.root.setOnClickListener {
                itemClick(authorModel)

            }


        }
    }

    fun updateCurrentAuthorsList(current: List<AuthorModel>) {
        this.authorsList = current

        notifyDataSetChanged()
    }
}
