package com.bellemaxime.github.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.bellemaxime.github.R

class DetailFragment : Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView;
    private lateinit var adapter: DetailAdapter
    private lateinit var repoNumbers: TextView


    private val viewModel: DetailViewModel by viewModels()


    companion object {
        private const val KEY_ID = "key_id"

        fun newInstance(login: String): DetailFragment {
            val bundle = Bundle()
            bundle.putString(KEY_ID, login)

            val fragment = DetailFragment()
            fragment.arguments = bundle

            return fragment

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_bar)
        recyclerView = view.findViewById(R.id.user_detail_recycler_view)
        repoNumbers = view.findViewById(R.id.repos_nb)

        adapter = DetailAdapter(requireContext())
        recyclerView.adapter = adapter

        viewModel.state.observe(viewLifecycleOwner, ::updateState)

        arguments?.getString(KEY_ID)?.let {
            viewModel.getUserDetail(it)
        }
    }

    private fun updateState(state: DetailState) {
        when (state) {
            is DetailState.ErrorState -> {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                adapter.setData(null)

            }
            is DetailState.LoadingState -> {
                progressBar.isVisible = true
                adapter.setData(null)
            }
            is DetailState.SuccessState -> {
                progressBar.isVisible = false

                adapter.setData(state.user)
                repoNumbers.text = state.user.size.toString()
            }
        }
    }

}
