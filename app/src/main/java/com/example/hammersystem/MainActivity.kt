package com.example.hammersystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hammersystem.domain.ControllerOpenFragment
import com.example.hammersystem.domain.model.data.DataFood
import com.example.hammersystem.ui.detail.DetailFragment
import com.example.hammersystem.ui.main.MainFragment

class MainActivity : AppCompatActivity(), ControllerOpenFragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_activity_container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun detailOpenFragment(clickDetail: DataFood) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity_container, DetailFragment.newInstance(clickDetail))
            .addToBackStack("")
            .commit()
    }
}