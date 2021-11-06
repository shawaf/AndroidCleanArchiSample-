package com.elshawaf.androidcleanarchsample.presentation.authors_posts_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.elshawaf.androidcleanarchsample.R
import com.elshawaf.androidcleanarchsample.databinding.FragAuthorsListBinding
import com.elshawaf.androidcleanarchsample.databinding.FragAuthorsPostsListBinding
import com.elshawaf.androidcleanarchsample.domain.model.AuthorModel
import com.elshawaf.androidcleanarchsample.domain.model.PostModel
import com.elshawaf.androidcleanarchsample.presentation.authors_list.AuthorsListAdapter
import com.elshawaf.androidcleanarchsample.presentation.authors_list.AuthorsListViewModel
import com.elshawaf.androidcleanarchsample.utils.CommonStrings
import com.elshawaf.androidcleanarchsample.utils.CommonUsed
import com.elshawaf.core.util.NetworkHelper
import com.elshawaf.networking.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.frag_authors_list.*
import kotlinx.android.synthetic.main.frag_authors_posts_list.*
import javax.inject.Inject

@AndroidEntryPoint
class AuthorPostsListFramgnet : Fragment(R.layout.frag_authors_posts_list) {

    private var _binding: FragAuthorsPostsListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthorPostsListViewModel by viewModels()
    lateinit var authorPostsListAdapter :PostsListAdapter
    @Inject
    lateinit var networkHelper: NetworkHelper


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragAuthorsPostsListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAuthorsListAdapter()
        arguments?.getString(CommonStrings.authorID)?.let { getAuthorsList(it) }
    }

    private fun getAuthorsList(authorID:String){
        viewModel.getAuthorPostsList(authorID).observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                   onLoading(it.data)
                }
                is Resource.Success -> {
                    onSuccess(it.data)
                }
                is Resource.Error -> {
                    onError(it.error)
                }
            }
        })
    }

    private fun onLoading(data:List<PostModel>?){
        if (!data.isNullOrEmpty()) {
            postsListLoadingPB.visibility=View.GONE
            authorPostsListAdapter.updateCurrentAuthorsList(data)
            CommonUsed.showSnackBar(
                requireActivity(),
                getString(R.string.fetch_from_remote)
            )
        } else postsListLoadingPB.visibility=View.VISIBLE
    }

    private fun onSuccess(data: List<PostModel>?){
        postsListLoadingPB.visibility=View.GONE
        data?.let { it1 -> authorPostsListAdapter.updateCurrentAuthorsList(it1) }
    }

    private fun onError(throwable: Throwable?){
        postsListLoadingPB.visibility=View.GONE
        if(networkHelper.isNetworkConnected()) {
            throwable?.localizedMessage?.let { it1 ->
                CommonUsed.showSnackBar(
                    requireActivity(),
                    it1
                )
            }
        }else CommonUsed.showSnackBar(requireActivity(), getString(R.string.no_internet))
    }

    private fun setupAuthorsListAdapter(){
        authorPostsListAdapter = PostsListAdapter{ item -> openDetailsFragment(item)}
        binding.authorPostsRV.apply {
            adapter= authorPostsListAdapter
        }
    }

    private fun openDetailsFragment(postModel: PostModel){
        var bundle= Bundle().apply { putParcelable(CommonStrings.postModel,postModel) }
        findNavController().navigate(R.id.action_authorPostsListFramgnet_to_postDetailsFragment,bundle)
    }

}