package com.example.technicaltest_android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.technicaltest_android.model.Pokemon
import com.example.technicaltest_android.R
import com.example.technicaltest_android.adapter.AccountAdapter
import com.example.technicaltest_android.viewmodel.AccountViewModel


class PokemonFragment : Fragment() {
    @BindView(R.id.recycler_main)
    lateinit var mRecyclerView: RecyclerView

    private var viewModel= AccountViewModel ()
    private val mAdapter: AccountAdapter = AccountAdapter()
    var listajajaja: MutableList<Pokemon> = ArrayList()

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
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
       viewModel.getPokemonReceived().observe(this, pokemonObserver)

    }

    fun setUpRecyclerView() {
        mAdapter.RecyclerAdapter(arrayListOf(), requireContext())
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mAdapter
    }
}