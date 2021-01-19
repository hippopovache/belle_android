package com.bellemaxime.github.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.bellemaxime.github.R
import com.bellemaxime.github.presentation.detail.DetailFragment
import com.bellemaxime.github.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private var container2: FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        container2 = findViewById(R.id.fragment_container2)

        supportFragmentManager.commit {
            add(R.id.fragment_container, SearchFragment())
        }

    }

    fun displayUserDetail(login: String) {

        if (container2 != null) {
            println("oui")
            supportFragmentManager.commit {
                replace(R.id.fragment_container2, DetailFragment.newInstance(login))
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, DetailFragment.newInstance(login))
                addToBackStack(null)
            }
        }
    }
}