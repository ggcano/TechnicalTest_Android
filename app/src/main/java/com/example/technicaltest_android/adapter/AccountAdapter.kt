package com.example.technicaltest_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaltest_android.R
import com.example.technicaltest_android.model.Pokemon
import kotlinx.android.synthetic.main.item_pokemon_list.view.*

class AccountAdapter : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {

    var pokemons: MutableList<Pokemon> = ArrayList()

    lateinit var context: Context

    fun RecyclerAdapter(pokemons: MutableList<Pokemon>, context: Context) {
        this.pokemons = pokemons
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokemons.get(position)

        holder.mPokemonName.text = item.IBAN
        holder.mPokemonDescription.text = item.balance
        holder.accountName.text = item.accountName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AccountAdapter.ViewHolder(
            layoutInflater.inflate(
                R.layout.item_pokemon_list,
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int {
        return pokemons.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mPokemonName = view.pokemon_label_name as TextView
        val mPokemonDescription = view.pokemon_label_description as TextView
        val accountName = view.txt_account_name as TextView

    }

    fun updateList(datalist: MutableList<Pokemon>) {
        this.pokemons = datalist
        notifyDataSetChanged()
    }
}



