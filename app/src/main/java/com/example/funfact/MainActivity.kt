package com.example.funfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.funfact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var adapter: FactAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupFact()
    }

    private fun setupFact() {
        adapter = FactAdapter(this, DummyData.factLists)
        binding?.factListView?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}