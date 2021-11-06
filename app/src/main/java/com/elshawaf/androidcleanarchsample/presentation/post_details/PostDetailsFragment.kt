package com.elshawaf.androidcleanarchsample.presentation.post_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.elshawaf.androidcleanarchsample.R
import com.elshawaf.androidcleanarchsample.databinding.FragPostDetailsBinding
import com.elshawaf.androidcleanarchsample.domain.model.PostModel
import com.elshawaf.androidcleanarchsample.utils.CommonStrings
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostDetailsFragment :Fragment(R.layout.frag_post_details) {


    private var _binding: FragPostDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PostDetailsViewModel by viewModels()
    var postModel:PostModel?=null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragPostDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postModel = arguments?.getParcelable<PostModel>(CommonStrings.postModel)
        binding.post = postModel
    }


}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView?, url: String?) {
    view?.let { Glide
        .with(it.context)
        .load(url).into(it) }
}