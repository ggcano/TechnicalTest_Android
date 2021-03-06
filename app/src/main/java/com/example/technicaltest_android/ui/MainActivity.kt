package com.example.technicaltest_android.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.example.technicaltest_android.R
import com.example.technicaltest_android.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @BindView(R.id.toolbarList)
    lateinit var toolbarList: Toolbar

    @BindView(R.id.mainFragment)
    lateinit var viewPager: ViewPager

    private val listFragment = mutableListOf<Fragment>()
    private val listTitle = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setSupportActionBar(toolbarList)
        toolbarList.setTitle(R.string.app_name)
        toolbarList.setTitleTextColor(Color.WHITE)

        listFragment.add(AccountFragment())
        listFragment.add(AccountNoVisibleFragment())

        listTitle.add(getString(R.string.accounts))
        listTitle.add(getString(R.string.accounts_no_visible))

        val viewPagerAdapter =
            ViewPagerAdapter(
                supportFragmentManager,
                listFragment,
                listTitle
            )
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }
}