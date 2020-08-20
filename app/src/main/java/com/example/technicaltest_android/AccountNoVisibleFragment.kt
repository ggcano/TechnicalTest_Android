package com.example.technicaltest_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.technicaltest_android.adapter.AccountAdapter
import com.example.technicaltest_android.model.Pokemon
import com.example.technicaltest_android.viewmodel.AccountNoVisibleViewModel
import com.example.technicaltest_android.viewmodel.AccountViewModel


class AccountNoVisibleFragment () : Fragment() {
    @BindView(R.id.recycler_main)
    lateinit var mRecyclerView: RecyclerView

    private var viewModel = AccountNoVisibleViewModel()
    val entities = ArrayList<Pokemon>()
    private val mAdapter: AccountAdapter = AccountAdapter()
    private val pokemonObserver = Observer<MutableList<Pokemon>> { pokemonList ->
        mAdapter.updateList(pokemonList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_list, container, false)
        ButterKnife.bind(this, view)
        setUpRecyclerView()
        initViewModel()
        return view
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(AccountNoVisibleViewModel::class.java)
        viewModel.hhhh()


    }

    fun setUpRecyclerView() {
        mAdapter.RecyclerAdapter(arrayListOf(), requireContext())
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mAdapter
    }
}

