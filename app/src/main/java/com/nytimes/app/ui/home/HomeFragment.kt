package com.nytimes.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nytimes.app.data.remote.model.ResponseArticles
import com.nytimes.app.databinding.FragmentHomeBinding
import com.nytimes.app.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var homeAdapter: HomeAdapter
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var _binding: FragmentHomeBinding

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupObserver()
        return root
    }

    private fun renderList(response: ResponseArticles) {
        _binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            /*addItemDecoration(
                DividerItemDecoration(
                    _binding.recyclerView.context,
                    (_binding.recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )*/
            homeAdapter.updateData(response)
            this.adapter = homeAdapter
        }
    }

    private fun setupObserver() {
        activity?.let { it ->
            homeViewModel.getMostPopularArticles().observe(it) {
                when (it.status) {
                    Status.SUCCESS -> {
                        _binding.progressBar.visibility = View.GONE
                        renderList(it.data!!)
                        _binding.recyclerView.visibility = View.VISIBLE
                    }
                    Status.LOADING -> {
                        _binding.progressBar.visibility = View.VISIBLE
                        _binding.recyclerView.visibility = View.GONE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        _binding.progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}