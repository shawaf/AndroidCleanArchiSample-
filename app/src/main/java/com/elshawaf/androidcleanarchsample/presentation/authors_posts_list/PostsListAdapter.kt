package com.elshawaf.androidcleanarchsample.presentation.authors_posts_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elshawaf.androidcleanarchsample.databinding.ItemPostBinding
import com.elshawaf.androidcleanarchsample.domain.model.PostModel

class PostsListAdapter(
    var itemClick: (PostModel) -> Unit
) : RecyclerView.Adapter<PostsListAdapter.PostsViewHolder>() {
    private var postsList = emptyList<PostModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {

        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {

        holder.bind(postsList[position], itemClick)

    }

    override fun getItemCount() = postsList.size

    class PostsViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(postModel: PostModel, itemClick: (PostModel) -> Unit) {
            binding.post = postModel
            binding.root.setOnClickListener {
                itemClick(postModel)
            }


        }
    }

    fun updateCurrentAuthorsList(current: List<PostModel>) {
        this.postsList = current

        notifyDataSetChanged()
    }
}
