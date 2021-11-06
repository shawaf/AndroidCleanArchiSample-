package com.elshawaf.androidcleanarchsample.presentation.authors_list

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
import com.elshawaf.androidcleanarchsample.domain.model.AuthorModel
import com.elshawaf.androidcleanarchsample.utils.CommonStrings
import com.elshawaf.androidcleanarchsample.utils.CommonUsed
import com.elshawaf.core.util.NetworkHelper
import com.elshawaf.networking.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.android.synthetic.main.frag_authors_list.*
import javax.inject.Inject


@AndroidEntryPoint
class AuthorsListFramgnet : Fragment(R.layout.frag_authors_list){

    private var _binding: FragAuthorsListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthorsListViewModel by viewModels()
    lateinit var authorListAdapter : AuthorsListAdapter

    @Inject
    lateinit var networkHelper: NetworkHelper



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragAuthorsListBinding.inflate(inflater, container, false)
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
        getAuthorsList()
    }

    private fun getAuthorsList(){
            viewModel.authorsList.observe(viewLifecycleOwner, Observer {
                when (it) {
                    is Resource.Loading -> {
                        onLoading(it.data)
                    }
                    is Resource.Success -> {
                      onSuccess(it.data)
                    }
                    is Resource.Error ->{
                        onError(it.error)
                    }
                }
            })
    }

    private fun onLoading(data:List<AuthorModel>?){
        if (!data.isNullOrEmpty()) {
            authorListLoadingPB.visibility=View.GONE
            authorListAdapter.updateCurrentAuthorsList(data)
            CommonUsed.showSnackBar(
                requireActivity(),
                getString(R.string.fetch_from_remote)
            )
        } else authorListLoadingPB.visibility=View.VISIBLE
    }

    private fun onSuccess(data: List<AuthorModel>?){
        authorListLoadingPB.visibility=View.GONE
        data?.let { it1 -> authorListAdapter.updateCurrentAuthorsList(it1) }
    }

    private fun onError(throwable: Throwable?){
        authorListLoadingPB.visibility=View.GONE
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
        authorListAdapter = AuthorsListAdapter{ item -> openAuthorPostsFragment(item)}
        binding.authorListRV.apply {
            adapter= authorListAdapter
        }
    }

    private fun openAuthorPostsFragment(authorModel: AuthorModel){
        var bundle =Bundle().apply {
            putString(CommonStrings.authorID, authorModel.id.toString())
        }
        findNavController().navigate(R.id.action_authorsListFramgnet_to_authorPostsListFramgnet,bundle)
    }

}