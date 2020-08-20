package com.example.technicaltest_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaltest_android.R
import com.example.technicaltest_android.model.Account
import kotlinx.android.synthetic.main.item_account_list.view.*

class AccountAdapter : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {

    var accountList: MutableList<Account> = ArrayList()

    lateinit var context: Context

    fun RecyclerAdapter(accounts: MutableList<Account>, context: Context) {
        this.accountList = accounts
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = accountList.get(position)

        holder.accountIban.text = item.IBAN
        holder.accountBalance.text = item.balance
        holder.accountName.text = item.accountName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_account_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return accountList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val accountIban = view.account_label_iban as TextView
        val accountBalance = view.account_label_balance as TextView
        val accountName = view.txt_account_name as TextView

    }

    fun updateList(datalist: MutableList<Account>) {
        this.accountList = datalist
        notifyDataSetChanged()
    }

    fun noVisibleAccount () {
        val newList = ArrayList<Account>()
            for (list in accountList) {
                if (!list.isVisibleAcoount) {
                    newList.add(list)
                }
            }
        notifyDataSetChanged()
    }
}



